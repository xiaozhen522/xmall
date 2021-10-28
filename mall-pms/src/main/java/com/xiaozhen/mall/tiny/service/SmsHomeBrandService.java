package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.SmsHomeBrand;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 首页品牌
 * @create time:19:33
 * @Author : XiaoZhen
 **/
public interface SmsHomeBrandService {
    @Transactional
    int create(SmsHomeBrand[] homeBrandList);

    @Transactional
    int delete(Long[] ids);

    List<SmsHomeBrand> list(String brandName, Integer pageNum, Integer pageSize);

    @Transactional
    int updateRecommendStatus(Long[] ids, Integer recommendStatus);

    @Transactional
    int updateSortById(Long id, Integer sort);

}
