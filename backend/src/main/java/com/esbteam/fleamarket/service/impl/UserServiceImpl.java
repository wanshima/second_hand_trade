package com.esbteam.fleamarket.service.impl;

import com.esbteam.fleamarket.converter.UserInfo2UserVo;
import com.esbteam.fleamarket.dao.UserInfoMapper;
import com.esbteam.fleamarket.enums.ResponseEnum;
import com.esbteam.fleamarket.enums.UserAuthorityEnum;
import com.esbteam.fleamarket.form.UserUpdateForm;
import com.esbteam.fleamarket.pojo.UserInfo;
import com.esbteam.fleamarket.service.IUserService;
import com.esbteam.fleamarket.vo.ResponseVo;
import com.esbteam.fleamarket.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author hanjiabei
 * @Date 2020/7/9 8:16 下午
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public ResponseVo register(UserInfo userInfo) {
        //1. 邮箱不能重复
        int countByUserEmail = userInfoMapper.countByUserEmail(userInfo.getUserEmail());
        if (countByUserEmail > 0) return ResponseVo.error(ResponseEnum.EMAIL_EXIST);

        userInfo.setUserAuthority(UserAuthorityEnum.CUSTOMER.getCode());
        //2. MD5加密userInfo中的密码
        userInfo.setPassword(DigestUtils.md5DigestAsHex(
                userInfo.getPassword().getBytes(StandardCharsets.UTF_8)
        ));

        //3. 写入数据库
        int resultCount = userInfoMapper.insertSelective(userInfo);
        if (resultCount == 0) return ResponseVo.error(ResponseEnum.ERROR);
        return ResponseVo.success();
    }

    @Override
    public ResponseVo<UserInfo> login(String userEmail, String password) {
        //1. 查询用户是否存在
        UserInfo userInfo = userInfoMapper.selectByUserEmail(userEmail);
        if (userInfo == null){
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        //2. 比对密码
        if(!userInfo.getPassword().equalsIgnoreCase(
                DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))){
            //密码错误
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        userInfo.setPassword(null);
        return ResponseVo.success(userInfo);
    }

    @Override
    public ResponseVo<UserInfo> update(UserInfo userInfo, UserUpdateForm form) {
        //1. 更新用户信息
        if (form.getUsername() != null) userInfo.setUsername(form.getUsername());
        if (form.getUserPhone() != null) userInfo.setUserPhone(form.getUserPhone());
        if (form.getUserAddress() != null) userInfo.setUserAddress(form.getUserAddress());
        if (form.getUserIcon() != null) userInfo.setUserIcon(form.getUserIcon());
        if (form.getUserBio() != null) userInfo.setUserBio(form.getUserBio());

        //2.数据库中更新信息
        int row = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        if (row <= 0) return ResponseVo.error(ResponseEnum.ERROR);
        return ResponseVo.success(userInfo);
    }
}
