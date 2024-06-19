package com.esbteam.fleamarket.enums;

import lombok.Getter;

@Getter
public enum UserAuthorityEnum {
    ADMIN(0,"administer"),
    CUSTOMER(1,"normal"),
    ;

    private Integer code;

    private String msg;

    UserAuthorityEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
