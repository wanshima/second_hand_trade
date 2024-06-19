package com.esbteam.fleamarket.dao;

import com.esbteam.fleamarket.FleamarketApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author hanjiabei
 * @Date 2020/7/9 9:38 下午
 **/
public class UserInfoMapperTest extends FleamarketApplicationTests {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void selectByPrimaryKey() {
        userInfoMapper.selectByPrimaryKey("123");
    }
}