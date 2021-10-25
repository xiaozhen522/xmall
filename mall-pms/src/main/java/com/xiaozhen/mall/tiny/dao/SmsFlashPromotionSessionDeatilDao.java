package com.xiaozhen.mall.tiny.dao;

import com.xiaozhen.mall.tiny.dto.SmsFlashPromotionSessionDeatil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @create time:2021/10/22
 * @Author: XiaoZhen
 **/
public interface SmsFlashPromotionSessionDeatilDao {
    List<SmsFlashPromotionSessionDeatil> listFlashPromotionSessionDetail(@Param("flashPromotionId") Long flashPromotionId);
}
