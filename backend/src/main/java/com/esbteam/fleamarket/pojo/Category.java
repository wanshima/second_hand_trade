package com.esbteam.fleamarket.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Category {
    private Integer categoryId;

    private Integer parentId;

    private String categoryName;

    private Boolean status;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;

}