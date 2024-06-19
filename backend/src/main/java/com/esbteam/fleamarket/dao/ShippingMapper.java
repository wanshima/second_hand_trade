package com.esbteam.fleamarket.dao;

import com.esbteam.fleamarket.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

    Shipping selectByShippingIdAndUid(@Param("id") Integer id, @Param("userId") String userId);

    List<Shipping> selectByIdSet(@Param("idSet") Set idSet);

    int deleteByIdAndUid(@io.lettuce.core.dynamic.annotation.Param("uid") String uid,
                         @io.lettuce.core.dynamic.annotation.Param("shippingId") Integer shippingId);

    List<Shipping> selectByUserId(String uid);
}