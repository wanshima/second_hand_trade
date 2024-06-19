package com.esbteam.fleamarket.controller;

import com.esbteam.fleamarket.consts.FleaMarketConst;
import com.esbteam.fleamarket.form.ShippingForm;
import com.esbteam.fleamarket.pojo.Shipping;
import com.esbteam.fleamarket.pojo.UserInfo;
import com.esbteam.fleamarket.service.impl.ShippingServiceImpl;
import com.esbteam.fleamarket.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @ClassName ShippingController
 * @Description
 * @Author hanjiabei
 * @Date 2020/8/5 5:55 下午
 **/
@RestController

public class ShippingController {

    @Autowired
    private ShippingServiceImpl shippingService;

    @PostMapping("/shippings")
    public ResponseVo add(@Valid @RequestBody ShippingForm form, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);
        return shippingService.add(user.getUserId(),form);
    }

    @DeleteMapping("/shippings/{shippingId}")
    public ResponseVo delete(@PathVariable Integer shippingId,
                             HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);
        return shippingService.delete(user.getUserId(),shippingId);
    }

    @PutMapping("/shippings/{shippingId}")
    public ResponseVo update(@PathVariable Integer shippingId,
                             @Valid @RequestBody ShippingForm form,
                             HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);
        return shippingService.update(user.getUserId(),shippingId,form);
    }

    @GetMapping("/shippings")
    public ResponseVo<PageInfo<Shipping>> list(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                               @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                               HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);
        return shippingService.list(user.getUserId(),pageNum,pageSize);
    }
}
