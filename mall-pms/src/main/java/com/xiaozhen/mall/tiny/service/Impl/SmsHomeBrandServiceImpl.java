package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.mbg.mapper.SmsHomeBrandMapper;
import com.xiaozhen.mall.tiny.mbg.model.SmsHomeBrand;
import com.xiaozhen.mall.tiny.mbg.model.SmsHomeBrandExample;
import com.xiaozhen.mall.tiny.service.SmsHomeBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @description : 首页品牌SmsHomeBrandService实现类
 * @create time:19:33
 * @Author : XiaoZhen
 **/
@Service
public class SmsHomeBrandServiceImpl implements SmsHomeBrandService {
    @Autowired
    private SmsHomeBrandMapper homeBrandMapper;

    @Override
    public int createHomeBrands(SmsHomeBrand[] homeBrandList) {
        int rows = 0;
        for (SmsHomeBrand homeBrand : homeBrandList) {
            rows += homeBrandMapper.insertSelective(homeBrand);
        }
        return rows;
    }

    @Override
    public int deleteHomeBrands(Long[] ids) {
        SmsHomeBrandExample example = new SmsHomeBrandExample();
        example.createCriteria().andBrandIdIn(Arrays.asList(ids));
        return homeBrandMapper.deleteByExample(example);
    }

    @Override
    public List<SmsHomeBrand> listHomeBrand(String brandName, Integer pageNum, Integer pageSize) {
        SmsHomeBrandExample example = new SmsHomeBrandExample();
        System.out.println(brandName);
        if (brandName != null && !"".equals(brandName)) {
            example.createCriteria().andBrandNameLike("%" + brandName + "%");
        }
        PageHelper.startPage(pageNum, pageSize);
        return homeBrandMapper.selectByExample(example);
    }

    @Override
    public int updateStatus(Long[] ids, Integer recommendStatus) {
        SmsHomeBrand homeBrand = new SmsHomeBrand();
        homeBrand.setRecommendStatus(recommendStatus);
        SmsHomeBrandExample example = new SmsHomeBrandExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        return homeBrandMapper.updateByExampleSelective(homeBrand, example);
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeBrand homeBrand = new SmsHomeBrand();
        homeBrand.setId(id);
        homeBrand.setSort(sort);
        return homeBrandMapper.updateByPrimaryKeySelective(homeBrand);
    }

}
