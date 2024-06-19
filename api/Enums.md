#### Enums

##### 1, ResponseEnum

```java
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
    ;

    private final Integer code;

    private final String message;

    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
```

##### 2, UserStatusEnum

```java
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
```

##### 3, UserAuthorityEnum

```java
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
```

##### 4, ProductStatusEnum

```java
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
```

