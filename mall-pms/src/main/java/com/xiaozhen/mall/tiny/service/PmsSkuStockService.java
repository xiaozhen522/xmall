package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.PmsSkuStock;

import java.util.List;

/**
 * @description: sku商品库存
 * @create time:15:20
 * @Author: XiaoZhen
 **/
public interface PmsSkuStockService {
    /**
     * @description: 获取指定id的sku商品库存
     * @param: id   sku商品库存id
     * @return: sku商品库存对象
     */
    List<PmsSkuStock> getSkuStock(Long id, String keyword);

    int updateSkuStockList(Long pid, PmsSkuStock[] skuStockList);
}
