package com.esbteam.fleamarket.service.impl;

import com.esbteam.fleamarket.FleamarketApplicationTests;
import com.esbteam.fleamarket.enums.ResponseEnum;
import com.esbteam.fleamarket.form.CartAddForm;
import com.esbteam.fleamarket.service.ICartService;
import com.esbteam.fleamarket.service.IOrderService;
import com.esbteam.fleamarket.vo.CartVo;
import com.esbteam.fleamarket.vo.OrderVo;
import com.esbteam.fleamarket.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
public class OrderServiceImplTest extends FleamarketApplicationTests {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private ICartService cartService;

    private String uid = "1";

    private Integer shippingId = 2;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private final String productId = "26";

    @Before
    public void before() {
        log.info("【ADD ITEMS TO CART】");
        CartAddForm cartAddForm = new CartAddForm();
        cartAddForm.setProductId(productId);
        cartAddForm.setSelected(true);
        ResponseVo<CartVo> responseVo = cartService.add(uid, cartAddForm);
        log.info("【TEST LIST】list={}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void createTest() {
        ResponseVo<OrderVo> responseVo = testCreate();
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    private ResponseVo<OrderVo> testCreate() {
        ResponseVo<OrderVo> responseVo = orderService.create(uid, shippingId);
        log.info("response={}", gson.toJson(responseVo));
        return responseVo;
    }

    @Test
    public void testList() {
        ResponseVo<PageInfo> responseVo = orderService.list(uid, 1, 2);
        log.info("response={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void testDetail() {
        ResponseVo<OrderVo> vo = testCreate();
        ResponseVo<OrderVo> responseVo = orderService.detail(uid, vo.getData().getOrderId());
        log.info("response={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void testCancel() {
        ResponseVo<OrderVo> vo = testCreate();
        ResponseVo responseVo = orderService.cancel(uid, vo.getData().getOrderId());
        log.info("response={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }
}