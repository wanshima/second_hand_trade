package com.esbteam.fleamarket.controller;

import com.esbteam.fleamarket.consts.FleaMarketConst;
import com.esbteam.fleamarket.form.CartAddForm;
import com.esbteam.fleamarket.form.CartUpdateForm;
import com.esbteam.fleamarket.pojo.UserInfo;
import com.esbteam.fleamarket.service.impl.CartServiceImpl;
import com.esbteam.fleamarket.vo.CartVo;
import com.esbteam.fleamarket.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @ClassName CartController
 * @Description
 * @Author hanjiabei
 * @Date 2020/7/16 7:41 下午
 **/
@RestController
public class CartController {

    @Autowired
    private CartServiceImpl cartService;

    @GetMapping("/carts")
    public ResponseVo<CartVo> list(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);
        return cartService.list(userInfo.getUserId());
    }

    @PostMapping("/carts")
    public ResponseVo<CartVo> add(@Valid @RequestBody CartAddForm cartAddForm, HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);
        return cartService.add(userInfo.getUserId(),cartAddForm);
    }

    @PutMapping("/carts/{productId}")
    public ResponseVo<CartVo> update(@Valid @RequestBody CartUpdateForm form,
                                     @PathVariable String productId,
                                     HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);
        return cartService.update(userInfo.getUserId(),productId,form);
    }

    @DeleteMapping("/carts/{productId}")
    public ResponseVo<CartVo> delete(@PathVariable String productId,
                                     HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);
        return cartService.delete(userInfo.getUserId(),productId);
    }

    @PutMapping("/carts/selectAll")
    public ResponseVo<CartVo> selectAll(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);
        return cartService.selectAll(userInfo.getUserId());
    }

    @PutMapping("/carts/unSelectAll")
    public ResponseVo<CartVo> unSelectAll(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);
        return cartService.unSelectAll(userInfo.getUserId());
    }

    @GetMapping("/carts/products/sum")
    public ResponseVo<Integer> sum(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);
        return cartService.sum(userInfo.getUserId());
    }
}
