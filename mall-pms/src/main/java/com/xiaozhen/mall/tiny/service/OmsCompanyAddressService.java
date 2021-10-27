package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.OmsCompanyAddress;

import java.util.List;

/**
 * @description : 公司收发货地址Service
 * @create time:16:58
 * @Author : XiaoZhen
 **/
public interface OmsCompanyAddressService {
    /**
     * 获取所有公司收发货地址
     *
     * @return List
     */
    List<OmsCompanyAddress> list();
}
