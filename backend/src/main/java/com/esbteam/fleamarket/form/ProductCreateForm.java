package com.esbteam.fleamarket.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductCreateForm {

    @NotNull(message = "category id cannot be null")
    private Integer categoryId;

    @NotBlank(message = "product name cannot be blank")
    private String name;

    private String subtitle="";

    private String mainImage="";

    private String subImages="";

    private String detail="";

    @NotNull(message = "price cannot be null")
    private BigDecimal price;

    @NotNull(message = "stock cannot be null")
    private Integer stock;

}
