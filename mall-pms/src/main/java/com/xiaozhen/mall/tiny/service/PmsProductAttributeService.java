package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.ProductAttrInfo;
import com.xiaozhen.mall.tiny.dto.ProductAttributeParam;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductAttribute;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 商品属性
 * @create time:18:44
 * @Author : XiaoZhen
 **/
public interface PmsProductAttributeService {
    PmsProductAttribute getById(Long id);

    List<ProductAttrInfo> getAttrInfoByproductCategoryId(Long productCategoryId);

    @Transactional
    int create(ProductAttributeParam productAttributeParam);

    @Transactional
    int delete(Long[] ids);

    List<PmsProductAttribute> listByCidOrType(Long cid, Integer pageNum, Integer pageSize, Integer type);

    @Transactional
    int updateById(Long id, ProductAttributeParam productAttributeParam);

}
