package com.esbteam.fleamarket.converter;

import com.esbteam.fleamarket.pojo.Cart;
import com.esbteam.fleamarket.pojo.Product;
import com.esbteam.fleamarket.vo.CartProductVo;

import java.math.BigDecimal;
public class CartANDProduct2CartProduct {

    public static CartProductVo convert(Product product, Cart cart){
        return new CartProductVo(product.getProductId(),product.getSellerId(),
                cart.getQuantity(), product.getName(),
                product.getSubtitle(), product.getMainImage(),
                product.getPrice(), product.getStock(),
                product.getStatus(),product.getPrice().multiply(BigDecimal.valueOf(cart.getQuantity())),
                cart.getProductSelected());
    }
}
