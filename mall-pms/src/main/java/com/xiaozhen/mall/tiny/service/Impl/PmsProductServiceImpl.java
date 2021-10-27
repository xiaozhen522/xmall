package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.common.utils.MyUtils;
import com.xiaozhen.mall.tiny.dto.PmsProductParam;
import com.xiaozhen.mall.tiny.dto.PmsProductResult;
import com.xiaozhen.mall.tiny.mbg.mapper.*;
import com.xiaozhen.mall.tiny.mbg.model.*;
import com.xiaozhen.mall.tiny.service.PmsProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
    private PmsProductCategoryMapper productCategoryMapper;

    @Override
    public int createProduct(PmsProductParam productParam) {
        // 商品会员价格设置
        List<PmsMemberPrice> memberPriceList = productParam.getMemberPriceList();
        for (PmsMemberPrice memberPrice : memberPriceList) {
            memberPriceMapper.insertSelective(memberPrice);
        }
        // 优选专区和商品的关系
        List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList = productParam.getPrefrenceAreaProductRelationList();
        for (CmsPrefrenceAreaProductRelation prefrenceAreaProductRelation : prefrenceAreaProductRelationList) {
            prefrenceAreaProductRelationMapper.insertSelective(prefrenceAreaProductRelation);
        }
        // 商品参数及自定义规格属性
        List<PmsProductAttributeValue> productAttributeValueList = productParam.getProductAttributeValueList();
        for (PmsProductAttributeValue productAttributeValue : productAttributeValueList) {
            productAttributeValueMapper.insertSelective(productAttributeValue);
        }
        // 商品满减价格设置
        List<PmsProductFullReduction> productFullReductionList = productParam.getProductFullReductionList();
        for (PmsProductFullReduction productFullReduction : productFullReductionList) {
            productFullReductionMapper.insertSelective(productFullReduction);
        }
        // 商品阶梯价格设置
        List<PmsProductLadder> productLadderList = productParam.getProductLadderList();
        for (PmsProductLadder productLadder : productLadderList) {
            productLadderMapper.insertSelective(productLadder);
        }
        // 商品的sku库存信息
        List<PmsSkuStock> skuStockList = productParam.getSkuStockList();
        for (PmsSkuStock skuStock : skuStockList) {
            skuStockMapper.insertSelective(skuStock);
        }
        // 专题和商品关系
        List<CmsSubjectProductRelation> subjectProductRelationList = productParam.getSubjectProductRelationList();
        for (CmsSubjectProductRelation subjectProductRelation : subjectProductRelationList) {
            subjectProductRelationMapper.insertSelective(subjectProductRelation);
        }
        return productMapper.insertSelective(productParam);
    }

    @Override
    public List<PmsProduct> listProduct(Long brandId, String keyword, Integer pageNum, Integer pageSize,
                                        Long productCategoryId, String productSn, Integer publishStatus,
                                        Integer verifyStatus) {
        PmsProductExample example = new PmsProductExample();
        PmsProductExample.Criteria criteria = example.createCriteria();
        if (brandId != null) {
            criteria.andBrandIdEqualTo(brandId);
        }
        if (keyword != null && !keyword.equals("")) {
            criteria.andKeywordsLike(keyword);
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
    public List<PmsProduct> simepleListProduct(String keyword) {
        return listProduct(null, keyword, 1, 5, null, null, null, null);
    }

    @Override
    public int updateProduct(Long id, PmsProductParam productParam) {
        productParam.setId(id);
        // 商品会员价格设置
        List<PmsMemberPrice> memberPriceList = productParam.getMemberPriceList();
        for (PmsMemberPrice memberPrice : memberPriceList) {
            memberPriceMapper.updateByPrimaryKey(memberPrice);
        }
        // 优选专区和商品的关系
        List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList = productParam.getPrefrenceAreaProductRelationList();
        for (CmsPrefrenceAreaProductRelation prefrenceAreaProductRelation : prefrenceAreaProductRelationList) {
            prefrenceAreaProductRelationMapper.updateByPrimaryKey(prefrenceAreaProductRelation);
        }
        // 商品参数及自定义规格属性
        List<PmsProductAttributeValue> productAttributeValueList = productParam.getProductAttributeValueList();
        for (PmsProductAttributeValue productAttributeValue : productAttributeValueList) {
            productAttributeValueMapper.updateByPrimaryKey(productAttributeValue);
        }
        // 商品满减价格设置
        List<PmsProductFullReduction> productFullReductionList = productParam.getProductFullReductionList();
        for (PmsProductFullReduction productFullReduction : productFullReductionList) {
            productFullReductionMapper.insertSelective(productFullReduction);
        }
        // 商品阶梯价格设置
        List<PmsProductLadder> productLadderList = productParam.getProductLadderList();
        for (PmsProductLadder productLadder : productLadderList) {
            productLadderMapper.updateByPrimaryKey(productLadder);
        }
        // 商品的sku库存信息
        List<PmsSkuStock> skuStockList = productParam.getSkuStockList();
        for (PmsSkuStock skuStock : skuStockList) {
            skuStockMapper.updateByPrimaryKey(skuStock);
        }
        // 专题和商品关系
        List<CmsSubjectProductRelation> subjectProductRelationList = productParam.getSubjectProductRelationList();
        for (CmsSubjectProductRelation subjectProductRelation : subjectProductRelationList) {
            subjectProductRelationMapper.updateByPrimaryKey(subjectProductRelation);
        }
        return productMapper.updateByPrimaryKey(productParam);
    }


    @Override
    public int updateProductDeleteStatus(Integer deleteStatus, Long[] ids) {
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
    public int updateProductNewStatus(Integer newStatus, Long[] ids) {
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
    public int updateProductPublishStatus(Integer publishStatus, Long[] ids) {
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
    public int updateProductRecommendStatus(Integer recommendStatus, Long[] ids) {
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
    public int updateProductVerifyStatus(Integer verifyStatus, Long[] ids) {
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
    public PmsProductResult updateInfo(Long id) {
        PmsProduct product = productMapper.selectByPrimaryKey(id);
        PmsProductResult productResult = new PmsProductResult();
        MyUtils.cast(product, productResult);
        // 商品会员价格设置
        PmsMemberPriceExample memberPriceExample = new PmsMemberPriceExample();
        memberPriceExample.createCriteria().andProductIdEqualTo(id);
        List<PmsMemberPrice> memberPriceList = memberPriceMapper.selectByExample(memberPriceExample);
        productResult.setMemberPriceList(memberPriceList);
        // 优选专区和商品的关系
        CmsPrefrenceAreaProductRelationExample prefrenceAreaProductRelationExample = new CmsPrefrenceAreaProductRelationExample();
        prefrenceAreaProductRelationExample.createCriteria().andProductIdEqualTo(id);
        List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList = prefrenceAreaProductRelationMapper.selectByExample(prefrenceAreaProductRelationExample);
        productResult.setPrefrenceAreaProductRelationList(prefrenceAreaProductRelationList);
        // 商品参数及自定义规格属性
        PmsProductAttributeValueExample productAttributeValueExample = new PmsProductAttributeValueExample();
        productAttributeValueExample.createCriteria().andProductIdEqualTo(id);
        List<PmsProductAttributeValue> productAttributeValueList = productAttributeValueMapper.selectByExample(productAttributeValueExample);
        productResult.setProductAttributeValueList(productAttributeValueList);
        // 商品满减价格设置
        PmsProductFullReductionExample productFullReductionExample = new PmsProductFullReductionExample();
        productFullReductionExample.createCriteria().andProductIdEqualTo(id);
        List<PmsProductFullReduction> productFullReductionList = productFullReductionMapper.selectByExample(productFullReductionExample);
        productResult.setProductFullReductionList(productFullReductionList);
        // 商品接替满减价格设置
        PmsProductLadderExample productLadderExample = new PmsProductLadderExample();
        productLadderExample.createCriteria().andProductIdEqualTo(id);
        List<PmsProductLadder> productLadderList = productLadderMapper.selectByExample(productLadderExample);
        productResult.setProductLadderList(productLadderList);
        // 商品sku库存信息
        PmsSkuStockExample skuStockExample = new PmsSkuStockExample();
        skuStockExample.createCriteria().andProductIdEqualTo(id);
        List<PmsSkuStock> skuStockList = skuStockMapper.selectByExample(skuStockExample);
        productResult.setSkuStockList(skuStockList);
        // 专题和商品关系
        CmsSubjectProductRelationExample subjectProductRelationExample = new CmsSubjectProductRelationExample();
        subjectProductRelationExample.createCriteria().andProductIdEqualTo(id);
        List<CmsSubjectProductRelation> subjectProductRelationList = subjectProductRelationMapper.selectByExample(subjectProductRelationExample);
        productResult.setSubjectProductRelationList(subjectProductRelationList);
        // cateParentId
        Long productCategoryId = productResult.getProductCategoryId();
        PmsProductCategory productCategory = productCategoryMapper.selectByPrimaryKey(productCategoryId);
        Long cateParentId = productCategory.getParentId();
        productResult.setCateParentId(cateParentId);
        return productResult;
    }
}
