package com.esbteam.fleamarket.form;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserRegisterForm {

    @Email(message = "invalid email format")
    @NotBlank(message = "user email cannot be blank")
    private String userEmail;

    @NotBlank(message = "username cannot be blank")
    private String username;

    @NotBlank(message = "password cannot be blank")
    private String password;

}
