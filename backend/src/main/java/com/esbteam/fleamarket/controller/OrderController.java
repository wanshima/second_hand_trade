package com.esbteam.fleamarket.controller;

import com.esbteam.fleamarket.consts.FleaMarketConst;
import com.esbteam.fleamarket.form.OrderCreateForm;
import com.esbteam.fleamarket.pojo.UserInfo;
import com.esbteam.fleamarket.service.IOrderService;
import com.esbteam.fleamarket.vo.OrderVo;
import com.esbteam.fleamarket.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/orders")
    public ResponseVo<OrderVo> create(@Valid @RequestBody OrderCreateForm form,
                                      HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);
        return orderService.create(userInfo.getUserId(), form.getShippingId());
    }

    @GetMapping("/orders")
    public ResponseVo<PageInfo> list(@RequestParam Integer pageNum,
                                     @RequestParam Integer pageSize,
                                     HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);
        return orderService.list(userInfo.getUserId(), pageNum, pageSize);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseVo<OrderVo> detail(@PathVariable String orderId,
                                      HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);
        return orderService.detail(userInfo.getUserId(), orderId);
    }

    @PutMapping("/orders/{orderId}")
    public ResponseVo cancel(@PathVariable String orderId,
                             HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute(FleaMarketConst.CURRENT_USER);
        return orderService.cancel(userInfo.getUserId(), orderId);
    }
}
