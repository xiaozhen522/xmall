package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.mbg.mapper.OmsOrderReturnReasonMapper;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrderReturnReason;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrderReturnReasonExample;
import com.xiaozhen.mall.tiny.service.OmsOrderReturnReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @description : 退货原因OmsOrderReturnReasonService实现类
 * @create time:20:56
 * @Author : XiaoZhen
 **/
@Service
public class OmsOrderReturnReasonServiceImpl implements OmsOrderReturnReasonService {
    @Autowired
    private OmsOrderReturnReasonMapper returnReasonMapper;

    @Override
    public OmsOrderReturnReason getById(Long id) {
        return returnReasonMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(OmsOrderReturnReason returnReason) {
        return returnReasonMapper.insertSelective(returnReason);
    }

    @Override
    public int delete(Long[] ids) {
        OmsOrderReturnReasonExample example = new OmsOrderReturnReasonExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        return returnReasonMapper.deleteByExample(example);
    }

    @Override
    public int updateById(Long id, OmsOrderReturnReason returnReason) {
        returnReason.setId(id);
        return returnReasonMapper.updateByPrimaryKey(returnReason);
    }

    @Override
    public List<OmsOrderReturnReason> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return returnReasonMapper.selectByExample(new OmsOrderReturnReasonExample());
    }

    @Override
    public int updateStatus(Long[] ids, Integer status) {
        OmsOrderReturnReason returnReason = new OmsOrderReturnReason();
        returnReason.setStatus(status);
        OmsOrderReturnReasonExample example = new OmsOrderReturnReasonExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        return returnReasonMapper.updateByExampleSelective(returnReason, example);
    }

}
