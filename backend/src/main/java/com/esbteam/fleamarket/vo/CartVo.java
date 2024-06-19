package com.esbteam.fleamarket.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName CartVo
 * @Description
 * @Author hanjiabei
 * @Date 2020/7/16 7:33 下午
 **/
@Data
public class CartVo {

    private List<CartProductVo> cartProductVoList;

    private Boolean selectedAll;

    private BigDecimal cartTotalPrice;

    private Integer cartTotalQuantity;

}
