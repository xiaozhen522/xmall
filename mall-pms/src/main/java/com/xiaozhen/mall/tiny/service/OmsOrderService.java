package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.OMSMoneyInfoParam;
import com.xiaozhen.mall.tiny.dto.OmsOrderDeliveryParam;
import com.xiaozhen.mall.tiny.dto.OmsOrderDetail;
import com.xiaozhen.mall.tiny.dto.OmsReceiverInfoParam;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrder;

import java.util.List;

/**
 * @description: 订单
 * @create time:17:22
 * @Author: XiaoZhen
 **/
public interface OmsOrderService {
    /**
     * @description: 获取指定id的订单
     * @param: id   订单id
     * @return: 订单对象
     */
    OmsOrderDetail getOrderDetail(Long id);

    /**
     * @description: 删除指定id的订单
     * @param: id   订单id
     * @return: 影响行数
     */
    int deleteOrderList(Long[] ids);

    /**
     * @description: 分页查询订单
     * @param: pageNum  页码
     * @param: pageSize 每页数量
     * @return: 订单对象列表
     */

    List<OmsOrder> listOrder(String createTime, String orderSn, Integer orderType, Integer pageNum, Integer pageSize, String receiveKeyword, Integer sourceType, Integer status);


    int updateStatus(Integer status, Long[] ids);

    int updateDelivery(List<OmsOrderDeliveryParam> orderDeliveryParamList);

    int updateMoneyInfo(OMSMoneyInfoParam moneyInfoParam);

    int updateNote(Long id, String note, Integer status);

    int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam);
}
