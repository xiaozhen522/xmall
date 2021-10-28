package com.xiaozhen.mall.tiny.dao;

import com.xiaozhen.mall.tiny.dto.SmsFlashPromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description :
 * @create time:2021/10/28 19:54
 * @Author : XiaoZhen
 **/
public interface SmsFlashPromotionProductDao {
    List<SmsFlashPromotionProduct> list(@Param("flashPromotionId") Long flashPromotionId,
                                        @Param("flashPromotionSessionId") Long flashPromotionSessionId);
}
