package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.SmsCouponHistory;

import java.util.List;

/**
 * @description : 优惠券领取记录
 * @create time:17:40
 * @Author : XiaoZhen
 **/
public interface SmsCouponHistoryService {
    /**
     * @description : 分页查询优惠券领取记录
     * @param: pageNum  页码
     * @param: pageSize 每页数量
     * @return: 优惠券领取记录对象列表
     */
    List<SmsCouponHistory> listCouponHistory(Long couponId, String orderSn, Integer pageNum, Integer pageSize,
                                             Integer useStatus);
}
