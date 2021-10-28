package com.xiaozhen.mall.tiny.service.Impl;

import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.component.CancelOrderSender;
import com.xiaozhen.mall.tiny.dto.OrderParam;
import com.xiaozhen.mall.tiny.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @description : OmsPortalOrderService实现类
 * @create time:2021/10/27
 * @Author : XiaoZhen
 **/
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);
    @Autowired
    private CancelOrderSender cancelOrderSender;
    @Value("${order.delayTimes}")
    private Long delayTimes;

    @Override
    public CommontResult generateOrder(OrderParam orderParam) {
        // TODO: 2021/10/27 执行一系列下单操作
        LOGGER.info("执行下单操作");
        // 下单完成后开启一个延迟消息，用于当用户没有付款时取消订单(orderId应改在下单后生成)
        Long orderId = 1L;
        sendDelayMessageCancelOrder(orderId);
        return CommontResult.success(null, "下单成功");
    }

    private void sendDelayMessageCancelOrder(Long orderId) {
        // 发送延迟消息
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }

    @Override
    public void cancelOrder(Long orderId) {
        // TODO: 2021/10/27 执行一系列取消订单操作



        LOGGER.info("执行取消订单操作 orderId:{}", orderId);
    }
}
