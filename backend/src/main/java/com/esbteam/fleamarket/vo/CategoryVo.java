package com.esbteam.fleamarket.vo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName CategoryVo
 * @Description
 * @Author hanjiabei
 * @Date 2020/7/12 10:34 上午
 **/
@Data
public class CategoryVo {

    private Integer categoryId;

    private Integer parentId;

    private String categoryName;

    private Integer sortOrder;

    private List<CategoryVo> subCategories;
}
