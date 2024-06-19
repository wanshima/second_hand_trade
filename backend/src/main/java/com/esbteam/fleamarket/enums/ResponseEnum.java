package com.esbteam.fleamarket.enums;

import lombok.Getter;

@Getter
public enum ResponseEnum {
    ERROR(-1,"server error"),
    SUCCESS(0,"success"),
    PASSWORD_ERROR(1,"password error"),
    PARAM_ERROR(2,"parameter error"),
    EMAIL_EXIST(3,"email has been registered"),
    PASSWORD_DIFF(4,"password entered at the first time different from the second time"),
    NEED_LOGIN(10,"please login first"),
    USERNAME_OR_PASSWORD_ERROR(11,"invalid username or password"),
    USER_NOT_EXIST(12,"user does not exist"),
    PRODUCT_OFF_SALE_OR_DELETE(21,"product off sale or deleted"),
    PRODUCT_NOT_EXIST(22,"product does not exist"),
    PRODUCT_STOCK_ERROR(23,"product stock error"),
    CART_PRODUCT_NOT_EXIST(31,"product in the cart does not exist"),
    CART_SELECTED_IS_EMPTY(32, "nothing selected in the cart"),
    SHIPPING_ADDRESS_NOT_EXIST(41, "shipping address does not exist"),
    ORDER_NOT_EXIST(51, "order does not exist"),
    ORDER_STATUS_ERROR(52, "order does not exist"),
    DELETE_SHIPPING_FAIL(42,"删除收货地址失败"),
    SHIPPING_NOT_EXIST(43,"收货地址不存在"),
    ;

    private final Integer code;

    private final String message;

    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
