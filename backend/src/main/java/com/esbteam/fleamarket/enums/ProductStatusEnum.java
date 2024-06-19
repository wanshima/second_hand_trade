package com.esbteam.fleamarket.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {
    ON_SALE(1,"on sale"),
    OFF_SALE(2,"off sale"),
    DELETE(3,"deleted")
    ;

    private Integer code;

    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
