package com.esbteam.fleamarket.enums;

import lombok.Getter;

@Getter
public enum UserStatusEnum {
    ACTIVE(0,"active account"),
    INACTIVE(1,"inactive account"),
    INVALID(2,"invalid account")
    ;

    private Integer code;

    private String msg;

    UserStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
