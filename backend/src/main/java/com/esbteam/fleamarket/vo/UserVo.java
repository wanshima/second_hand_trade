package com.esbteam.fleamarket.vo;

import lombok.Data;

/**
 * @ClassName UserVo
 * @Description
 * @Author hanjiabei
 * @Date 2020/7/13 5:18 下午
 **/
@Data
public class UserVo {

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
    
    private String userId;
}
