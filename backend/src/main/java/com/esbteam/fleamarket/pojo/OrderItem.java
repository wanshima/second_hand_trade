package com.esbteam.fleamarket.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderItem {

    private String itemId;

    private String orderId;

    private String productId;

    private String sellerId;

    private String sellerUsername;

    private String sellerPhone;

    private String productName;

    private BigDecimal currentUnitPrice;

    private Integer productQuantity;

    private String productImage;

    private BigDecimal totalPrice;

    private Date createTime;

    private Date updateTime;

}