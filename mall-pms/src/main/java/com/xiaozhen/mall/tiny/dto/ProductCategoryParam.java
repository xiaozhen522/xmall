package com.xiaozhen.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description :
 * @create time:2021/10/18
 * @Author : XiaoZhen
 **/
@Data
public class ProductCategoryParam {
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "图标")
    private String icon;
    @ApiModelProperty(value = "关键字")
    private String keywords;
    @ApiModelProperty(value = "商品分类名称")
    private String name;
    @ApiModelProperty(value = "是否显示在导航栏：0->不显示；1->显示")
    private Integer navStatus;
    @ApiModelProperty(value = "上机分类的编号：0表示一级分类")
    private Long parentId;
    @ApiModelProperty("产品相关筛选属性集合")
    private List<Long> productAttributeIdList;
    @ApiModelProperty("分类单位")
    private String productUnit;
    @ApiModelProperty(value = "显示状态：0->不显示；1->显示")
    private Integer showStatus;
    @ApiModelProperty("排序")
    private Integer sort;
}
