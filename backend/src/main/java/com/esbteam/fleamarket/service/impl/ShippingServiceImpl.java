package com.esbteam.fleamarket.service.impl;

import com.esbteam.fleamarket.dao.ShippingMapper;
import com.esbteam.fleamarket.enums.ResponseEnum;
import com.esbteam.fleamarket.form.ShippingForm;
import com.esbteam.fleamarket.pojo.Shipping;
import com.esbteam.fleamarket.service.IShippingService;
import com.esbteam.fleamarket.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ShippingServiceImpl
 * @Description
 * @Author hanjiabei
 * @Date 2020/8/5 4:31 下午
 **/
@Service
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    private ShippingMapper shippingMapper;

    @Override
    public ResponseVo<Map<String, Integer>> add(String uid, ShippingForm form) {
        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(form,shipping); shipping.setUserId(uid);
        int row = shippingMapper.insertSelective(shipping);
        if (row == 0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        Map<String,Integer> map = new HashMap<>();
        map.put("shippingId",shipping.getId());

        return ResponseVo.success(map);
    }

    @Override
    public ResponseVo delete(String uid, Integer shippingId) {
        int row = shippingMapper.deleteByIdAndUid(uid,shippingId);
        if (row == 0){
            return ResponseVo.error(ResponseEnum.DELETE_SHIPPING_FAIL);
        }
        return ResponseVo.successByMsg("删除地址成功");
    }

    @Override
    public ResponseVo update(String uid, Integer shippingId, ShippingForm form) {
        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(form,shipping);
        shipping.setUserId(uid); shipping.setId(shippingId);

        int row = shippingMapper.updateByPrimaryKeySelective(shipping);
        if (row == 0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.success();
    }

    @Override
    public ResponseVo<PageInfo<Shipping>> list(String uid, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Shipping> shippingList = shippingMapper.selectByUserId(uid);
        PageInfo<Shipping> pageInfo = new PageInfo<>(); pageInfo.setList(shippingList);
        return ResponseVo.success(pageInfo);
    }
}
