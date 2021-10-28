package com.xiaozhen.mall.tiny.dto;

import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotionSession;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description :
 * @create time:2021/10/22
 * @Author : XiaoZhen
 **/
@Data
public class SmsFlashPromotionSessionDeatil extends SmsFlashPromotionSession {
    @ApiModelProperty("商品数量")
    private Integer productCount;
}
