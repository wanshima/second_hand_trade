package com.esbteam.fleamarket.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserLoginForm {

    @NotBlank(message = "user email cannot be blank")
    private String userEmail;

    @NotBlank(message = "password cannot be blank")
    private String password;
}
