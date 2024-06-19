package com.esbteam.fleamarket.converter;

import com.esbteam.fleamarket.pojo.Category;
import com.esbteam.fleamarket.vo.CategoryVo;
import org.springframework.beans.BeanUtils;
public class Category2CategoryVo {

    public static CategoryVo convert(Category category){
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);
        return categoryVo;
    }
}
