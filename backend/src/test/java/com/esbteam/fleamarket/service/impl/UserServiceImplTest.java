package com.esbteam.fleamarket.service.impl;

import com.esbteam.fleamarket.FleamarketApplicationTests;
import com.esbteam.fleamarket.enums.ResponseEnum;
import com.esbteam.fleamarket.pojo.UserInfo;
import com.esbteam.fleamarket.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author hanjiabei
 * @Date 2020/7/9 9:31 下午
 **/
@Slf4j
public class UserServiceImplTest extends FleamarketApplicationTests {

    private static final String USERNAME="neo";

    private static final String PASSWORD="123456";

    private static final String USER_EMAIL="1@com";

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void register() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("1");
        userInfo.setUsername("admin");
        userInfo.setPassword("admin");
        userInfo.setUserEmail("admin@admin");
        ResponseVo<UserInfo> responseVo = userService.register(userInfo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void login() {
        ResponseVo<UserInfo> responseVo = userService.login(USER_EMAIL,PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }
}