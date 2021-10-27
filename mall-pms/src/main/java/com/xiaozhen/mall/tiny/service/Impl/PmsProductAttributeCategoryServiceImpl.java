package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.dao.PmsProductAttributeCategoryItemDao;
import com.xiaozhen.mall.tiny.dto.PmsProductAttributeCategoryItem;
import com.xiaozhen.mall.tiny.mbg.mapper.PmsProductAttributeCategoryMapper;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductAttributeCategory;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductAttributeCategoryExample;
import com.xiaozhen.mall.tiny.service.PmsProductAttributeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description : 商品属性分类PmsProductAttributeCategoryService实现类
 * @create time:16:17
 * @Author : XiaoZhen
 **/
@Service
public class PmsProductAttributeCategoryServiceImpl implements PmsProductAttributeCategoryService {
    @Autowired
    private PmsProductAttributeCategoryMapper productAttributeCategoryMapper;
    @Autowired
    private PmsProductAttributeCategoryItemDao productAttributeCategoryItemDao;

    @Override
    public PmsProductAttributeCategory getById(Long id) {
        return productAttributeCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(String name) {
        PmsProductAttributeCategory productAttributeCategory = new PmsProductAttributeCategory();
        productAttributeCategory.setName(name);
        return productAttributeCategoryMapper.insertSelective(productAttributeCategory);
    }

    @Override
    public int deleteById(Long id) {
        return productAttributeCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsProductAttributeCategory> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return productAttributeCategoryMapper.selectByExample(new PmsProductAttributeCategoryExample());
    }

    @Override
    public List<PmsProductAttributeCategoryItem> listAllWithAttr() {
        return productAttributeCategoryItemDao.listAllWithAttr();
    }

    @Override
    public int updateById(Long id, String name) {
        PmsProductAttributeCategory productAttributeCategory = new PmsProductAttributeCategory();
        productAttributeCategory.setId(id);
        productAttributeCategory.setName(name);
        return productAttributeCategoryMapper.updateByPrimaryKeySelective(productAttributeCategory);
    }
}
