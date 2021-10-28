package com.xiaozhen.mall.tiny.dto;

import com.xiaozhen.mall.tiny.mbg.model.SmsCoupon;
import com.xiaozhen.mall.tiny.mbg.model.SmsCouponProductCategoryRelation;
import com.xiaozhen.mall.tiny.mbg.model.SmsCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description :
 * @create time:2021/10/19
 * @Author : XiaoZhen
 **/
@Data
public class SmsCouponParm extends SmsCoupon {
    @ApiModelProperty("优惠券绑定的商品分类")
    private List<SmsCouponProductCategoryRelation> couponProductCategoryRelationList;
    @ApiModelProperty("优惠券绑定的商品")
    private List<SmsCouponProductRelation> couponProductRelationList;
}
