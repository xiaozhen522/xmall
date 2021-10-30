package com.xiaozhen.mall.tiny.service;

/**
 * @description : redis操作Service,对象都以json形式存储
 * @create time:2021/10/26
 * @Author : XiaoZhen
 **/
public interface RedisService {
    /**
     * 创建新的键值对
     *
     * @param key   键
     * @param value 值
     */
    void set(String key, String value);

    /**
     * 设置过期时间
     *
     * @param key    键
     * @param expire 过期时间
     */
    boolean expire(String key, Long expire);

    /**
     * 获取指定键的值
     *
     * @param key 键
     * @return 值
     */
    String get(String key);

    /**
     * 删除指定键值对
     *
     * @param key 键
     */
    void remove(String key);

    /**
     * 设置自增步长
     *
     * @param key   键
     * @param delta 步长
     */
    Long increment(String key, Long delta);
}
