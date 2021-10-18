package com.xiaozhen.mall.tiny.service.Impl;

import com.xiaozhen.mall.tiny.mbg.mapper.PmsSkuStockMapper;
import com.xiaozhen.mall.tiny.mbg.model.PmsSkuStock;
import com.xiaozhen.mall.tiny.mbg.model.PmsSkuStockExample;
import com.xiaozhen.mall.tiny.service.PmsSkuStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: sku商品库存PmsSkuStockService实现类
 * @create time:15:20
 * @Author: XiaoZhen
 **/
@Service
public class PmsSkuStockServiceImpl implements PmsSkuStockService {
    @Autowired
    private PmsSkuStockMapper skuMapper;

    @Override
    public List<PmsSkuStock> getSkuStock(Long id, String keyword) {
        PmsSkuStockExample example = new PmsSkuStockExample();
        example.createCriteria().andIdEqualTo(id);
        example.or().andSkuCodeLike("%" + keyword + "%");
        return skuMapper.selectByExample(example);
    }

    @Override
    public int updateSkuStockList(Long pid, PmsSkuStock[] skuStockList) {
        int rows = 0;
        for (PmsSkuStock skuStock : skuStockList) {
            skuStock.setProductId(pid);
            rows += skuMapper.updateByPrimaryKeySelective(skuStock);
        }
        return rows;
    }


}
