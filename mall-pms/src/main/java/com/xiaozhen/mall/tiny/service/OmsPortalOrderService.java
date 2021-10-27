package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description : 前台订单管理Service
 * @create time:2021/10/27
 * @Author : XiaoZhen
 **/
public interface OmsPortalOrderService {
    /**
     * 根据提交信息生成订单
     *
     * @param orderParam
     * @return
     */
    @Transactional
    CommontResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     *
     * @param orderId
     */
    @Transactional
    void cancelOrder(Long orderId);
}
