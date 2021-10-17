package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.common.utils.MyUtils;
import com.xiaozhen.mall.tiny.dto.PmsProductAttributeCategoryItem;
import com.xiaozhen.mall.tiny.mbg.mapper.PmsProductAttributeCategoryMapper;
import com.xiaozhen.mall.tiny.mbg.mapper.PmsProductAttributeMapper;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductAttribute;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductAttributeCategory;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductAttributeCategoryExample;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductAttributeExample;
import com.xiaozhen.mall.tiny.service.PmsProductAttributeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 商品属性分类PmsProductAttributeCategoryService实现类
 * @create time:16:17
 * @Author: XiaoZhen
 **/
@Service
public class PmsProductAttributeCategoryServiceImpl implements PmsProductAttributeCategoryService {
    @Autowired
    private PmsProductAttributeCategoryMapper productAttributeCategoryMapper;
    @Autowired
    private PmsProductAttributeMapper productAttributeMapper;

    @Override
    public PmsProductAttributeCategory getProductAttributeCategory(Long id) {
        return productAttributeCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int createProductAttributeCategory(String name) {
        PmsProductAttributeCategory productAttributeCategory = new PmsProductAttributeCategory();
        productAttributeCategory.setName(name);
        return productAttributeCategoryMapper.insertSelective(productAttributeCategory);
    }

    @Override
    public int deleteProductAttributeCategory(Long id) {
        return productAttributeCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsProductAttributeCategory> listProductAttributeCategory(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return productAttributeCategoryMapper.selectByExample(new PmsProductAttributeCategoryExample());
    }

    @Override
    public List<PmsProductAttributeCategoryItem> listAllProductAttributeCategory() {
        // 获取商品属性分类表
        List<PmsProductAttributeCategory> productAttributeCategoryList = productAttributeCategoryMapper.selectByExample(new PmsProductAttributeCategoryExample());
        List<PmsProductAttributeCategoryItem> productAttributeCategoryItemList = new ArrayList<>();
        for (PmsProductAttributeCategory productAttributeCategory : productAttributeCategoryList) {
            // 转换对象
            PmsProductAttributeCategoryItem productAttributeCategoryItem = new PmsProductAttributeCategoryItem();
            MyUtils.cast(productAttributeCategory, productAttributeCategoryItem);
            // 查询商品属性参数
            PmsProductAttributeExample productAttributeExample = new PmsProductAttributeExample();
            productAttributeExample.createCriteria().andProductAttributeCategoryIdEqualTo(productAttributeCategory.getId());
            List<PmsProductAttribute> productAttributeList = productAttributeMapper.selectByExample(productAttributeExample);
            // 为返回对象赋值
            productAttributeCategoryItem.setProductAttributeList(productAttributeList);
            productAttributeCategoryItemList.add(productAttributeCategoryItem);
        }
        return productAttributeCategoryItemList;
    }

    @Override
    public int updateProductAttributeCategory(Long id, String name) {
        PmsProductAttributeCategory productAttributeCategory = new PmsProductAttributeCategory();
        productAttributeCategory.setId(id);
        productAttributeCategory.setName(name);
        return productAttributeCategoryMapper.updateByPrimaryKey(productAttributeCategory);
    }
}
