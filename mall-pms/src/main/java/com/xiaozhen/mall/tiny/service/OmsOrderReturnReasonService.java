package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.OmsOrderReturnReason;

import java.util.List;

/**
 * @description: 退货原因
 * @create time:20:56
 * @Author: XiaoZhen
 **/
public interface OmsOrderReturnReasonService {
    /**
     * @description: 获取指定id的退货原因
     * @param: id   退货原因id
     * @return: 退货原因对象
     */
    OmsOrderReturnReason getOrderReturnReason(Long id);

    /**
     * @description: 创建新的退货原因
     * @param: returnReason  新的退货原因
     * @return: 影响行数
     */
    int createOrderReturnReason(OmsOrderReturnReason returnReason);

    /**
     * @description: 删除指定id的退货原因
     * @param: id   退货原因id
     * @return: 影响行数
     */
    int deleteOrderReturnReasonList(Long[] id);

    /**
     * @description: 更新指定id的退货原因
     * @param: id   退货原因id
     * @param: returnReason  新的退货原因
     * @return: 影响行数
     */
    int updateOrderReturnReason(Long id, OmsOrderReturnReason returnReason);

    /**
     * @description: 分页查询退货原因
     * @param: pageNum  页码
     * @param: pageSize 每页数量
     * @return: 退货原因对象列表
     */
    List<OmsOrderReturnReason> listOrderReturnReason(Integer pageNum, Integer pageSize);

    int updateStatus(Long[] ids, Integer status);
}
