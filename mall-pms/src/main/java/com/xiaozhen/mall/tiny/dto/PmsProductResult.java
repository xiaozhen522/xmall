package com.xiaozhen.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @description 返回商品参数
 * @create time:2021/10/16
 * @Author XiaoZhen
 **/
public class PmsProductResult extends PmsProductParam {
    @ApiModelProperty(value = "商品所选分类的父id")
    private Long cateParentId;

    public Long getCateParentId() {
        return cateParentId;
    }

    public void setCateParentId(Long cateParentId) {
        this.cateParentId = cateParentId;
    }
}
