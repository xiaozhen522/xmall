package com.xiaozhen.mall.tiny.service;

/**
 * @description : redis操作Service,对象都以json形式存储
 * @create time:2021/10/26
 * @Author : XiaoZhen
 **/
public interface RedisService {

    void set(String key, String value);

    boolean expire(String key, Long expire);

    String get(String key);

    void remove(String key);

    Long increment(String key, Long delta);
}
