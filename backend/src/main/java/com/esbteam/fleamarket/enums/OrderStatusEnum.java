package com.esbteam.fleamarket.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {

    CANCELED(0, "Order canceled"),
    UNPAID(10, "Order unpaid"),
    PAID(20, "Order paid"),
    SHIPPED(40, "Order shipped"),
    TRANS_SUCCESS(50, "Transaction succeed"),
    TRANS_CLOSED(60, "Transaction closed")
    ;

    Integer code;
    String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
