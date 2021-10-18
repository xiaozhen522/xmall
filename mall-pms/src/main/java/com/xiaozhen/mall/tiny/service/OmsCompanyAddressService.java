package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.OmsCompanyAddress;

import java.util.List;

/**
 * @description: 收获地址
 * @create time:16:58
 * @Author: XiaoZhen
 **/
public interface OmsCompanyAddressService {

    /**
     * @description: 获取所有收获地址
     * @return: 收获地址对象列表
     */
    List<OmsCompanyAddress> listCompanyAddress();
}
