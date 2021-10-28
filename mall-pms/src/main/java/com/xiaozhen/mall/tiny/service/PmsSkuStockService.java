package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.PmsSkuStock;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : sku商品库存
 * @create time:15:20
 * @Author : XiaoZhen
 **/
public interface PmsSkuStockService {
    List<PmsSkuStock> getById(Long id, String keyword);

    @Transactional
    int updateById(Long pid, PmsSkuStock[] skuStockList);
}
