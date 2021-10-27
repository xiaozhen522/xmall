package com.xiaozhen.mall.tiny.dto;

import lombok.Data;

/**
 * @description :
 * @create time:2021/10/27
 * @Author : XiaoZhen
 **/
@Data
public class OrderParam {
    private Long couponId;
    private Long memberReceiveAddressId;
    private Integer payType;
    private Integer useIntegration;
}
