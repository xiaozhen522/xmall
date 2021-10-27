package com.xiaozhen.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description : 物流信息
 * @create time:2021/10/18
 * @Author : XiaoZhen
 **/
@Data
public class OmsOrderDeliveryParam {
    @ApiModelProperty("物流公司")
    private String deliveryCompany;
    @ApiModelProperty("物流单号")
    private String deliverySn;
    @ApiModelProperty("订单id")
    private Long orderId;
}
