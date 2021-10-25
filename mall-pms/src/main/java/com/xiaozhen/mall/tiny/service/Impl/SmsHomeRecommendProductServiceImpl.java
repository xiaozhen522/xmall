package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.mbg.mapper.SmsHomeRecommendProductMapper;
import com.xiaozhen.mall.tiny.mbg.model.SmsHomeRecommendProduct;
import com.xiaozhen.mall.tiny.mbg.model.SmsHomeRecommendProductExample;
import com.xiaozhen.mall.tiny.service.SmsHomeRecommendProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 首页人气推荐SmsHomeRecommendProductService实现类
 * @create time:13:06
 * @Author: XiaoZhen
 **/
@Service
public class SmsHomeRecommendProductServiceImpl implements SmsHomeRecommendProductService {
    @Autowired
    private SmsHomeRecommendProductMapper homeRecommendProductMapper;

    @Override
    public int createHomeRecommendProduct(SmsHomeRecommendProduct[] homeRecommendProductList) {
        int rows = 0;
        for (SmsHomeRecommendProduct homeRecommendProduct : homeRecommendProductList) {
            rows += homeRecommendProductMapper.insertSelective(homeRecommendProduct);
        }
        return rows;
    }

    @Override
    public int deleteHomeRecommendProduct(Long[] ids) {
        SmsHomeRecommendProductExample example = new SmsHomeRecommendProductExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        return homeRecommendProductMapper.deleteByExample(example);
    }


    @Override
    public List<SmsHomeRecommendProduct> listHomeRecommendProduct(Integer pageNum, Integer pageSize, String productName,
                                                                  Integer recommendStatus) {
        SmsHomeRecommendProductExample example = new SmsHomeRecommendProductExample();
        SmsHomeRecommendProductExample.Criteria criteria = example.createCriteria();
        if (productName != null && !"".equals(productName)) {
            criteria.andProductNameLike(productName);
        }
        if (recommendStatus != null) {
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        PageHelper.startPage(pageNum, pageSize);
        return homeRecommendProductMapper.selectByExample(example);
    }

    @Override
    public int updateRecommendStatus(Long[] ids, Integer recommendStatus) {
        SmsHomeRecommendProduct homeRecommendProduct = new SmsHomeRecommendProduct();
        homeRecommendProduct.setRecommendStatus(recommendStatus);
        SmsHomeRecommendProductExample example = new SmsHomeRecommendProductExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        return homeRecommendProductMapper.updateByExampleSelective(homeRecommendProduct, example);
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeRecommendProduct homeRecommendProduct = new SmsHomeRecommendProduct();
        homeRecommendProduct.setId(id);
        homeRecommendProduct.setSort(sort);
        return homeRecommendProductMapper.updateByPrimaryKeySelective(homeRecommendProduct);
    }
}
