package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.SmsFlashPromotionProduct;
import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotionProductRelation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 限时购和商品关系
 * @create time:18:25
 * @Author : XiaoZhen
 **/
public interface SmsFlashPromotionProductRelationService {
    SmsFlashPromotionProductRelation getById(Long id);

    @Transactional
    int create(SmsFlashPromotionProductRelation[] fpprList);

    @Transactional
    int deleteById(Long id);

    List<SmsFlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageNum,
                                        Integer pageSize);

    @Transactional
    int updateById(Long id, SmsFlashPromotionProductRelation flashProductRelation);

}
