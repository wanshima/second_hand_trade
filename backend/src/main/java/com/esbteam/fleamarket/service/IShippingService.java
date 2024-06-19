package com.esbteam.fleamarket.service;

import com.esbteam.fleamarket.form.ShippingForm;
import com.esbteam.fleamarket.pojo.Shipping;
import com.esbteam.fleamarket.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface IShippingService {

    ResponseVo<Map<String,Integer>> add(String uid, ShippingForm form);

    ResponseVo delete(String uid, Integer shippingId);

    ResponseVo update(String uid, Integer shippingId, ShippingForm form);

    ResponseVo<PageInfo<Shipping>> list(String uid, Integer pageNum, Integer pageSize);
}
