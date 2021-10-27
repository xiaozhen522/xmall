package com.xiaozhen.mall.tiny.component;

import com.xiaozhen.mall.tiny.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description : 取消订单消息的处理者
 * @create time:2021/10/27
 * @Author : XiaoZhen
 **/
@Component
@RabbitListener(queues = "mall.order.cancel")
public class CancelOrderReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(CancelOrderReceiver.class);
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @RabbitHandler
    public void handle(Long orderId) {
        LOGGER.info("接受延迟消息 orderId:{}", orderId);
        portalOrderService.cancelOrder(orderId);
    }
}
