package com.esbteam.fleamarket.service.impl;

import com.esbteam.fleamarket.FleamarketApplicationTests;
import com.esbteam.fleamarket.enums.ResponseEnum;
import com.esbteam.fleamarket.form.ShippingForm;
import com.esbteam.fleamarket.pojo.Shipping;
import com.esbteam.fleamarket.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Author hanjiabei
 * @Date 2020/8/5 4:57 下午
 **/
@Slf4j
public class ShippingServiceImplTest extends FleamarketApplicationTests {

    @Autowired
    private ShippingServiceImpl shippingService;

    private final String uid = "1";

    Integer shippingId;

    private ShippingForm form;

    @Before
    public void before(){
        form = new ShippingForm();
        form.setReceiverName("Jiabei Han");
        form.setReceiverAddress("8026 Avenida Navidad");
        form.setReceiverCity("San Diego");
        form.setReceiverMobile("8583491027");
        form.setReceiverPhone("8583491027");
        form.setReceiverState("CA");
        form.setReceiverDistrict("La Jolla");
        form.setReceiverZip("92122");
        add();
    }

    public void add() {
        ResponseVo<Map<String, Integer>> responseVo = shippingService.add(uid, form);
        log.info("【shipping添加测试】responseVo={}",responseVo);
        this.shippingId = responseVo.getData().get("shippingId");
        log.info("shippingId, {}",shippingId);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @After
    public void delete() {
        ResponseVo responseVo = shippingService.delete(uid, shippingId);
        log.info("【shipping删除测试】responseVo={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void update() {
        form.setReceiverCity("Los Angeles");
        ResponseVo responseVo = shippingService.update(uid, shippingId,form);
        log.info("【shipping更新测试】responseVo={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void list() {
        ResponseVo<PageInfo<Shipping>> responseVo = shippingService.list(uid, 1,10);
        log.info("【shipping列表测试】responseVo={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }
}