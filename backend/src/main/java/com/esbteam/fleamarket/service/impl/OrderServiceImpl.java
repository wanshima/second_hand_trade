package com.esbteam.fleamarket.service.impl;

import com.esbteam.fleamarket.dao.*;
import com.esbteam.fleamarket.enums.OrderStatusEnum;
import com.esbteam.fleamarket.enums.PaymentTypeEnum;
import com.esbteam.fleamarket.enums.ProductStatusEnum;
import com.esbteam.fleamarket.enums.ResponseEnum;
import com.esbteam.fleamarket.pojo.*;
import com.esbteam.fleamarket.service.ICartService;
import com.esbteam.fleamarket.service.IOrderService;
import com.esbteam.fleamarket.vo.OrderItemVo;
import com.esbteam.fleamarket.vo.OrderVo;
import com.esbteam.fleamarket.vo.ResponseVo;
import com.esbteam.fleamarket.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rabbitmq.client.RpcClient;
import lombok.val;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static com.esbteam.fleamarket.utils.OrderIdUtil.genUniqueKey;

/**
 * @ClassName OrderServiceImpl
 * @Description
 * @Author Chang Zhou
 * @Date 2020/7/25 10:33 PM
 **/

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private ShippingMapper shippingMapper;

    @Autowired
    private ICartService cartService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    @Transactional
    public ResponseVo<OrderVo> create(String buyerId, Integer shippingId) {
        // Verify shipping address
        Shipping shipping = shippingMapper.selectByShippingIdAndUid(shippingId, buyerId);
        if (shipping == null) {
            return ResponseVo.error(ResponseEnum.SHIPPING_ADDRESS_NOT_EXIST);
        }

        // Get cart
        List<Cart> cartList = cartService.listForCart(buyerId).stream()
                .filter(Cart::getProductSelected)
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(cartList)) {
            return ResponseVo.error(ResponseEnum.CART_SELECTED_IS_EMPTY);
        }

        // Verify items and stocks
        Set<String> productIdSet = cartList.stream()
                .map(Cart::getProductId)
                .collect(Collectors.toSet());

        //TODO 改进为微服务框架
        List<Product> productList = productMapper.selectByProductIdSet(productIdSet);
        Map<String, Product> map = productList.stream()
                .collect(Collectors.toMap(Product::getProductId, product -> product));

        List<OrderItem> orderItemList = new ArrayList<>();
        String orderId = genUniqueKey();

        for (Cart cart: cartList) {
            // Verify item
            Product product = map.get(cart.getProductId());
            if (product == null) {
                return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST,
                        "product does not exist. productId = " + cart.getProductId());
            }
            // Verify item status
            if (!ProductStatusEnum.ON_SALE.getCode().equals(product.getStatus())) {
                return ResponseVo.error(ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE,
                        "product off sale or deleted. " + product.getName());
            }

            // Verify stock
            if (product.getStock() < cart.getQuantity()) {
                return ResponseVo.error(ResponseEnum.PRODUCT_STOCK_ERROR,
                        "product stock error.  = " + product.getName());
            }

            String orderItemId = genUniqueKey();
            OrderItem orderItem = buildOrderItem(orderItemId, orderId, cart.getQuantity(), product);
            orderItemList.add(orderItem);

            // Decrease stock
            // TODO 改进为微服务架构
            product.setStock(product.getStock() - cart.getQuantity());
            int row = productMapper.updateByPrimaryKeySelective(product);
            if (row <= 0) {
                return ResponseVo.error(ResponseEnum.ERROR);
            }

        }

        // Calculate total price, only sum selected items
        // Generate Order and OrderItem (Transaction)
        Order order = buildOrder(buyerId, orderId, shippingId, orderItemList);

        int rowForOrder = orderMapper.insertSelective(order);
        if (rowForOrder <= 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        int rowForOrderItem = orderItemMapper.batchInsert(orderItemList);
        if (rowForOrderItem <= 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        // Clear selected cart items
        for (Cart cart: cartList) {
            cartService.delete(buyerId, cart.getProductId());
        }

        // New an OrderVo item
        OrderVo orderVo = buildOrderVo(order, orderItemList, shipping);
        return ResponseVo.success(orderVo);
    }

    @Override
    public ResponseVo<PageInfo> list(String buyerId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderMapper.selectByBuyerId(buyerId);
        Set<String> orderIdSet = orderList.stream()
                .map(Order::getOrderId)
                .collect(Collectors.toSet());
        List<OrderItem> orderItemList = orderItemMapper.selectByOrderIdSet(orderIdSet);
        Map<String, List<OrderItem>> orderItemMap = orderItemList.stream()
                .collect(Collectors.groupingBy(OrderItem::getOrderId));

        Set<Integer> shippingIdSet = orderList.stream()
                .map(Order::getShippingId)
                .collect(Collectors.toSet());
        List<Shipping> shippingList = shippingMapper.selectByIdSet(shippingIdSet);
        Map<Integer, Shipping> shippingMap = shippingList.stream()
                .collect(Collectors.toMap(Shipping::getId, shipping -> shipping));

        List<OrderVo> orderVoList = new ArrayList<>();
        for (Order order : orderList) {
            OrderVo orderVo = buildOrderVo(order,
                    orderItemMap.get(order.getOrderId()),
                    shippingMap.get(order.getShippingId()));
            orderVoList.add(orderVo);
        }
        PageInfo pageInfo = new PageInfo(orderList);
        pageInfo.setList(orderVoList);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<OrderVo> detail(String buyerId, String orderId) {
        Order order = orderMapper.selectByOrderId(orderId);
        if (order == null || !order.getBuyerId().equals(buyerId)) {
            return ResponseVo.error(ResponseEnum.ORDER_NOT_EXIST);
        }
        Set<String> orderIdSet = new HashSet<>();
        orderIdSet.add(order.getOrderId());
        List<OrderItem> orderItemList = orderItemMapper.selectByOrderIdSet(orderIdSet);
        Shipping shipping = shippingMapper.selectByPrimaryKey(order.getShippingId());
        OrderVo orderVo = buildOrderVo(order, orderItemList, shipping);
        return ResponseVo.success(orderVo);
    }

    @Override
    public ResponseVo cancel(String buyerId, String orderId) {
        Order order = orderMapper.selectByOrderId(orderId);
        if (order == null || !order.getBuyerId().equals(buyerId)) {
            return ResponseVo.error(ResponseEnum.ORDER_NOT_EXIST);
        }
        if (!order.getStatus().equals(OrderStatusEnum.UNPAID.getCode())) {
            return ResponseVo.error(ResponseEnum.ORDER_STATUS_ERROR);
        }

        order.setStatus(OrderStatusEnum.CANCELED.getCode());
        order.setCloseTime(new Date());
        int row = orderMapper.updateByPrimaryKeySelective(order);
        if (row <= 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.success();
    }

    @Override
    public void paid(String orderId) {
        Order order = orderMapper.selectByOrderId(orderId);
        if (order == null) {
            throw new RuntimeException(ResponseEnum.ORDER_NOT_EXIST.getMessage() + "Order id: " + orderId);
        }
        if (!order.getStatus().equals(OrderStatusEnum.UNPAID.getCode())) {
            throw new RuntimeException(ResponseEnum.ORDER_STATUS_ERROR.getMessage() + "Order id: " + orderId);
        }

        order.setStatus(OrderStatusEnum.PAID.getCode());
        order.setPaymentTime(new Date());
        int row = orderMapper.updateByPrimaryKeySelective(order);
        if (row <= 0) {
            throw new RuntimeException("Failed to update order status" + "Order id: " + orderId);
        }
    }

    private OrderVo buildOrderVo(Order order, List<OrderItem> orderItemList, Shipping shipping) {
        OrderVo orderVo = new OrderVo();
        BeanUtils.copyProperties(order, orderVo);

        List<OrderItemVo> orderItemVoList = orderItemList.stream().map(e -> {
            OrderItemVo orderItemVo = new OrderItemVo();
            BeanUtils.copyProperties(e, orderItemVo);
            return orderItemVo;
        }).collect(Collectors.toList());

        orderVo.setOrderItemVoList(orderItemVoList);
        if (shipping != null) {
            orderVo.setShippingId(shipping.getId());
            orderVo.setShippingVo(shipping);
        }
        return orderVo;
    }

    private Order buildOrder(String buyerId, String orderId, Integer shippingId, List<OrderItem> orderItemList) {

        BigDecimal payment = orderItemList.stream().map(OrderItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        Order order = new Order();
        order.setOrderId(orderId);
        order.setBuyerId(buyerId);
        order.setShippingId(shippingId);
        UserInfo buyer = userInfoMapper.selectByPrimaryKey(buyerId);
        order.setBuyerPhone(buyer.getUserPhone());
        order.setBuyerUsername(buyer.getUsername());
        order.setBuyerOpenid(buyer.getOpenid());
        order.setBuyerAddress(buyer.getUserAddress());
        order.setOrderAmount(payment);
        order.setPayment(payment);
        order.setPaymentType(PaymentTypeEnum.PAY_ONLINE.getCode());
        order.setStatus(OrderStatusEnum.UNPAID.getCode());
        return order;
    }


    private OrderItem buildOrderItem(String orderItemId, String orderId, Integer quantity, Product product) {
        OrderItem item = new OrderItem();
        item.setItemId(orderItemId);
        item.setOrderId(orderId);
        item.setProductId(product.getProductId());
        item.setSellerId(product.getSellerId());
        UserInfo seller = userInfoMapper.selectByPrimaryKey(product.getSellerId());
        item.setSellerUsername(seller.getUsername());
        item.setSellerPhone(seller.getUserPhone());
        item.setProductName(product.getName());
        item.setProductImage(product.getMainImage());
        item.setCurrentUnitPrice(product.getPrice());
        item.setProductQuantity(quantity);
        item.setTotalPrice(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
        return item;
    }
}
