package com.xiaozhen.mall.tiny.service.Impl;

import com.xiaozhen.mall.tiny.mbg.mapper.OmsCompanyAddressMapper;
import com.xiaozhen.mall.tiny.mbg.model.OmsCompanyAddress;
import com.xiaozhen.mall.tiny.mbg.model.OmsCompanyAddressExample;
import com.xiaozhen.mall.tiny.service.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 收获地址OmsCompanyAddressService实现类
 * @create time:16:58
 * @Author: XiaoZhen
 **/
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;

    @Override
    public List<OmsCompanyAddress> listCompanyAddress() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
