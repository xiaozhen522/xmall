package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.SmsHomeAdvertise;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 首页轮播广告
 * @create time:18:38
 * @Author : XiaoZhen
 **/
public interface SmsHomeAdvertiseService {
    SmsHomeAdvertise getById(Long id);

    @Transactional
    int create(SmsHomeAdvertise homeAdvertise);

    @Transactional
    int delete(Long[] ids);

    List<SmsHomeAdvertise> list(String endTime, String name, Integer pageNum, Integer pageSize);

    @Transactional
    int updateById(Long id, SmsHomeAdvertise homeAdvertise);

    @Transactional
    int updateStatusById(Long id, Integer status);
}
