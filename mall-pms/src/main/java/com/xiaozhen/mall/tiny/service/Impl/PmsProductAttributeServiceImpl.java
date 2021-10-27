package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.dao.ProductAttrInfoDao;
import com.xiaozhen.mall.tiny.dto.ProductAttrInfo;
import com.xiaozhen.mall.tiny.dto.ProductAttributeParam;
import com.xiaozhen.mall.tiny.mbg.mapper.PmsProductAttributeMapper;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductAttribute;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductAttributeExample;
import com.xiaozhen.mall.tiny.service.PmsProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @description : 商品属性PmsProductAttributeService实现类
 * @create time:18:44
 * @Author : XiaoZhen
 **/
@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {
    @Autowired
    private PmsProductAttributeMapper productAttributeMapper;
    @Autowired
    private ProductAttrInfoDao productAttrInfoDao;

    @Override
    public List<ProductAttrInfo> getAttrInfoByproductCategoryId(Long productCategoryId) {
        return productAttrInfoDao.getAttrInfoByproductCategoryId(productCategoryId);
    }

    @Override
    public PmsProductAttribute getById(Long id) {
        return productAttributeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(ProductAttributeParam productAttributeParam) {
        return productAttributeMapper.insertSelective(productAttributeParam);
    }

    @Override
    public int delete(Long[] ids) {
        PmsProductAttributeExample productAttributeExample = new PmsProductAttributeExample();
        productAttributeExample.createCriteria().andIdIn(Arrays.asList(ids));
        return productAttributeMapper.deleteByExample(productAttributeExample);
    }

    @Override
    public List<PmsProductAttribute> listByCidOrType(Long cid, Integer pageNum, Integer pageSize, Integer type) {
        PmsProductAttributeExample productAttributeExample = new PmsProductAttributeExample();
        PmsProductAttributeExample.Criteria criteria = productAttributeExample.createCriteria();
        if (cid != null) {
            criteria.andProductAttributeCategoryIdEqualTo(cid);
        }
        if (type != null) {
            criteria.andTypeEqualTo(type);
        }
        PageHelper.startPage(pageNum, pageSize);
        return productAttributeMapper.selectByExample(productAttributeExample);
    }

    @Override
    public int updateById(Long id, ProductAttributeParam productAttributeParam) {
        productAttributeParam.setId(id);
        return productAttributeMapper.updateByPrimaryKey(productAttributeParam);
    }
}
