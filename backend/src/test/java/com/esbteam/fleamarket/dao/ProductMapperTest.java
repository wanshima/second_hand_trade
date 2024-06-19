package com.esbteam.fleamarket.dao;

import com.esbteam.fleamarket.FleamarketApplicationTests;
import com.esbteam.fleamarket.consts.FleaMarketConst;
import com.esbteam.fleamarket.pojo.Product;
import com.esbteam.fleamarket.vo.ProductVo;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author hanjiabei
 * @Date 2020/7/14 5:36 下午
 **/
@Slf4j
public class ProductMapperTest extends FleamarketApplicationTests {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testSelectJoinUser() {
        Set<Integer> categoryIdSet = new HashSet<>(); categoryIdSet.add(100413);
        List<ProductVo> productVoList = productMapper.selectJoinUserByCategoryIdSet(categoryIdSet);
        log.info("productVoList = {}",productVoList);
    }
}