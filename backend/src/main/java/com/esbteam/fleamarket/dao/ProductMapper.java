package com.esbteam.fleamarket.dao;

import com.esbteam.fleamarket.pojo.Product;
import com.esbteam.fleamarket.vo.ProductVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface ProductMapper {
    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectBySellerId(String sellerId);

    List<Product> selectByCategoryIdSet(@Param("categoryIdSet") Set<Integer> categoryIdSet);

    List<Product> selectByProductIdSet(@Param("productIdSet") Set<String> productIdSet);

    List<ProductVo> selectJoinUserByCategoryIdSet(@Param("categoryIdSet") Set<Integer> categoryIdSet);
}