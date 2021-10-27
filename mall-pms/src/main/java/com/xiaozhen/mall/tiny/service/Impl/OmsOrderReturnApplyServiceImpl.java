package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.dto.OmsUpdateStatusParam;
import com.xiaozhen.mall.tiny.mbg.mapper.OmsOrderReturnApplyMapper;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrderReturnApply;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrderReturnApplyExample;
import com.xiaozhen.mall.tiny.service.OmsOrderReturnApplyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @description : 订单退货申请OmsOrderReturnApplyService实现类
 * @create time:10:45
 * @Author : XiaoZhen
 **/
@Service
public class OmsOrderReturnApplyServiceImpl implements OmsOrderReturnApplyService {
    @Autowired
    private OmsOrderReturnApplyMapper returnApplyMapper;

    @Override
    public OmsOrderReturnApply get(Long id) {
        return returnApplyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long[] ids) {
        OmsOrderReturnApplyExample example = new OmsOrderReturnApplyExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        return returnApplyMapper.deleteByExample(example);
    }

    @Override
    public List<OmsOrderReturnApply> list(String createTime, String handleMan, String handleTime, Long id,
                                          Integer pageNum, Integer pageSize, String receiverKeyword, Integer ststus) {
        OmsOrderReturnApplyExample example = new OmsOrderReturnApplyExample();
        OmsOrderReturnApplyExample.Criteria criteria = example.createCriteria();
        OmsOrderReturnApplyExample.Criteria criteria1 = example.createCriteria();
        if (createTime != null && !createTime.equals("")) {
            criteria.andCreateTimeEqualTo(new Date(createTime));
            criteria1.andCreateTimeEqualTo(new Date(createTime));
        }
        if (handleMan != null && !handleMan.equals("")) {
            criteria.andHandleManEqualTo(handleMan);
            criteria1.andHandleManEqualTo(handleMan);
        }
        if (handleTime != null && !handleTime.equals("")) {
            criteria.andHandleTimeEqualTo(new Date(handleTime));
            criteria1.andHandleTimeEqualTo(new Date(handleTime));
        }
        if (id != null) {
            criteria.andIdEqualTo(id);
            criteria1.andIdEqualTo(id);
        }
        if (ststus != null) {
            criteria.andStatusEqualTo(ststus);
            criteria1.andStatusEqualTo(ststus);
        }
        if (receiverKeyword != null) {
            criteria.andReturnNameLike("%" + receiverKeyword + "%");
            criteria1.andReturnPhoneLike("%" + receiverKeyword + "%");
        }
        example.or(criteria1);
        PageHelper.startPage(pageNum, pageSize);
        return returnApplyMapper.selectByExample(example);
    }

    @Override
    public int updateStatus(Long id, OmsUpdateStatusParam statusParam) {
        OmsOrderReturnApply returnApply = new OmsOrderReturnApply();
        BeanUtils.copyProperties(statusParam, returnApply);
        returnApply.setId(id);
        return returnApplyMapper.updateByPrimaryKeySelective(returnApply);
    }

}
