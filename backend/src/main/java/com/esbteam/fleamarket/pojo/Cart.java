package com.esbteam.fleamarket.pojo;

import lombok.Data;

@Data
public class Cart {
    private String productId;

    private Integer quantity;

    private Boolean productSelected;

    public Cart() {
    }

    public Cart(String productId, Integer quantity, Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productSelected = productSelected;
    }
}
