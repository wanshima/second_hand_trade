package com.esbteam.fleamarket.form;

import lombok.Data;

@Data
public class UserUpdateForm {
    /** user's personal username */
    private String username;

    /** user's phone number */
    private String userPhone;

    /** user's address */
    private String userAddress;

    /** user's personal icon */
    private String userIcon;

    /** user's personal bio */
    private String userBio;
}
