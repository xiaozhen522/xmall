package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.SmsHomeNewProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 首页新品
 * @create time:11:35
 * @Author : XiaoZhen
 **/
public interface SmsHomeNewProductService {
    @Transactional
    int create(SmsHomeNewProduct[] homeNewProductList);

    @Transactional
    int delete(Long[] ids);

    List<SmsHomeNewProduct> list(Integer pageNum, Integer pageSize, String productName, Integer recpmmendStatus);

    @Transactional
    int updateRecommendStatus(Long[] id, Integer recommentStatus);

    @Transactional
    int updateSortById(Long id, Integer sort);

}
