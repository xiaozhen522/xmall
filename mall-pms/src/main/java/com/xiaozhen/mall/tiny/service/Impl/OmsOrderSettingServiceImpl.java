package com.xiaozhen.mall.tiny.service.Impl;

import com.xiaozhen.mall.tiny.mbg.mapper.OmsOrderSettingMapper;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrderSetting;
import com.xiaozhen.mall.tiny.service.OmsOrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description : 订单设置OmsOrderSettingService实现类
 * @create time:19:42
 * @Author : XiaoZhen
 **/
@Service
public class OmsOrderSettingServiceImpl implements OmsOrderSettingService {
    @Autowired
    private OmsOrderSettingMapper orderSettingMapper;

    @Override
    public int update(Long id, OmsOrderSetting orderSetting) {
        orderSetting.setId(id);
        return orderSettingMapper.updateByPrimaryKey(orderSetting);
    }

    @Override
    public OmsOrderSetting get(Long id) {
        return orderSettingMapper.selectByPrimaryKey(id);
    }

}
