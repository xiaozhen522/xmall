package com.xiaozhen.mall.tiny.dto;

import com.xiaozhen.mall.tiny.mbg.model.PmsProduct;
import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotionProductRelation;
import lombok.Data;

import java.util.List;

/**
 * @description :
 * @create time:2021/10/20
 * @Author : XiaoZhen
 **/
@Data
public class SmsFlashPromotionProduct extends SmsFlashPromotionProductRelation {
    private List<PmsProduct> product;
}
