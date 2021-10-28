package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.SmsCouponParm;
import com.xiaozhen.mall.tiny.mbg.model.SmsCoupon;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 优惠券
 * @create time:22:21
 * @Author : XiaoZhen
 **/
public interface SmsCouponService {
    SmsCouponParm getById(Long id);

    @Transactional
    int create(SmsCouponParm couponParm);

    @Transactional
    int deleteById(Long id);

    List<SmsCoupon> list(String name, Integer pageNum, Integer pageSize, Integer type);

    @Transactional
    int updateById(Long id, SmsCouponParm couponParm);
}
