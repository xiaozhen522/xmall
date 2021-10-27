package com.xiaozhen.mall.tiny.dto;

import com.xiaozhen.mall.tiny.mbg.model.PmsProduct;
import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotionProductRelation;

import java.util.List;

/**
 * @description :
 * @create time:2021/10/20
 * @Author : XiaoZhen
 **/
public class SmsFlashPromotionProduct extends SmsFlashPromotionProductRelation {
    private PmsProduct product;

    public PmsProduct getProduct() {
        return product;
    }

    public void setProduct(PmsProduct product) {
        this.product = product;
    }
}
