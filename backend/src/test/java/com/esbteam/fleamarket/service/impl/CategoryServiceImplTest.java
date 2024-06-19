package com.esbteam.fleamarket.service.impl;

import com.esbteam.fleamarket.FleamarketApplicationTests;
import com.esbteam.fleamarket.enums.ResponseEnum;
import com.esbteam.fleamarket.vo.CategoryVo;
import com.esbteam.fleamarket.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author hanjiabei
 * @Date 2020/7/12 11:24 上午
 **/
@Slf4j
public class CategoryServiceImplTest extends FleamarketApplicationTests {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void selectAll() {
        ResponseVo<List<CategoryVo>> responseVo = categoryService.selectAll();
        log.info("【QUERY ALL CATEGORIES】result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void findSubCategoryId() {
    }
}