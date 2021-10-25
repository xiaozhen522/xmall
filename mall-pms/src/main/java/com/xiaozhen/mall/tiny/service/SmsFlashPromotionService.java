package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotion;

import java.util.List;

/**
 * @description: 显示购活动
 * @create time:18:02
 * @Author: XiaoZhen
 **/
public interface SmsFlashPromotionService {
    /**
     * @description: 获取指定id的显示购活动
     * @param: id   显示购活动id
     * @return: 显示购活动对象
     */
    SmsFlashPromotion getFlashPromotion(Long id);

    /**
     * @description: 创建新的显示购活动
     * @param: flash  新的显示购活动
     * @return: 影响行数
     */
    int createFlashPromotion(SmsFlashPromotion flashPromotion);

    /**
     * @description: 删除指定id的显示购活动
     * @param: id   显示购活动id
     * @return: 影响行数
     */
    int deleteFlashPromotion(Long id);

    /**
     * @description: 分页查询显示购活动
     * @param: pageNum  页码
     * @param: pageSize 每页数量
     * @return: 显示购活动对象列表
     */
    List<SmsFlashPromotion> listFlashPromotion(String keyword, Integer pageNum, Integer pageSize);

    /**
     * @description: 更新指定id的显示购活动
     * @param: id   显示购活动id
     * @param: flash  新的显示购活动
     * @return: 影响行数
     */
    int updateFlashPromotion(Long id, SmsFlashPromotion flashPromotion);

    int updateStatus(Long id, Integer status);
}
