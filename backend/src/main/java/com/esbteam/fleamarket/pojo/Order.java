package com.esbteam.fleamarket.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order {

    private String orderId;

    private String buyerId;

    private Integer shippingId;

    private String buyerUsername;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private BigDecimal payment;

    private Integer paymentType;

    private Integer status;

    private Date paymentTime;

    private Date shippingTime;

    private Date endTime;

    private Date closeTime;

    private Date createTime;

    private Date updateTime;

}