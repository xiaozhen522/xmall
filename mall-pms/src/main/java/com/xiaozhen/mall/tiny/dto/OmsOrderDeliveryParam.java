package com.xiaozhen.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @description:
 * @create time:2021/10/18
 * @Author: XiaoZhen
 **/
public class OmsOrderDeliveryParam {
    @ApiModelProperty("物流公司")
    private String deliveryCompany;
    @ApiModelProperty("物流单号")
    private String deliverySn;
    @ApiModelProperty("订单id")
    private Long orderId;

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public String getDeliverySn() {
        return deliverySn;
    }

    public void setDeliverySn(String deliverySn) {
        this.deliverySn = deliverySn;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
