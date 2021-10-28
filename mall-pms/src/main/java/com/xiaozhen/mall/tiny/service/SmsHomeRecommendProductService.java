package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.SmsHomeRecommendProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 首页人气推荐
 * @create time:13:06
 * @Author : XiaoZhen
 **/
public interface SmsHomeRecommendProductService {
    @Transactional
    int create(SmsHomeRecommendProduct[] homeRecommendProductList);

    @Transactional
    int delete(Long[] ids);

    List<SmsHomeRecommendProduct> list(Integer pageNum, Integer pageSize, String productName, Integer recommendStatus);

    @Transactional
    int updateRecommendStatus(Long[] id, Integer recommentStatus);

    @Transactional
    int updateSortById(Long id, Integer sort);
}
