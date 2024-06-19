package com.esbteam.fleamarket.controller;

import com.esbteam.fleamarket.service.impl.CategoryServiceImpl;
import com.esbteam.fleamarket.vo.CategoryVo;
import com.esbteam.fleamarket.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName CategoryController
 * @Description
 * @Author hanjiabei
 * @Date 2020/7/12 11:48 上午
 **/
@RestController
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/categories")
    public ResponseVo<List<CategoryVo>> selectAll(){
        return categoryService.selectAll();
    }
}
