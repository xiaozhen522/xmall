package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.common.utils.MyUtils;
import com.xiaozhen.mall.tiny.dao.ProductCategoryParamDao;
import com.xiaozhen.mall.tiny.dto.PmsProductCategoryWithChildernItem;
import com.xiaozhen.mall.tiny.dto.ProductCategoryParam;
import com.xiaozhen.mall.tiny.mbg.mapper.PmsProductCategoryAttributeRelationMapper;
import com.xiaozhen.mall.tiny.mbg.mapper.PmsProductCategoryMapper;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductCategory;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductCategoryAttributeRelation;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductCategoryExample;
import com.xiaozhen.mall.tiny.service.PmsProductCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description : 商品分类PmsProductCategoryService实现类
 * @create time:9:08
 * @Author : XiaoZhen
 **/
@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {
    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;
    @Autowired
    private ProductCategoryParamDao productCategoryParamDao;
    @Autowired
    private PmsProductCategoryAttributeRelationMapper productCategoryAttributeRelationMapper;

    @Override
    public PmsProductCategory getById(Long id) {
        return productCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(ProductCategoryParam productCategoryParam) {
        int rows = 0;
        PmsProductCategory pc = new PmsProductCategory();
        BeanUtils.copyProperties(productCategoryParam, pc);
        rows += productCategoryMapper.insertSelective(pc);

        Long pcId = pc.getId();
        List<Long> ids = productCategoryParam.getProductAttributeIdList();
        for (Long id : ids) {
            PmsProductCategoryAttributeRelation pcar = new PmsProductCategoryAttributeRelation();
            pcar.setProductCategoryId(pcId);
            pcar.setProductAttributeId(id);
            rows += productCategoryAttributeRelationMapper.insertSelective(pcar);
        }
        return rows;
    }

    @Override
    public int deleteById(Long id) {
        return productCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsProductCategory> listByParentId(Integer pageNum, Integer pageSize, Long parentId) {
        PmsProductCategoryExample pce = new PmsProductCategoryExample();
        pce.createCriteria().andParentIdEqualTo(parentId);
        PageHelper.startPage(pageNum, pageSize);
        return productCategoryMapper.selectByExample(pce);
    }

    @Override
    public List<PmsProductCategoryWithChildernItem> listWithChildren(Long id) {
        return productCategoryParamDao.listWithChildren(id);
    }

    @Override
    public int updateById(Long id, ProductCategoryParam productCategoryParam) {
        PmsProductCategory productCategory = new PmsProductCategory();
        MyUtils.cast(productCategoryParam, productCategory);
        productCategory.setId(id);
        return productCategoryMapper.updateByPrimaryKey(productCategory);
    }

    @Override
    public int updateNavStatus(Integer navStatus, Long[] ids) {
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setNavStatus(navStatus);
        return productCategoryMapper.updateByExampleSelective(productCategory, example);
    }

    @Override
    public int updateShowStatus(Integer showStatus, Long[] ids) {
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setShowStatus(showStatus);
        return productCategoryMapper.updateByExampleSelective(productCategory, example);
    }

}
