package com.esbteam.fleamarket.converter;

import com.esbteam.fleamarket.pojo.UserInfo;
import com.esbteam.fleamarket.vo.UserVo;
import org.springframework.beans.BeanUtils;
public class UserInfo2UserVo {

    public static UserVo convert(UserInfo userInfo){
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userInfo,userVo);
        return userVo;
    }
}
