package com.esbteam.fleamarket.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Shipping {
    private Integer id;

    private String userId;

    private String receiverName;

    private String receiverPhone;

    private String receiverMobile;

    private String receiverState;

    private String receiverCity;

    private String receiverAddress;

    private String receiverZip;

    private Date createTime;

    private Date updateTime;

}