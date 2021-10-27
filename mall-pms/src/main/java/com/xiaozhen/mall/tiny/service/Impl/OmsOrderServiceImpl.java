package com.xiaozhen.mall.tiny.service.Impl;

import com.xiaozhen.mall.tiny.dao.OmsOrderDetailDao;
import com.xiaozhen.mall.tiny.dto.OMSMoneyInfoParam;
import com.xiaozhen.mall.tiny.dto.OmsOrderDeliveryParam;
import com.xiaozhen.mall.tiny.dto.OmsOrderDetail;
import com.xiaozhen.mall.tiny.dto.OmsReceiverInfoParam;
import com.xiaozhen.mall.tiny.mbg.mapper.OmsOrderMapper;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrder;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrderExample;
import com.xiaozhen.mall.tiny.service.OmsOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @description : 订单OmsOrderService实现类
 * @create time:17:22
 * @Author : XiaoZhen
 **/
@Service
public class OmsOrderServiceImpl implements OmsOrderService {
    @Autowired
    private OmsOrderMapper orderMapper;
    @Autowired
    private OmsOrderDetailDao orderDetailDao;

    @Override
    public OmsOrderDetail get(Long id) {
        return orderDetailDao.get(id);
    }

    @Override
    public int delete(Long[] ids) {
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andCouponIdIn(Arrays.asList(ids));
        return orderMapper.deleteByExample(example);
    }

    @Override
    public List<OmsOrder> list(String createTime, String orderSn, Integer orderType, Integer pageNum,
                               Integer pageSize, String receiveKeyword, Integer sourceType, Integer status) {
        OmsOrderExample example = new OmsOrderExample();
        OmsOrderExample.Criteria criteria = example.createCriteria();
        OmsOrderExample.Criteria criteria1 = example.createCriteria();
        if (createTime != null && !createTime.equals("")) {
            criteria.andCreateTimeEqualTo(new Date(createTime));
            criteria1.andCreateTimeEqualTo(new Date(createTime));
        }
        if (orderSn != null && !orderSn.equals("")) {
            criteria.andOrderSnEqualTo(orderSn);
            criteria1.andOrderSnEqualTo(orderSn);
        }
        if (sourceType != null) {
            criteria.andSourceTypeEqualTo(sourceType);
            criteria1.andSourceTypeEqualTo(sourceType);
        }
        if (status != null) {
            criteria.andStatusEqualTo(status);
            criteria1.andStatusEqualTo(status);
        }
        if (receiveKeyword != null) {
            criteria.andReceiverNameLike("%" + receiveKeyword + "%");
            criteria1.andReceiverPhoneLike("%" + receiveKeyword + "%");
        }
        example.or(criteria1);
        return orderMapper.selectByExample(example);
    }

    @Override
    public int updateStatus(Integer status, Long[] ids) {
        OmsOrder order = new OmsOrder();
        order.setStatus(status);
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        return orderMapper.updateByExampleSelective(order, example);
    }

    @Override
    public int updateDelivery(List<OmsOrderDeliveryParam> orderDeliveryParamList) {
        for (OmsOrderDeliveryParam orderDeliveryParam : orderDeliveryParamList) {
            OmsOrder order = new OmsOrder();
            BeanUtils.copyProperties(orderDeliveryParam, order);
            order.setId(orderDeliveryParam.getOrderId());
            orderMapper.updateByPrimaryKeySelective(order);
        }
        return orderDeliveryParamList.size();
    }

    @Override
    public int updateMoneyInfo(OMSMoneyInfoParam moneyInfoParam) {
        OmsOrder order = new OmsOrder();
        BeanUtils.copyProperties(moneyInfoParam, order);
        order.setId(moneyInfoParam.getOrderId());
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public int updateNote(Long id, String note, Integer status) {
        OmsOrder order = new OmsOrder();
        order.setId(id);
        order.setNote(note);
        order.setStatus(status);
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam) {
        OmsOrder order = new OmsOrder();
        BeanUtils.copyProperties(receiverInfoParam, order);
        order.setId(receiverInfoParam.getOrderId());
        return orderMapper.updateByPrimaryKeySelective(order);
    }

}
