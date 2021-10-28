package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.OMSMoneyInfoParam;
import com.xiaozhen.mall.tiny.dto.OmsOrderDeliveryParam;
import com.xiaozhen.mall.tiny.dto.OmsOrderDetail;
import com.xiaozhen.mall.tiny.dto.OmsReceiverInfoParam;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 订单管理Service
 * @create time:17:22
 * @Author : XiaoZhen
 **/
public interface OmsOrderService {
    /**
     * 获取订单详情:订单信息、商品信息、操作记录
     *
     * @param id 订单id
     * @return 订单对象
     */
    OmsOrderDetail getById(Long id);

    /**
     * 批量删除订单
     *
     * @param ids 订单id列表
     * @return 删除行数
     */
    @Transactional
    int delete(Long[] ids);

    /**
     * 根据条件分页查询订单
     *
     * @param createTime     订单创建时间
     * @param orderSn        订单sn
     * @param orderType      订单类型
     * @param pageNum        页码
     * @param pageSize       每页数量
     * @param receiveKeyword 收货人姓名/号码关键字
     * @param sourceType     订单来源
     * @param status         订单状态
     * @return List
     */
    List<OmsOrder> list(String createTime, String orderSn, Integer orderType, Integer pageNum, Integer pageSize, String receiveKeyword, Integer sourceType, Integer status);

    /**
     * 批量更新订单状态
     *
     * @param status 订单状态
     * @param ids    订单id列表
     * @return 更新行数
     */
    @Transactional
    int updateStatus(Integer status, Long[] ids);

    /**
     * 更新物流信息
     *
     * @param orderDeliveryParamList 订单物流信息列表
     * @return 更新行数
     */
    @Transactional
    int updateDelivery(List<OmsOrderDeliveryParam> orderDeliveryParamList);

    /**
     * 更新订单费用
     *
     * @param moneyInfoParam 订单费用信息对象
     * @return 更新行数
     */
    @Transactional
    int updateMoneyInfo(OMSMoneyInfoParam moneyInfoParam);

    /**
     * 备注订单
     *
     * @param id     订单id
     * @param note   备注
     * @param status 订单状态
     * @return 更新行数
     */
    @Transactional
    int updateNoteById(Long id, String note, Integer status);

    /**
     * 修改收货人信息
     *
     * @param receiverInfoParam 收货人信息
     * @return 更新行数
     */
    @Transactional
    int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam);
}
