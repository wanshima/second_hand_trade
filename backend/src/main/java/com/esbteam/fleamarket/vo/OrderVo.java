package com.esbteam.fleamarket.vo;

import com.esbteam.fleamarket.pojo.Shipping;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderVo
 * @Description
 * @Author Chang Zhou
 * @Date 2020/7/25 10:20 PM
 **/

@Data
public class OrderVo {

    private String orderId;

    private String buyerUsername;

    private String buyerPhone;

    private String buyerAddress;

    private BigDecimal orderAmount;

    private BigDecimal payment;

    private Integer paymentType;

    private Integer status;

    private Date paymentTime;

    private Date shippingTime;

    private Date endTime;

    private Date closeTime;

    private Date createTime;

    private List<OrderItemVo> orderItemVoList;

    private Integer shippingId;

    private Shipping shippingVo;
}
