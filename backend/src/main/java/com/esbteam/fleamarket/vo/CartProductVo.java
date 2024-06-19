package com.esbteam.fleamarket.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName CartProductVo
 * @Description
 * @Author hanjiabei
 * @Date 2020/7/16 7:33 下午
 **/
@Data
public class CartProductVo {

    private String productId;

    private String sellerId;

    /** 购买数量. */
    private Integer quantity;

    private String productName;

    private String productSubtitle;

    private String productMainImage;

    private BigDecimal productPrice;

    private Integer productStock;

    private Integer productStatus;

    /** 等于数量乘以单价. */
    private BigDecimal productTotalPrice;

    /** 商品是否选中. */
    private Boolean productSelected;

    public CartProductVo(String productId, String sellerId, Integer quantity, String productName, String productSubtitle, String productMainImage, BigDecimal productPrice, Integer productStock, Integer productStatus, BigDecimal productTotalPrice, Boolean productSelected) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.quantity = quantity;
        this.productName = productName;
        this.productSubtitle = productSubtitle;
        this.productMainImage = productMainImage;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productStatus = productStatus;
        this.productTotalPrice = productTotalPrice;
        this.productSelected = productSelected;
    }
}
