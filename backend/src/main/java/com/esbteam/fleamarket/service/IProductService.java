package com.esbteam.fleamarket.service;

import com.esbteam.fleamarket.form.ProductCreateForm;
import com.esbteam.fleamarket.form.ProductUpdateForm;
import com.esbteam.fleamarket.vo.ProductDetailVo;
import com.esbteam.fleamarket.vo.ProductVo;
import com.esbteam.fleamarket.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

public interface IProductService {

    ResponseVo<PageInfo<ProductVo>> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(String productId);

    ResponseVo<PageInfo<ProductVo>> listBySellerId(String sellerId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> create(String userId, ProductCreateForm form);

    ResponseVo update(String userId, String productId, ProductUpdateForm form);

}
