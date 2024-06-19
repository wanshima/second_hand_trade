package com.esbteam.fleamarket.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class UserInfo {
    /** user's unique id */
    private String userId;

    /** user's unique email address */
    private String userEmail;

    /** user's username */
    private String username;

    /** user's password */
    private String password;

    /** user's authority level */
    private Integer userAuthority;

    /** user's third-party login id */
    private String openid;

    /** user's phone number */
    private String userPhone;

    /** user's address */
    private String userAddress;

    /** user's account status */
    private Integer userStatus;

    /** user's personal icon */
    private String userIcon;

    /** user's personal bio */
    private String userBio;

    private Date createTime;

    private Date updateTime;

}