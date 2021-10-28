package com.xiaozhen.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description 返回商品参数
 * @create time:2021/10/16
 * @Author XiaoZhen
 **/
@Data
public class PmsProductResult extends PmsProductParam {
    @ApiModelProperty(value = "商品所选分类的父id")
    private Long cateParentId;
}
