package com.esbteam.fleamarket.service.impl;

import com.esbteam.fleamarket.FleamarketApplicationTests;
import com.esbteam.fleamarket.enums.ResponseEnum;
import com.esbteam.fleamarket.form.ProductCreateForm;
import com.esbteam.fleamarket.form.ProductUpdateForm;
import com.esbteam.fleamarket.vo.ProductDetailVo;
import com.esbteam.fleamarket.vo.ProductVo;
import com.esbteam.fleamarket.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @Author hanjiabei
 * @Date 2020/7/12 7:37 下午
 **/
public class ProductServiceImplTest extends FleamarketApplicationTests {

    @Autowired
    private ProductServiceImpl productService;

    private static final String PRODUCT_ID = "26";

    private static final String SELLER_ID = "1";

    @Test
    public void list() {
        ResponseVo<PageInfo<ProductVo>> responseVo = productService.list(0, 2, 2);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void detail() {
        ResponseVo<ProductDetailVo> responseVo = productService.detail(PRODUCT_ID);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void listBySellerId(){
        ResponseVo<PageInfo<ProductVo>> responseVo = productService.listBySellerId(SELLER_ID, 2, 2);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void create(){
        ProductCreateForm productCreateForm = new ProductCreateForm();
        productCreateForm.setCategoryId(100413);
        productCreateForm.setName("2016 Honda Civic");
        productCreateForm.setPrice(BigDecimal.valueOf(15000));
        productCreateForm.setStock(1);
        ResponseVo<ProductDetailVo> responseVo = productService.create("1", productCreateForm);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void update(){
        ProductUpdateForm productUpdateForm = new ProductUpdateForm();
        productUpdateForm.setStock(3);
        productUpdateForm.setPrice(BigDecimal.valueOf(14000));
        ResponseVo responseVo = productService.update("1","1594702256159890728",productUpdateForm);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }
}