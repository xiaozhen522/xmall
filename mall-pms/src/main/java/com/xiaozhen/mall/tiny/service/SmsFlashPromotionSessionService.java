package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.SmsFlashPromotionSessionDeatil;
import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotionSession;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 显示场次管理
 * @create time:22:33
 * @Author : XiaoZhen
 **/
public interface SmsFlashPromotionSessionService {
    SmsFlashPromotionSession getById(Long id);

    @Transactional
    int create(SmsFlashPromotionSession flashSession);

    @Transactional
    int deleteById(Long id);

    List<SmsFlashPromotionSession> list();

    List<SmsFlashPromotionSessionDeatil> selectList(Long flashPromotionId);

    @Transactional
    int updateById(Long id, SmsFlashPromotionSession flashSession);

    @Transactional
    int updateStatusById(Long id, Integer status);
}
