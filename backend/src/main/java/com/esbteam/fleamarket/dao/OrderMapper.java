package com.esbteam.fleamarket.dao;

import com.esbteam.fleamarket.pojo.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectByBuyerId(String buyerId);

    Order selectByOrderId(String orderId);
}