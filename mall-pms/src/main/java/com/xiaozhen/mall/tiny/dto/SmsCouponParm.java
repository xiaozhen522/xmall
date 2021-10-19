package com.xiaozhen.mall.tiny.dto;

import com.xiaozhen.mall.tiny.mbg.model.SmsCoupon;
import com.xiaozhen.mall.tiny.mbg.model.SmsCouponProductCategoryRelation;
import com.xiaozhen.mall.tiny.mbg.model.SmsCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @description:
 * @create time:2021/10/19
 * @Author: XiaoZhen
 **/
public class SmsCouponParm extends SmsCoupon {
    @ApiModelProperty("优惠券绑定的商品分类")
    private List<SmsCouponProductCategoryRelation> productCategoryRelationList;
    @ApiModelProperty("优惠券绑定的商品")
    private List<SmsCouponProductRelation> productRelationList;

    public List<SmsCouponProductCategoryRelation> getProductCategoryRelationList() {
        return productCategoryRelationList;
    }

    public void setProductCategoryRelationList(List<SmsCouponProductCategoryRelation> productCategoryRelationList) {
        this.productCategoryRelationList = productCategoryRelationList;
    }

    public List<SmsCouponProductRelation> getProductRelationList() {
        return productRelationList;
    }

    public void setProductRelationList(List<SmsCouponProductRelation> productRelationList) {
        this.productRelationList = productRelationList;
    }
}
