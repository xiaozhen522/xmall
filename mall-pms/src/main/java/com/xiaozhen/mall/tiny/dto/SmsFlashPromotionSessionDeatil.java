package com.xiaozhen.mall.tiny.dto;

import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotionSession;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description:
 * @create time:2021/10/22
 * @Author: XiaoZhen
 **/
public class SmsFlashPromotionSessionDeatil extends SmsFlashPromotionSession {
    @ApiModelProperty("商品数量")
    private Integer productCount;

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }
}
