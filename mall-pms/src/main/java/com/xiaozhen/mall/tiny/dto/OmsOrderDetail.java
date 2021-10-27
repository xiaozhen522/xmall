package com.xiaozhen.mall.tiny.dto;

import com.xiaozhen.mall.tiny.mbg.model.OmsOrder;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrderItem;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrderOperateHistory;
import lombok.Data;

import java.util.List;

/**
 * @description : 订单详情:订单信息、商品信息、操作记录
 * @create time:2021/10/18
 * @Author : XiaoZhen
 **/
@Data
public class OmsOrderDetail extends OmsOrder {
    private List<OmsOrderOperateHistory> orderOperateHistoryList;
    private List<OmsOrderItem> orderItemList;
}
