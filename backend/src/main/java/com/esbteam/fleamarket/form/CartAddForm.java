package com.esbteam.fleamarket.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CartAddForm {

    @NotBlank(message = "product id cannot be black")
    private String productId;

    private Boolean selected;
}
