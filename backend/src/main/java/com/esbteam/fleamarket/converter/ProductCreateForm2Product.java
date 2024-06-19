package com.esbteam.fleamarket.converter;

import com.esbteam.fleamarket.form.ProductCreateForm;
import com.esbteam.fleamarket.pojo.Product;
import com.esbteam.fleamarket.utils.ProductIdUtil;
import org.springframework.beans.BeanUtils;

public class ProductCreateForm2Product {

    public static Product convert(String userId, ProductCreateForm form){
        Product product = new Product();
        BeanUtils.copyProperties(form,product);
        product.setProductId(ProductIdUtil.genUniqueKey());
        product.setSellerId(userId);
        return product;
    }
}
