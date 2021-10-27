package com.xiaozhen.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description :
 * @create time:2021/10/19
 * @Author : XiaoZhen
 **/
@Data
public class OmsUpdateStatusParam {
    @ApiModelProperty(value = "处理备注")
    private String handleNote;
    @ApiModelProperty(value = "处理人员")
    private String handleMan;
    @ApiModelProperty(value = "收货人")
    private String receiveMan;
    @ApiModelProperty(value = "收货备注")
    private String receiveNote;
    @ApiModelProperty(value = "申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝")
    private Integer status;
    @ApiModelProperty(value = "退款金额")
    private BigDecimal returnAmount;
    @ApiModelProperty(value = "收货地址表id")
    private Long companyAddressId;
    @ApiModelProperty("服务单号")
    private Long id;
}
