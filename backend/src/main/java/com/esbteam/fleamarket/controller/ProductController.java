package com.esbteam.fleamarket.controller;

import com.esbteam.fleamarket.consts.FleaMarketConst;
import com.esbteam.fleamarket.form.ProductCreateForm;
import com.esbteam.fleamarket.form.ProductUpdateForm;
import com.esbteam.fleamarket.pojo.UserInfo;
import com.esbteam.fleamarket.service.impl.ProductServiceImpl;
import com.esbteam.fleamarket.vo.ProductDetailVo;
import com.esbteam.fleamarket.vo.ProductVo;
import com.esbteam.fleamarket.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @ClassName ProductController
 * @Description
 * @Author hanjiabei
 * @Date 2020/7/12 11:08 下午
 **/
@Slf4j
@RestController
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/products")
    public ResponseVo<PageInfo<ProductVo>> list(@RequestParam(required=false) Integer categoryId,
                                                @RequestParam(required=false,defaultValue = "1") Integer pageNum,
                                                @RequestParam(required=false,defaultValue = "10") Integer pageSize){
        return productService.list(categoryId,pageNum,pageSize);
    }

    @GetMapping("/products/{productId}")
    public ResponseVo<ProductDetailVo> detail(@PathVariable String productId){
        return productService.detail(productId);
    }

    @PostMapping("/products/create")
    public ResponseVo<ProductDetailVo> create(@Valid @RequestBody ProductCreateForm form,
                                              HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);
        return productService.create(userInfo.getUserId(),form);
    }

    @PostMapping("/products/update")
    public ResponseVo update(@RequestBody ProductUpdateForm form,
                             @RequestParam String productId,
                             HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);
        return productService.update(userInfo.getUserId(),productId,form);
    }

    @GetMapping("/products/user")
    public ResponseVo<PageInfo<ProductVo>> list(@RequestParam String uid,
                                                @RequestParam(required=false,defaultValue = "1") Integer pageNum,
                                                @RequestParam(required=false,defaultValue = "10") Integer pageSize){
        return productService.listBySellerId(uid,pageNum,pageSize);
    }

}
