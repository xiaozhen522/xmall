package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.dto.PmsBrandParm;
import com.xiaozhen.mall.tiny.mbg.mapper.PmsBrandMapper;
import com.xiaozhen.mall.tiny.mbg.model.PmsBrand;
import com.xiaozhen.mall.tiny.mbg.model.PmsBrandExample;
import com.xiaozhen.mall.tiny.service.PmsBrandService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @description : 商品品牌PmsBrandService实现类
 * @create time:13:26
 * @Author : XiaoZhen
 **/
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    private PmsBrandMapper brandMapper;

    @Override
    public PmsBrand getById(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(PmsBrandParm brandParam) {
        PmsBrand brand = new PmsBrand();
        BeanUtils.copyProperties(brandParam, brand);
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int deleteById(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        PmsBrandExample example = new PmsBrandExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        return brandMapper.deleteByExample(example);
    }

    @Override
    public List<PmsBrand> list(String keyword, Integer pageNum, Integer pageSize) {
        PmsBrandExample brandExample = new PmsBrandExample();
        if (keyword != null) {
            brandExample.createCriteria().andNameLike("%" + keyword + "%");
        }
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(brandExample);
    }

    @Override
    public List<PmsBrand> listAll() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int updateById(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public int updateFactoryStatus(Integer factoryStatus, Long[] ids) {
        PmsBrandExample example = new PmsBrandExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        PmsBrand brand = new PmsBrand();
        brand.setFactoryStatus(factoryStatus);
        return brandMapper.updateByExampleSelective(brand, example);
    }

    @Override
    public int updateShowStatus(Integer showStatus, Long[] ids) {
        PmsBrandExample example = new PmsBrandExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        PmsBrand brand = new PmsBrand();
        brand.setShowStatus(showStatus);
        return brandMapper.updateByExampleSelective(brand, example);
    }

}
