package com.esbteam.fleamarket.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName ProductVo
 * @Description
 * @Author hanjiabei
 * @Date 2020/7/12 6:44 下午
 **/
@Data
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class ProductVo {

    private String productId;

    private Integer categoryId;

    private String sellerId;

    private String name;

    private String subtitle;

    private String mainImage;

    private BigDecimal price;

    private Integer status;

    private Date updateTime;

    private UserAvatarVo member;
}
