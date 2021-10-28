package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotion;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 显示购活动
 * @create time:18:02
 * @Author : XiaoZhen
 **/
public interface SmsFlashPromotionService {

    SmsFlashPromotion getById(Long id);

    @Transactional
    int create(SmsFlashPromotion flashPromotion);

    @Transactional
    int deleteById(Long id);

    List<SmsFlashPromotion> list(String keyword, Integer pageNum, Integer pageSize);

    @Transactional
    int updateById(Long id, SmsFlashPromotion flashPromotion);

    @Transactional
    int updateStatusById(Long id, Integer status);
}
