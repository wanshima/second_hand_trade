package com.esbteam.fleamarket.converter;

import com.esbteam.fleamarket.enums.UserAuthorityEnum;
import com.esbteam.fleamarket.enums.UserStatusEnum;
import com.esbteam.fleamarket.form.UserRegisterForm;
import com.esbteam.fleamarket.pojo.UserInfo;
import com.esbteam.fleamarket.utils.UserIdUtil;
public class UserRegisterForm2UserInfo {
    public static UserInfo convert(UserRegisterForm form){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(UserIdUtil.genUniqueKey());
        userInfo.setUserEmail(form.getUserEmail());
        userInfo.setUsername(form.getUsername());
        userInfo.setPassword(form.getPassword());

        userInfo.setUserAuthority(UserAuthorityEnum.CUSTOMER.getCode());
        userInfo.setUserStatus(UserStatusEnum.ACTIVE.getCode());
        return userInfo;
    }

}
