package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.OmsOrderSetting;

/**
 * @description : 订单设置
 * @create time:19:42
 * @Author : XiaoZhen
 **/
public interface OmsOrderSettingService {
    /**
     * 更新指定订单设置
     *
     * @param id           订单设置
     * @param orderSetting 新的订单设置对象
     * @return 更新行数
     */
    int update(Long id, OmsOrderSetting orderSetting);

    /**
     * 获取指定的订单设置
     *
     * @param id 订单设置id
     * @return 订单设置对象
     */
    OmsOrderSetting get(Long id);
}
