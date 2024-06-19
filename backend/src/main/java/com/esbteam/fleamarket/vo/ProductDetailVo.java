package com.esbteam.fleamarket.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName ProductDetailVo
 * @Description
 * @Author hanjiabei
 * @Date 2020/7/12 7:15 下午
 **/
@Data
public class ProductDetailVo {
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

    private Date updateTime;

}
