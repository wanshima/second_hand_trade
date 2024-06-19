package com.esbteam.fleamarket.converter;

import com.esbteam.fleamarket.pojo.Product;
import com.esbteam.fleamarket.vo.ProductDetailVo;
import org.springframework.beans.BeanUtils;
public class Product2ProductDetailVo {

    public static ProductDetailVo convert(Product product){
        ProductDetailVo productDetailVo = new ProductDetailVo();
        BeanUtils.copyProperties(product,productDetailVo);
        return productDetailVo;
    }
}
