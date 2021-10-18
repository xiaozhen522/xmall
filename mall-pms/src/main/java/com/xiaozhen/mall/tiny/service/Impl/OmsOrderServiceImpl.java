package com.xiaozhen.mall.tiny.service.Impl;

import com.xiaozhen.mall.tiny.common.utils.MyUtils;
import com.xiaozhen.mall.tiny.dto.OMSMoneyInfoParam;
import com.xiaozhen.mall.tiny.dto.OmsOrderDeliveryParam;
import com.xiaozhen.mall.tiny.dto.OmsOrderDetail;
import com.xiaozhen.mall.tiny.dto.OmsReceiverInfoParam;
import com.xiaozhen.mall.tiny.mbg.mapper.OmsOrderItemMapper;
import com.xiaozhen.mall.tiny.mbg.mapper.OmsOrderMapper;
import com.xiaozhen.mall.tiny.mbg.mapper.OmsOrderOperateHistoryMapper;
import com.xiaozhen.mall.tiny.mbg.model.*;
import com.xiaozhen.mall.tiny.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @description: 订单OmsOrderService实现类
 * @create time:17:22
 * @Author: XiaoZhen
 **/
@Service
public class OmsOrderServiceImpl implements OmsOrderService {
    @Autowired
    private OmsOrderMapper orderMapper;
    @Autowired
    private OmsOrderOperateHistoryMapper oohMapper;
    @Autowired
    private OmsOrderItemMapper oiMapper;

    @Override
    public OmsOrderDetail getOrderDetail(Long id) {
        OmsOrderDetail orderDetail = new OmsOrderDetail();
        OmsOrder order = orderMapper.selectByPrimaryKey(id);
        MyUtils.cast(order, orderDetail);
        // 获取订单操作纪录列表
        OmsOrderOperateHistoryExample oohExample = new OmsOrderOperateHistoryExample();
        oohExample.createCriteria().andOrderIdEqualTo(id);
        List<OmsOrderOperateHistory> oohList = oohMapper.selectByExample(oohExample);
        orderDetail.setOrderOperateHistoryList(oohList);
        // 订单商品列表
        OmsOrderItemExample oiExample = new OmsOrderItemExample();
        oiExample.createCriteria().andOrderIdEqualTo(id);
        List<OmsOrderItem> oiList = oiMapper.selectByExample(oiExample);
        orderDetail.setOrderItemList(oiList);
        return orderDetail;
    }

    @Override
    public int deleteOrderList(Long[] ids) {
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andCouponIdIn(Arrays.asList(ids));
        return orderMapper.deleteByExample(example);
    }

    @Override
    public List<OmsOrder> listOrder(String createTime, String orderSn, Integer orderType, Integer pageNum,
                                    Integer pageSize, String receiveKeyword, Integer sourceType, Integer status) {
        OmsOrderExample example = new OmsOrderExample();
        OmsOrderExample.Criteria criteria = example.createCriteria();
        if (createTime != null && !createTime.equals("")) {
            criteria.andCreateTimeEqualTo(new Date(createTime));
        }
        if (orderSn != null && !orderSn.equals("")) {
            criteria.andOrderSnEqualTo(orderSn);
        }
        if (receiveKeyword != null && !receiveKeyword.equals("")) {
            criteria.andReceiverNameLike("%" + receiveKeyword + "%");
            criteria.andReceiverPhoneLike("%" + receiveKeyword + "%");
        }
        if (sourceType != null) {
            criteria.andSourceTypeEqualTo(sourceType);
        }
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        return orderMapper.selectByExample(example);
    }

    @Override
    public int updateStatus(Integer status, Long[] ids) {
        OmsOrder order = new OmsOrder();
        order.setStatus(status);
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        return orderMapper.updateByExample(order, example);
    }

    @Override
    public int updateDelivery(List<OmsOrderDeliveryParam> orderDeliveryParamList) {
        int rows = 0;
        for (OmsOrderDeliveryParam orderDeliveryParam : orderDeliveryParamList) {
            OmsOrder order = new OmsOrder();
            MyUtils.cast(orderDeliveryParam, order);
            order.setId(orderDeliveryParam.getOrderId());
            rows += orderMapper.updateByPrimaryKeySelective(order);
        }
        return rows;
    }

    @Override
    public int updateMoneyInfo(OMSMoneyInfoParam moneyInfoParam) {
        OmsOrder order = new OmsOrder();
        MyUtils.cast(moneyInfoParam, order);
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
        MyUtils.cast(receiverInfoParam, order);
        order.setId(receiverInfoParam.getOrderId());
        return orderMapper.updateByPrimaryKeySelective(order);
    }

}
