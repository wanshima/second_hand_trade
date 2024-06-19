package com.esbteam.fleamarket.service.impl;

import com.esbteam.fleamarket.converter.CartANDProduct2CartProduct;
import com.esbteam.fleamarket.dao.ProductMapper;
import com.esbteam.fleamarket.enums.ProductStatusEnum;
import com.esbteam.fleamarket.enums.ResponseEnum;
import com.esbteam.fleamarket.form.CartAddForm;
import com.esbteam.fleamarket.form.CartUpdateForm;
import com.esbteam.fleamarket.pojo.Cart;
import com.esbteam.fleamarket.pojo.Product;
import com.esbteam.fleamarket.service.ICartService;
import com.esbteam.fleamarket.vo.CartProductVo;
import com.esbteam.fleamarket.vo.CartVo;
import com.esbteam.fleamarket.vo.ResponseVo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * @ClassName CartServiceImpl
 * @Description
 * @Author hanjiabei
 * @Date 2020/7/16 7:44 下午
 **/
@Service
public class CartServiceImpl implements ICartService {

    private final static String CART_REDIS_KEY_TEMPLATE = "cart_%s";

    private final Gson gson = new Gson();

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public ResponseVo<CartVo> list(String uid) {
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE,uid);

        CartVo cartVo = new CartVo();
        boolean selectedAll = true;
        Integer cartTotalQuantity = 0;
        BigDecimal cartTotalPrice = BigDecimal.valueOf(0);
        List<CartProductVo> cartProductVoList = new ArrayList<>();

        //将所有的商品id提取出来
        Map<String,String> entries = opsForHash.entries(redisKey);
        Set<String> productIdSet = new HashSet<>(entries.keySet());
        List<Product> productList = productMapper.selectByProductIdSet(productIdSet);

        for (Product product : productList){
            String productId = product.getProductId();
            Cart cart = gson.fromJson(entries.get(productId),Cart.class);
            CartProductVo cartProductVo = CartANDProduct2CartProduct.convert(product,cart);
            cartProductVoList.add(cartProductVo);
            selectedAll = selectedAll && cart.getProductSelected();

            //计算总价（只计算选中的）
            if (cart.getProductSelected()){
                cartTotalPrice = cartTotalPrice.add(cartProductVo.getProductTotalPrice());
            }
            cartTotalQuantity += cart.getQuantity();
        }

        cartVo.setCartProductVoList(cartProductVoList);
        cartVo.setSelectedAll(selectedAll);
        cartVo.setCartTotalQuantity(cartTotalQuantity);
        cartVo.setCartTotalPrice(cartTotalPrice);
        return ResponseVo.success(cartVo);
    }

    @Override
    public ResponseVo<CartVo> add(String uid, CartAddForm form) {
        Integer quantity = 1;

        Product product = productMapper.selectByPrimaryKey(form.getProductId());

        //1. 判断商品是否存在
        if (product == null){
            return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST);
        }

        //2. 判断商品是否正常在售
        if (!product.getStatus().equals(ProductStatusEnum.ON_SALE.getCode())){
            return ResponseVo.error(ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE);
        }

        //3. 判断商品库存是否充足
        if (product.getStock() <= 0){
            return ResponseVo.error(ResponseEnum.PRODUCT_STOCK_ERROR);
        }

        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE,uid);

        Cart cart;
        String value = opsForHash.get(redisKey, String.valueOf(product.getProductId()));
        if (StringUtils.isEmpty(value)){
            //没有该商品
            cart = new Cart(product.getProductId(),quantity,form.getSelected());
        }else{
            //该商品存在
            cart = gson.fromJson(value,Cart.class);
            cart.setQuantity(cart.getQuantity()+quantity);
        }

        opsForHash.put(redisKey,product.getProductId(),gson.toJson(cart));
        return list(uid);
    }

    @Override
    public ResponseVo<CartVo> update(String uid, String productId, CartUpdateForm cartUpdateForm) {
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE,uid);

        String value = opsForHash.get(redisKey,productId);
        if (StringUtils.isEmpty(value)){
            //数据有问题
            return ResponseVo.error(ResponseEnum.CART_PRODUCT_NOT_EXIST);
        }

        //数据存在，修改内容
        Cart cart = gson.fromJson(value,Cart.class);
        if (cartUpdateForm.getQuantity() != null && cartUpdateForm.getQuantity() >= 0){
            cart.setQuantity(cartUpdateForm.getQuantity());
        }
        if (cartUpdateForm.getSelected() != null){
            cart.setProductSelected(cartUpdateForm.getSelected());
        }
        opsForHash.put(redisKey,String.valueOf(productId),gson.toJson(cart));

        return list(uid);
    }

    @Override
    public ResponseVo<CartVo> delete(String uid, String productId) {
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE,uid);

        String value = opsForHash.get(redisKey,productId);
        if (StringUtils.isEmpty(value)){
            //没有该商品，数据有问题
            return ResponseVo.error(ResponseEnum.CART_PRODUCT_NOT_EXIST);
        }
        //已经有，修改内容
        opsForHash.delete(redisKey,productId);
        return list(uid);
    }

    @Override
    public ResponseVo<CartVo> selectAll(String uid) {
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE,uid);

        for (Cart cart : listForCart(uid)){
            cart.setProductSelected(true);
            opsForHash.put(redisKey,cart.getProductId(),gson.toJson(cart));
        }
        return list(uid);
    }

    @Override
    public ResponseVo<CartVo> unSelectAll(String uid) {
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE,uid);

        for (Cart cart : listForCart(uid)){
            cart.setProductSelected(false);
            opsForHash.put(redisKey,cart.getProductId(),gson.toJson(cart));
        }
        return list(uid);
    }

    @Override
    public ResponseVo<Integer> sum(String uid) {
        Integer sum = listForCart(uid).stream()
                .map(Cart::getQuantity)
                .reduce(0,Integer::sum);
        return ResponseVo.success(sum);
    }

    @Override
    public List<Cart> listForCart(String uid) {
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE,uid);
        Map<String, String> entries = opsForHash.entries(redisKey);

        List<Cart> cartList = new ArrayList<>();
        for (Map.Entry<String, String> entry : entries.entrySet()) {
            cartList.add(gson.fromJson(entry.getValue(),Cart.class));
        }
        return cartList;
    }
}
