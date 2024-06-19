package com.esbteam.fleamarket.service;

import com.esbteam.fleamarket.form.CartAddForm;
import com.esbteam.fleamarket.form.CartUpdateForm;
import com.esbteam.fleamarket.pojo.Cart;
import com.esbteam.fleamarket.vo.CartVo;
import com.esbteam.fleamarket.vo.ResponseVo;

import java.util.List;

public interface ICartService {

    ResponseVo<CartVo> list(String uid);

    ResponseVo<CartVo> add(String uid, CartAddForm form);

    ResponseVo<CartVo> update(String uid, String productId, CartUpdateForm cartUpdateForm);

    ResponseVo<CartVo> delete(String uid, String productId);

    ResponseVo<CartVo> selectAll(String uid);

    ResponseVo<CartVo> unSelectAll(String uid);

    ResponseVo<Integer> sum (String uid);

    List<Cart> listForCart(String uid);

}
