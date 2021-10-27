package com.xiaozhen.mall.tiny.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @description : 订单超时取消并解锁库存的定时器
 * @create time:2021/10/26
 * @Author : XiaoZhen
 **/
public class OrderTimeOutCancelTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);

    /**
     * cron表达式: Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * 每10分钟扫描一次，扫描设定超时时间之前下的订单，如果没支付则取消该订单
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutOrder() {
        // TODO: 2021/10/26 此处应调用取消订单的方法
        LOGGER.info("取消订单,并根据sku编号释放锁定库存");
    }
}
