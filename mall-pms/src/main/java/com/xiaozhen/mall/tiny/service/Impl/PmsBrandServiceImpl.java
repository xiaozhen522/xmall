package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.common.utils.MyUtils;
import com.xiaozhen.mall.tiny.dto.PmsBrandParm;
import com.xiaozhen.mall.tiny.mbg.mapper.PmsBrandMapper;
import com.xiaozhen.mall.tiny.mbg.model.PmsBrand;
import com.xiaozhen.mall.tiny.mbg.model.PmsBrandExample;
import com.xiaozhen.mall.tiny.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 商品品牌PmsBrandService实现类
 * @create time:13:26
 * @Author: XiaoZhen
 **/
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    private PmsBrandMapper brandMapper;

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int createBrand(PmsBrandParm brandParam) {
        PmsBrand brand = new PmsBrand();
        MyUtils.cast(brandParam, brand);
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBrandBatch(Long[] ids) {
        PmsBrandExample brandExample = new PmsBrandExample();
        brandExample.createCriteria().andIdIn(Arrays.asList(ids));
        return brandMapper.deleteByExample(brandExample);
    }

    @Override
    public List<PmsBrand> listBrand(String keyword, Integer pageNum, Integer pageSize) {
        PmsBrandExample brandExample = new PmsBrandExample();
        if (keyword != null && !keyword.equals("")) {
            brandExample.createCriteria().andNameLike("%" + keyword + "%");
        }
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(brandExample);
    }

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public int updateFactoryStatus(Integer factoryStatus, Long[] ids) {
        PmsBrandExample brandExample = new PmsBrandExample();
        brandExample.createCriteria().andIdIn(Arrays.asList(ids));
        PmsBrand pmsBrand = new PmsBrand();
        pmsBrand.setFactoryStatus(factoryStatus);
        return brandMapper.updateByExampleSelective(pmsBrand, brandExample);
    }

    @Override
    public int updateShowStatus(Integer showStatus, Long[] ids) {
        PmsBrandExample brandExample = new PmsBrandExample();
        brandExample.createCriteria().andIdIn(Arrays.asList(ids));
        PmsBrand pmsBrand = new PmsBrand();
        pmsBrand.setShowStatus(showStatus);
        return brandMapper.updateByExampleSelective(pmsBrand, brandExample);
    }

}
