package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.SmsHomeAdvertise;

import java.util.List;

/**
 * @description: 首页轮播广告
 * @create time:18:38
 * @Author: XiaoZhen
 **/
public interface SmsHomeAdvertiseService {
    /**
     * @description: 获取指定id的首页轮播广告
     * @param: id   首页轮播广告id
     * @return: 首页轮播广告对象
     */
    SmsHomeAdvertise getHomeAdvertise(Long id);

    /**
     * @description: 创建新的首页轮播广告
     * @param: home  新的首页轮播广告
     * @return: 影响行数
     */
    int createHomeAdvertise(SmsHomeAdvertise homeAdvertise);

    /**
     * @description: 删除指定id的首页轮播广告
     * @param: id   首页轮播广告id
     * @return: 影响行数
     */
    int deleteHomeAdvertise(Long[] ids);

    /**
     * @description: 分页查询首页轮播广告
     * @param: pageNum  页码
     * @param: pageSize 每页数量
     * @return: 首页轮播广告对象列表
     */
    List<SmsHomeAdvertise> listHomeAdvertise(String endTime, String name, Integer pageNum, Integer pageSize);

    /**
     * @description: 更新指定id的首页轮播广告
     * @param: id   首页轮播广告id
     * @param: home  新的首页轮播广告
     * @return: 影响行数
     */
    int updateHomeAdvertise(Long id, SmsHomeAdvertise homeAdvertise);

    int updateStatus(Long id, Integer status);
}
