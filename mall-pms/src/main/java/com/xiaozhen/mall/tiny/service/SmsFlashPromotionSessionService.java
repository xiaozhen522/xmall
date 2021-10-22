package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.SmsFlashPromotionSessionDeatil;
import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotionSession;

import java.util.List;

/**
 * @description: 显示场次管理
 * @create time:22:33
 * @Author: XiaoZhen
 **/
public interface SmsFlashPromotionSessionService {
    /**
     * @description: 获取指定id的显示场次管理
     * @param: id   显示场次管理id
     * @return: 显示场次管理对象
     */
    SmsFlashPromotionSession getFlashPromotionSession(Long id);

    /**
     * @description: 创建新的显示场次管理
     * @param: flashSession  新的显示场次管理
     * @return: 影响行数
     */
    int createFlashPromotionSession(SmsFlashPromotionSession flashSession);

    /**
     * @description: 删除指定id的显示场次管理
     * @param: id   显示场次管理id
     * @return: 影响行数
     */
    int deleteFlashPromotionSession(Long id);

    /**
     * @description: 获取所有显示场次管理
     * @return: 显示场次管理对象列表
     */
    List<SmsFlashPromotionSession> listFlashPromotionSession();

    List<SmsFlashPromotionSessionDeatil> listFlashPromotionSessionDetail(Long flashPromotionId);

    /**
     * @description: 更新指定id的显示场次管理
     * @param: id   显示场次管理id
     * @param: flashSession  新的显示场次管理
     * @return: 影响行数
     */
    int updateFlashPromotionSession(Long id, SmsFlashPromotionSession flashSession);

    int updateStatus(Long id, Integer status);
}
