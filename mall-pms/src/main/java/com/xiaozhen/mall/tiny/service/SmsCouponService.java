package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.SmsCouponParm;
import com.xiaozhen.mall.tiny.mbg.model.SmsCoupon;

import java.util.List;

/**
 * @description : 优惠券
 * @create time:22:21
 * @Author : XiaoZhen
 **/
public interface SmsCouponService {
    SmsCouponParm getCouponParm(Long id);

    /**
     * @description : 创建新的优惠券
     * @param: couponParm  新的优惠券
     * @return: 影响行数
     */
    int createCoupon(SmsCouponParm couponParm);

    /**
     * @description : 删除指定id的优惠券
     * @param: id   优惠券id
     * @return: 影响行数
     */
    int deleteCoupon(Long id);

    /**
     * @description : 分页查询优惠券
     * @param: pageNum  页码
     * @param: pageSize 每页数量
     * @return: 优惠券对象列表
     */
    List<SmsCoupon> listCoupon(String name,Integer pageNum, Integer pageSize,Integer type);

    /**
     * @description : 更新指定id的优惠券
     * @param: id   优惠券id
     * @param: coupon  新的优惠券
     * @return: 影响行数
     */
    int updateCoupon(Long id, SmsCouponParm couponParm);
}
