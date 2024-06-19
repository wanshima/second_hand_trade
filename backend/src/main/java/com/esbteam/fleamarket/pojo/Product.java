package com.esbteam.fleamarket.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Product {

    private String productId;

    private Integer categoryId;

    private String sellerId;

    private String name;

    private String subtitle="";

    private String mainImage="";

    private String subImages="";

    private String detail="";

    private BigDecimal price;

    private Integer stock;

    private Integer status;

    private Date createTime;

    private Date updateTime;

}