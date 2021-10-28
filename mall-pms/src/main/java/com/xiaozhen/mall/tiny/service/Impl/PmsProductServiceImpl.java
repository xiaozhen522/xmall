package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.dao.PmsProductResultDao;
import com.xiaozhen.mall.tiny.dto.PmsProductParam;
import com.xiaozhen.mall.tiny.dto.PmsProductResult;
import com.xiaozhen.mall.tiny.mbg.mapper.*;
import com.xiaozhen.mall.tiny.mbg.model.*;
import com.xiaozhen.mall.tiny.service.PmsProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @description : 商品PmsProductService实现类
 * @create time:11:26
 * @Author : XiaoZhen
 **/
@Service
public class PmsProductServiceImpl implements PmsProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsProductServiceImpl.class);
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private PmsMemberPriceMapper memberPriceMapper;
    @Autowired
    private CmsPrefrenceAreaProductRelationMapper prefrenceAreaProductRelationMapper;
    @Autowired
    private PmsProductAttributeValueMapper productAttributeValueMapper;
    @Autowired
    private PmsProductFullReductionMapper productFullReductionMapper;
    @Autowired
    private PmsProductLadderMapper productLadderMapper;
    @Autowired
    private PmsSkuStockMapper skuStockMapper;
    @Autowired
    private CmsSubjectProductRelationMapper subjectProductRelationMapper;
    @Autowired
    private PmsProductResultDao productResultDao;

    @Override
    public int create(PmsProductParam productParam) {
        int rows = 0;
        // 商品会员价格设置
        List<PmsMemberPrice> memberPriceList = productParam.getMemberPriceList();
        for (PmsMemberPrice memberPrice : memberPriceList) {
            rows += memberPriceMapper.insertSelective(memberPrice);
        }
        // 优选专区和商品的关系
        List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList = productParam.getPrefrenceAreaProductRelationList();
        for (CmsPrefrenceAreaProductRelation prefrenceAreaProductRelation : prefrenceAreaProductRelationList) {
            rows += prefrenceAreaProductRelationMapper.insertSelective(prefrenceAreaProductRelation);
        }
        // 商品参数及自定义规格属性
        List<PmsProductAttributeValue> productAttributeValueList = productParam.getProductAttributeValueList();
        for (PmsProductAttributeValue productAttributeValue : productAttributeValueList) {
            rows += productAttributeValueMapper.insertSelective(productAttributeValue);
        }
        // 商品满减价格设置
        List<PmsProductFullReduction> productFullReductionList = productParam.getProductFullReductionList();
        for (PmsProductFullReduction productFullReduction : productFullReductionList) {
            rows += productFullReductionMapper.insertSelective(productFullReduction);
        }
        // 商品阶梯价格设置
        List<PmsProductLadder> productLadderList = productParam.getProductLadderList();
        for (PmsProductLadder productLadder : productLadderList) {
            rows += productLadderMapper.insertSelective(productLadder);
        }
        // 商品的sku库存信息
        List<PmsSkuStock> skuStockList = productParam.getSkuStockList();
        for (PmsSkuStock skuStock : skuStockList) {
            rows += skuStockMapper.insertSelective(skuStock);
        }
        // 专题和商品关系
        List<CmsSubjectProductRelation> subjectProductRelationList = productParam.getSubjectProductRelationList();
        for (CmsSubjectProductRelation subjectProductRelation : subjectProductRelationList) {
            rows += subjectProductRelationMapper.insertSelective(subjectProductRelation);
        }
        rows += productMapper.insertSelective(productParam);
        return rows;
    }

    @Override
    public List<PmsProduct> list(Long brandId, String keyword, Integer pageNum, Integer pageSize,
                                 Long productCategoryId, String productSn, Integer publishStatus,
                                 Integer verifyStatus) {
        PmsProductExample example = new PmsProductExample();
        PmsProductExample.Criteria criteria = example.createCriteria();
        if (brandId != null) {
            criteria.andBrandIdEqualTo(brandId);
        }
        if (keyword != null) {
            criteria.andKeywordsLike("%" + keyword + "%");
        }
        if (productCategoryId != null) {
            criteria.andProductCategoryIdEqualTo(productCategoryId);
        }
        if (productSn != null && productSn.equals("")) {
            criteria.andProductSnEqualTo(productSn);
        }
        if (publishStatus != null) {
            criteria.andPublishStatusEqualTo(publishStatus);
        }
        if (verifyStatus != null) {
            criteria.andVerifyStatusEqualTo(verifyStatus);
        }
        PageHelper.startPage(pageNum, pageSize);
        return productMapper.selectByExample(example);
    }

    @Override
    public List<PmsProduct> simpleList(String keyword) {
        return list(null, keyword, 1, 5, null, null, null, null);
    }

    @Override
    public int updateById(Long id, PmsProductParam productParam) {
        int rows = 0;
        productParam.setId(id);
        // 商品会员价格设置
        List<PmsMemberPrice> memberPriceList = productParam.getMemberPriceList();
        for (PmsMemberPrice memberPrice : memberPriceList) {
            rows += memberPriceMapper.updateByPrimaryKeySelective(memberPrice);
        }
        // 优选专区和商品的关系
        List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList = productParam.getPrefrenceAreaProductRelationList();
        for (CmsPrefrenceAreaProductRelation prefrenceAreaProductRelation : prefrenceAreaProductRelationList) {
            rows += prefrenceAreaProductRelationMapper.updateByPrimaryKeySelective(prefrenceAreaProductRelation);
        }
        // 商品参数及自定义规格属性
        List<PmsProductAttributeValue> productAttributeValueList = productParam.getProductAttributeValueList();
        for (PmsProductAttributeValue productAttributeValue : productAttributeValueList) {
            rows += productAttributeValueMapper.updateByPrimaryKeySelective(productAttributeValue);
        }
        // 商品满减价格设置
        List<PmsProductFullReduction> productFullReductionList = productParam.getProductFullReductionList();
        for (PmsProductFullReduction productFullReduction : productFullReductionList) {
            rows += productFullReductionMapper.updateByPrimaryKeySelective(productFullReduction);
        }
        // 商品阶梯价格设置
        List<PmsProductLadder> productLadderList = productParam.getProductLadderList();
        for (PmsProductLadder productLadder : productLadderList) {
            rows += productLadderMapper.updateByPrimaryKeySelective(productLadder);
        }
        // 商品的sku库存信息
        List<PmsSkuStock> skuStockList = productParam.getSkuStockList();
        for (PmsSkuStock skuStock : skuStockList) {
            rows += skuStockMapper.updateByPrimaryKeySelective(skuStock);
        }
        // 专题和商品关系
        List<CmsSubjectProductRelation> subjectProductRelationList = productParam.getSubjectProductRelationList();
        for (CmsSubjectProductRelation subjectProductRelation : subjectProductRelationList) {
            rows += subjectProductRelationMapper.updateByPrimaryKeySelective(subjectProductRelation);
        }
        rows += productMapper.updateByPrimaryKeySelective(productParam);
        return rows;
    }


    @Override
    public int updateDeleteStatus(Integer deleteStatus, Long[] ids) {
        int rows = 0;
        for (Long id : ids) {
            PmsProduct product = productMapper.selectByPrimaryKey(id);
            product.setDeleteStatus(deleteStatus);
            productMapper.updateByPrimaryKey(product);
            rows++;
        }
        return rows;
    }

    @Override
    public int updateNewStatus(Integer newStatus, Long[] ids) {
        int rows = 0;
        for (Long id : ids) {
            PmsProduct product = productMapper.selectByPrimaryKey(id);
            product.setNewStatus(newStatus);
            productMapper.updateByPrimaryKey(product);
            rows++;
        }
        return rows;
    }

    @Override
    public int updatePublishStatus(Integer publishStatus, Long[] ids) {
        int rows = 0;
        for (Long id : ids) {
            PmsProduct product = productMapper.selectByPrimaryKey(id);
            product.setPublishStatus(publishStatus);
            productMapper.updateByPrimaryKey(product);
            rows++;
        }
        return rows;
    }

    @Override
    public int updateRecommendStatus(Integer recommendStatus, Long[] ids) {
        int rows = 0;
        for (Long id : ids) {
            PmsProduct product = productMapper.selectByPrimaryKey(id);
            product.setRecommandStatus(recommendStatus);
            productMapper.updateByPrimaryKey(product);
            rows++;
        }
        return rows;
    }

    @Override
    public int updateVerifyStatus(Integer verifyStatus, Long[] ids) {
        int rows = 0;
        for (Long id : ids) {
            PmsProduct product = productMapper.selectByPrimaryKey(id);
            product.setVerifyStatus(verifyStatus);
            productMapper.updateByPrimaryKey(product);
            rows++;
        }
        return rows;
    }

    @Override
    public PmsProductResult getUpdateInfoById(Long id) {
        return productResultDao.getUpdateInfoById(id);
    }
}
