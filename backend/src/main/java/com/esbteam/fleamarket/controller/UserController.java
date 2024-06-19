package com.esbteam.fleamarket.controller;

import com.esbteam.fleamarket.consts.FleaMarketConst;
import com.esbteam.fleamarket.converter.UserInfo2UserVo;
import com.esbteam.fleamarket.converter.UserRegisterForm2UserInfo;
import com.esbteam.fleamarket.enums.ResponseEnum;
import com.esbteam.fleamarket.form.UserLoginForm;
import com.esbteam.fleamarket.form.UserRegisterForm;
import com.esbteam.fleamarket.form.UserUpdateForm;
import com.esbteam.fleamarket.pojo.UserInfo;
import com.esbteam.fleamarket.service.impl.UserServiceImpl;
import com.esbteam.fleamarket.vo.ResponseVo;
import com.esbteam.fleamarket.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @ClassName UserController
 * @Description
 * @Author hanjiabei
 * @Date 2020/7/9 11:02 下午
 **/
@RestController
@RequestMapping("")
@Slf4j
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/user/register")
    public ResponseVo register(@Valid @RequestBody UserRegisterForm form){
        //1. 将form转化为userInfo,并且生成userId
        UserInfo userInfo = UserRegisterForm2UserInfo.convert(form);
        //2. 调用service
        return userService.register(userInfo);
    }

    @PostMapping("/user/login")
    public ResponseVo login(@Valid @RequestBody UserLoginForm userLoginForm,
                                      HttpSession session){
        ResponseVo<UserInfo> userResponseVo = userService.login(userLoginForm.getUserEmail(),userLoginForm.getPassword());
        if (userResponseVo.getStatus() != ResponseEnum.SUCCESS.getCode()){
            return userResponseVo;
        }
        session.setAttribute(FleaMarketConst.CURRENT_USER,userResponseVo.getData());
        log.info("【LOGIN SESSION】{}",session.getId());
        return userResponseVo;
    }

    @GetMapping("/user")
    public ResponseVo<UserVo> userInfo(HttpSession session){
        log.info("【LOGIN SESSION】{}",session.getId());
        UserInfo userInfo = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);

        return ResponseVo.success(UserInfo2UserVo.convert(userInfo));
    }

    @PostMapping("/user/logout")
    public ResponseVo logout(HttpSession session){
        log.info("【LOGOUT SESSION】{}",session.getId());

        session.removeAttribute(FleaMarketConst.CURRENT_USER);
        return ResponseVo.success();
    }

    @PostMapping("/user/update")
    public ResponseVo update(@RequestBody UserUpdateForm form, HttpSession session){
        log.info("【UPDATE INFO】{}",session.getId());
        UserInfo userInfo = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);

        ResponseVo responseVo = userService.update(userInfo,form);
        if (!responseVo.getStatus().equals(ResponseEnum.SUCCESS.getCode()))return responseVo;
        session.setAttribute(FleaMarketConst.CURRENT_USER,responseVo.getData());
        return ResponseVo.success();
    }
}
