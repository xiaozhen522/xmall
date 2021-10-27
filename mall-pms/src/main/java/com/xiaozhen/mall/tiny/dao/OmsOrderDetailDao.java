package com.xiaozhen.mall.tiny.dao;

import com.xiaozhen.mall.tiny.dto.OmsOrderDetail;

/**
 * @description : 自定义订单详情:订单信息、商品信息、操作记录查询
 * @create time:2021/10/27
 * @Author : XiaoZhen
 **/
public interface OmsOrderDetailDao {
    OmsOrderDetail get(Long id);
}
