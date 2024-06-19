package com.esbteam.fleamarket.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName OrderItemVo
 * @Description
 * @Author Chang Zhou
 * @Date 2020/7/25 10:28 PM
 **/

@Data
public class OrderItemVo {
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
}
