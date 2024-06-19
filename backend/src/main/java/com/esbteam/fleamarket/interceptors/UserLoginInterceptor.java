package com.esbteam.fleamarket.interceptors;

import com.esbteam.fleamarket.consts.FleaMarketConst;
import com.esbteam.fleamarket.exceptions.UserLoginException;
import com.esbteam.fleamarket.pojo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("【CHECK LOGIN STATUS】preHandle");
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute(FleaMarketConst.CURRENT_USER);
        if (userInfo == null){
            log.info("【CHECK LOGIN STATUS】user == null");
            throw new UserLoginException();
        }
        return true;
    }
}
