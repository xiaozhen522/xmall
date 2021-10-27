package com.xiaozhen.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description :    订单费用信息
 * @create time:2021/10/18
 * @Author : XiaoZhen
 **/
@Data
public class OMSMoneyInfoParam {
    @ApiModelProperty("管理元后台调整订单使用的折扣金额")
    private BigDecimal discountAmount;
    @ApiModelProperty("运费金额")
    private BigDecimal fereightAmount;
    @ApiModelProperty("订单id")
    private Long orderId;
    @ApiModelProperty("订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单")
    private Integer status;
}
