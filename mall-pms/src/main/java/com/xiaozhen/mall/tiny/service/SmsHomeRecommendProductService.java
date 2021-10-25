package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.SmsHomeRecommendProduct;

import java.util.List;

/**
 * @description: 首页人气推荐
 * @create time:13:06
 * @Author: XiaoZhen
 **/
public interface SmsHomeRecommendProductService {

    int createHomeRecommendProduct(SmsHomeRecommendProduct[] homeRecommendProductList);

    int deleteHomeRecommendProduct(Long[] ids);

    List<SmsHomeRecommendProduct> listHomeRecommendProduct(Integer pageNum, Integer pageSize, String productName, Integer recommendStatus);

    int updateRecommendStatus(Long[] id, Integer recommentStatus);

    int updateSort(Long id, Integer sort);
}
