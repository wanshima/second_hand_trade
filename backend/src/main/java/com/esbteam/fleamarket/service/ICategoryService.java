package com.esbteam.fleamarket.service;

import com.esbteam.fleamarket.vo.CategoryVo;
import com.esbteam.fleamarket.vo.ResponseVo;

import java.util.List;
import java.util.Set;

public interface ICategoryService {

    ResponseVo<List<CategoryVo>> selectAll();

    void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
