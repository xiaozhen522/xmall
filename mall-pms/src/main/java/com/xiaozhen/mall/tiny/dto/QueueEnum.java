package com.xiaozhen.mall.tiny.dto;

import lombok.Getter;

/**
 * @description :
 * @create time:2021/10/27
 * @Author : XiaoZhen
 **/
@Getter
public enum QueueEnum {
    /*
     * 消息通知队列
     * */
    QUEUE_ORDER_CANCEL("mall.order.direct", "mall.order.cancel", "mall.order.cancel"),
    /*
     * 消息通知ttl队列
     * */
    QUEUE_TTL_ORDER_CANCEL("mall.order.direct.ttl", "mall.ordercancel.ttl", "mall.order.cancel.ttl"),
    ;
    /*
     * 交换机名称
     * */
    private String exchange;
    /*
     * 队列名称
     * */
    private String name;
    /*
     * 路由键
     * */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
