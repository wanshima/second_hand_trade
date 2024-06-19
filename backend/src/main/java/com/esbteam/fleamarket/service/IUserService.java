package com.esbteam.fleamarket.service;

import com.esbteam.fleamarket.form.UserUpdateForm;
import com.esbteam.fleamarket.pojo.UserInfo;
import com.esbteam.fleamarket.vo.ResponseVo;
import com.esbteam.fleamarket.vo.UserVo;

public interface IUserService {

    /**
     * register interface
     * @param userInfo
     * @return
     */
    ResponseVo register(UserInfo userInfo);

    /**
     * login interface
     * @param userEmail
     * @param password
     * @return
     */
    ResponseVo<UserInfo> login(String userEmail, String password);

    ResponseVo<UserInfo> update(UserInfo userInfo, UserUpdateForm form);

}
