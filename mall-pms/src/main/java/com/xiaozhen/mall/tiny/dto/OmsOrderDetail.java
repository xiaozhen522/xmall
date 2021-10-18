package com.xiaozhen.mall.tiny.dto;

import com.xiaozhen.mall.tiny.mbg.model.OmsOrder;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrderItem;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrderOperateHistory;

import java.util.List;

/**
 * @description:
 * @create time:2021/10/18
 * @Author: XiaoZhen
 **/
public class OmsOrderDetail extends OmsOrder {
    private List<OmsOrderOperateHistory> orderOperateHistoryList;
    private List<OmsOrderItem> orderItemList;

    public List<OmsOrderOperateHistory> getOrderOperateHistoryList() {
        return orderOperateHistoryList;
    }

    public void setOrderOperateHistoryList(List<OmsOrderOperateHistory> orderOperateHistoryList) {
        this.orderOperateHistoryList = orderOperateHistoryList;
    }

    public List<OmsOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OmsOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
