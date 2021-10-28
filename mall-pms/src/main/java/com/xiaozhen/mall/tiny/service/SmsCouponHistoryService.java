package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.SmsCouponHistory;

import java.util.List;

/**
 * @description : 优惠券领取记录
 * @create time:17:40
 * @Author : XiaoZhen
 **/
public interface SmsCouponHistoryService {
    List<SmsCouponHistory> list(Long couponId, String orderSn, Integer pageNum, Integer pageSize, Integer useStatus);
}
