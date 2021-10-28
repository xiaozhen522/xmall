package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.mbg.mapper.SmsHomeAdvertiseMapper;
import com.xiaozhen.mall.tiny.mbg.model.SmsHomeAdvertise;
import com.xiaozhen.mall.tiny.mbg.model.SmsHomeAdvertiseExample;
import com.xiaozhen.mall.tiny.service.SmsHomeAdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @description : 首页轮播广告SmsHomeAdvertiseService实现类
 * @create time:18:38
 * @Author : XiaoZhen
 **/
@Service
public class SmsHomeAdvertiseServiceImpl implements SmsHomeAdvertiseService {
    @Autowired
    private SmsHomeAdvertiseMapper homeAdvertiseMapper;

    @Override
    public SmsHomeAdvertise getById(Long id) {
        return homeAdvertiseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(SmsHomeAdvertise homeAdvertise) {
        return homeAdvertiseMapper.insertSelective(homeAdvertise);
    }

    @Override
    public int delete(Long[] ids) {
        SmsHomeAdvertiseExample example = new SmsHomeAdvertiseExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        return homeAdvertiseMapper.deleteByExample(example);
    }

    @Override
    public List<SmsHomeAdvertise> list(String endTime, String name, Integer pageNum, Integer pageSize) {
        SmsHomeAdvertiseExample example = new SmsHomeAdvertiseExample();
        SmsHomeAdvertiseExample.Criteria criteria = example.createCriteria();
        if (endTime != null && !"".equals(endTime)) {
            criteria.andEndTimeEqualTo(new Date(endTime));
        }
        if (name != null) {
            criteria.andNameLike("%" + name + "%");
        }
        PageHelper.startPage(pageNum, pageSize);
        return homeAdvertiseMapper.selectByExample(example);
    }

    @Override
    public int updateById(Long id, SmsHomeAdvertise homeAdvertise) {
        homeAdvertise.setId(id);
        return homeAdvertiseMapper.updateByPrimaryKey(homeAdvertise);
    }

    @Override
    public int updateStatusById(Long id, Integer status) {
        SmsHomeAdvertise homeAdvertise = new SmsHomeAdvertise();
        homeAdvertise.setStatus(status);
        homeAdvertise.setId(id);
        return homeAdvertiseMapper.updateByPrimaryKeySelective(homeAdvertise);
    }
}
