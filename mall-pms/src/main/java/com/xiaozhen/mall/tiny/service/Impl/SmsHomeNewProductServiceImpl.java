package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.mbg.mapper.SmsHomeNewProductMapper;
import com.xiaozhen.mall.tiny.mbg.model.SmsHomeNewProduct;
import com.xiaozhen.mall.tiny.mbg.model.SmsHomeNewProductExample;
import com.xiaozhen.mall.tiny.service.SmsHomeNewProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @description : 首页新品SmsHomeNewProductService实现类
 * @create time:11:35
 * @Author : XiaoZhen
 **/
@Service
public class SmsHomeNewProductServiceImpl implements SmsHomeNewProductService {
    @Autowired
    private SmsHomeNewProductMapper homeNewProductMapper;

    @Override
    public int create(SmsHomeNewProduct[] homeNewProductList) {
        int rows = 0;
        for (SmsHomeNewProduct homeNewProduct : homeNewProductList) {
            rows += homeNewProductMapper.insertSelective(homeNewProduct);
        }
        return rows;
    }

    @Override
    public int delete(Long[] ids) {
        SmsHomeNewProductExample example = new SmsHomeNewProductExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        return homeNewProductMapper.deleteByExample(example);
    }

    @Override
    public List<SmsHomeNewProduct> list(Integer pageNum, Integer pageSize, String productName, Integer recpmmendStatus) {
        SmsHomeNewProductExample example = new SmsHomeNewProductExample();
        SmsHomeNewProductExample.Criteria criteria = example.createCriteria();
        if (productName != null) {
            criteria.andProductNameLike("%" + productName + "%");
        }
        if (recpmmendStatus != null) {
            criteria.andRecommendStatusEqualTo(recpmmendStatus);
        }
        PageHelper.startPage(pageNum, pageSize);
        return homeNewProductMapper.selectByExample(example);
    }

    @Override
    public int updateRecommendStatus(Long[] ids, Integer recommendStatus) {
        SmsHomeNewProduct homeNewProduct = new SmsHomeNewProduct();
        homeNewProduct.setRecommendStatus(recommendStatus);
        SmsHomeNewProductExample example = new SmsHomeNewProductExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        return homeNewProductMapper.updateByExampleSelective(homeNewProduct, example);
    }

    @Override
    public int updateSortById(Long id, Integer sort) {
        SmsHomeNewProduct homeNewProduct = new SmsHomeNewProduct();
        homeNewProduct.setId(id);
        homeNewProduct.setSort(sort);
        return homeNewProductMapper.updateByPrimaryKeySelective(homeNewProduct);
    }

}
