package com.esbteam.fleamarket.service;

import com.esbteam.fleamarket.vo.OrderVo;
import com.esbteam.fleamarket.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

public interface IOrderService {

    ResponseVo<OrderVo> create(String uid, Integer shippingId);

    ResponseVo<PageInfo> list(String buyerId, Integer pageNum, Integer pageSize);

    ResponseVo<OrderVo> detail(String buyerId, String orderId);

    ResponseVo cancel(String buyerId, String orderId);

    void paid(String orderId);
}
