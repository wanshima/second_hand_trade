package com.esbteam.fleamarket.dao;

import com.esbteam.fleamarket.pojo.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    int countByUserEmail(String userEmail);

    UserInfo selectByUserEmail(String userEmail);
}