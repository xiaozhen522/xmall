package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.SmsFlashPromotionProduct;
import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotionProductRelation;

import java.util.List;

/**
 * @description : 限时购和商品关系
 * @create time:18:25
 * @Author : XiaoZhen
 **/
public interface SmsFlashPromotionProductRelationService {
    /**
     * @description : 获取指定id的限时购和商品关系
     * @param: id   限时购和商品关系id
     * @return: 限时购和商品关系对象
     */
    SmsFlashPromotionProductRelation getFlashPromotionProductRelation(Long id);

    /**
     * @description : 创建新的限时购和商品关系
     * @param: flashProductRelation  新的限时购和商品关系
     * @return: 影响行数
     */
    int createFlashPromotionProductRelation(SmsFlashPromotionProductRelation[] fpprList);

    /**
     * @description : 删除指定id的限时购和商品关系
     * @param: id   限时购和商品关系id
     * @return: 影响行数
     */
    int deleteFlashPromotionProductRelation(Long id);

    /**
     * @description : 分页查询限时购和商品关系
     * @param: pageNum  页码
     * @param: pageSize 每页数量
     * @return: 限时购和商品关系对象列表
     */
    List<SmsFlashPromotionProduct> listFlashPromotionProduct(Long flashPromotionId, Long flashPromotionSessionId,
                                                             Integer pageNum, Integer pageSize);

    /**
     * @description : 更新指定id的限时购和商品关系
     * @param: id   限时购和商品关系id
     * @param: flashProductRelation  新的限时购和商品关系
     * @return: 影响行数
     */
    int updateFlashPromotionProductRelation(Long id, SmsFlashPromotionProductRelation flashProductRelation);

}
