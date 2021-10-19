package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.OmsOrderSetting;

/**
 * @description: 订单设置
 * @create time:19:42
 * @Author: XiaoZhen
 **/
public interface OmsOrderSettingService {
    /**
     * @description: 更新指定id的订单设置
     * @param: id   订单设置id
     * @param: orderSetting  新的订单设置
     * @return: 影响行数
     */
    int updateOrderSetting(Long id, OmsOrderSetting orderSetting);

    /**
     * @description: 获取指定id的订单设置
     * @param: id   订单设置id
     * @return: 订单设置对象
     */
    OmsOrderSetting getOrderSetting(Long id);
}
