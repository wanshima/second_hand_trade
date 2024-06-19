package com.esbteam.fleamarket.converter;

import com.esbteam.fleamarket.dao.ProductMapper;
import com.esbteam.fleamarket.dao.UserInfoMapper;
import com.esbteam.fleamarket.pojo.Product;
import com.esbteam.fleamarket.pojo.UserInfo;
import com.esbteam.fleamarket.vo.ProductVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
public class Product2ProductVo {

    public static ProductVo convert (Product product) throws RuntimeException{
        ProductVo productVo = new ProductVo();
        BeanUtils.copyProperties(product,productVo);
        return productVo;
    }

}
