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
    private PmsProductCategoryAttributeRelationMapper pcarMapper;

    @Override
    public PmsProductCategory getById(Long id) {
        return productCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(ProductCategoryParam productCategoryParam) {
//        return productCategoryParamDao.create(productCategoryParam);
        int rows = 0;
        PmsProductCategory pc = new PmsProductCategory();
        MyUtils.cast(productCategoryParam, pc);
        productCategoryMapper.insertSelective(pc);
        rows++;
        Long pcId = pc.getId();
        List<Long> ids = productCategoryParam.getProductAttributeIdList();
        for (Long id : ids) {
            PmsProductCategoryAttributeRelation pcar = new PmsProductCategoryAttributeRelation();
            pcar.setProductCategoryId(pcId);
            pcar.setProductAttributeId(id);
            pcarMapper.insertSelective(pcar);
            rows++;
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
    public List<PmsProductCategoryWithChildernItem> listWithChildern() {
        PmsProductCategoryExample pcExample1 = new PmsProductCategoryExample();
        pcExample1.createCriteria().andParentIdEqualTo(0L);
        List<PmsProductCategory> pcList1 = productCategoryMapper.selectByExample(pcExample1);
        List<PmsProductCategoryWithChildernItem> pcwciList = new ArrayList<>();
        for (PmsProductCategory productCategory : pcList1) {
            PmsProductCategoryWithChildernItem pcwcItem = new PmsProductCategoryWithChildernItem();
            MyUtils.cast(productCategory, pcwcItem);
            PmsProductCategoryExample pcExample2 = new PmsProductCategoryExample();
            pcExample2.createCriteria().andParentIdEqualTo(productCategory.getId());
            List<PmsProductCategory> pcList = productCategoryMapper.selectByExample(pcExample2);
            pcwcItem.setChildren(pcList);
            pcwciList.add(pcwcItem);
        }
        return pcwciList;
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
