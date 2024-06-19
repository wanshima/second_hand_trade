package com.esbteam.fleamarket.service.impl;

import com.esbteam.fleamarket.consts.FleaMarketConst;
import com.esbteam.fleamarket.converter.Category2CategoryVo;
import com.esbteam.fleamarket.dao.CategoryMapper;
import com.esbteam.fleamarket.pojo.Category;
import com.esbteam.fleamarket.service.ICategoryService;
import com.esbteam.fleamarket.vo.CategoryVo;
import com.esbteam.fleamarket.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName CategoryServiceImpl
 * @Description
 * @Author hanjiabei
 * @Date 2020/7/12 10:37 上午
 **/
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ResponseVo<List<CategoryVo>> selectAll() {
        List<Category> categoryList = categoryMapper.selectAll();

        //1. 查出所有根目录
        List<CategoryVo> categoryVoList = categoryList.stream()
                .filter(e->e.getParentId().equals(FleaMarketConst.ROOT_PARENT_ID))
                .map(Category2CategoryVo::convert)
                .sorted(Comparator.comparing(CategoryVo::getSortOrder).reversed())
                .collect(Collectors.toList());

        //2. 继续查询所有子目录
        findSubCategories(categoryVoList,categoryList);

        return ResponseVo.success(categoryVoList);
    }

    @Override
    public void findSubCategoryId(Integer id, Set<Integer> resultSet) {
        List<Category> categoryList = categoryMapper.selectAll();
        findSubCategoryId(id,resultSet,categoryList);
    }

    private void findSubCategories(List<CategoryVo> categoryVoList, List<Category> categories){
        for (CategoryVo categoryVo : categoryVoList){
            List<CategoryVo> subCategoryVoList = new ArrayList<>();

            for (Category category : categories){
                //如果查到内容，设置subCategory，继续向下查
                if (categoryVo.getCategoryId().equals(category.getParentId())){
                    CategoryVo subCategoryVo = Category2CategoryVo.convert(category);
                    subCategoryVoList.add(subCategoryVo);
                }
                subCategoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());
                categoryVo.setSubCategories(subCategoryVoList);
                findSubCategories(subCategoryVoList,categories);
            }
        }
    }

    private void findSubCategoryId(Integer id, Set<Integer> resultSet, List<Category> categoryList){
        for (Category category : categoryList){
            if (id.equals(category.getParentId())){
                resultSet.add(category.getCategoryId());
                findSubCategoryId(category.getCategoryId(),resultSet,categoryList);
            }
        }
    }

}
