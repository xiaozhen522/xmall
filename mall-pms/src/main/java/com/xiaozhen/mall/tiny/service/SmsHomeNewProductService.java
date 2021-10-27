package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.SmsHomeNewProduct;

import java.util.List;

/**
 * @description : 首页新品
 * @create time:11:35
 * @Author : XiaoZhen
 **/
public interface SmsHomeNewProductService {

    int createHomeNewProduct(SmsHomeNewProduct[] homeNewProductList);

    int deleteHomeNewProduct(Long[] ids);

    List<SmsHomeNewProduct> listHomeNewProduct(Integer pageNum, Integer pageSize, String productName, Integer recpmmendStatus);

    int updateRecommendStatus(Long[] id, Integer recommentStatus);

    int updateSort(Long id, Integer sort);

}
