package com.esbteam.fleamarket.service.impl;

import com.esbteam.fleamarket.FleamarketApplicationTests;
import com.esbteam.fleamarket.enums.ResponseEnum;
import com.esbteam.fleamarket.form.CartAddForm;
import com.esbteam.fleamarket.form.CartUpdateForm;
import com.esbteam.fleamarket.vo.CartVo;
import com.esbteam.fleamarket.vo.ResponseVo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author hanjiabei
 * @Date 2020/7/16 8:40 下午
 **/
@Slf4j
public class CartServiceImplTest extends FleamarketApplicationTests {

    @Autowired
    private CartServiceImpl cartService;

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private final String uid = "1";

    private final String productId = "26";

    @Before
    public void add() {
        log.info("【ADD ITEMS TO CART】");
        CartAddForm cartAddForm = new CartAddForm();
        cartAddForm.setProductId(productId);
        cartAddForm.setSelected(true);
        ResponseVo<CartVo> responseVo = cartService.add(uid, cartAddForm);
        log.info("【TEST LIST】list={}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void list() {
        ResponseVo<CartVo> responseVo = cartService.list(uid);
        log.info("【TEST list】list={}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void update(){
        CartUpdateForm form = new CartUpdateForm();
        form.setQuantity(5); form.setSelected(false);
        ResponseVo<CartVo> responseVo = cartService.update(uid,productId,form);
        log.info("【TEST list】list={}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void selectAll(){
        ResponseVo<CartVo> responseVo = cartService.selectAll(uid);
        log.info("【TEST list】list={}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void unSelectAll(){
        ResponseVo<CartVo> responseVo = cartService.unSelectAll(uid);
        log.info("TEST list】list={}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void sum(){
        ResponseVo<Integer> responseVo = cartService.sum(uid);
        log.info("【TEST list】list={}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @After
    public void delete(){
        log.info("【DELETE CART】");
        ResponseVo<CartVo> responseVo = cartService.delete(uid,productId);
        log.info("【TEST list】list={}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }
}