package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.OmsUpdateStatusParam;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrderReturnApply;

import java.util.List;

/**
 * @description: 订单退货申请
 * @create time:10:45
 * @Author: XiaoZhen
 **/
public interface OmsOrderReturnApplyService {
    /**
     * @description: 获取指定id的订单退货申请
     * @param: id   订单退货申请id
     * @return: 订单退货申请对象
     */
    OmsOrderReturnApply getOrderReturnApply(Long id);

    /**
     * @description: 删除指定id的订单退货申请
     * @param: id   订单退货申请id
     * @return: 影响行数
     */
    int deleteOrderReturnApplyList(Long[] ids);

    /**
     * @description: 分页查询订单退货申请
     * @param: pageNum  页码
     * @param: pageSize 每页数量
     * @return: 订单退货申请对象列表
     */
    List<OmsOrderReturnApply> listOrderReturnApply(String createTime, String handleMan, String handleTime, Long id, Integer pageNum, Integer pageSize, String receiverKeyword, Integer ststus);

    /**
     * @description: 更新指定id的订单退货申请
     * @param: id   订单退货申请id
     * @param: returnApply  新的订单退货申请
     * @return: 影响行数
     */
    int updateStatus(Long id, OmsUpdateStatusParam statusParam);

}
