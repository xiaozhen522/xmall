package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.ProductAttrInfo;
import com.xiaozhen.mall.tiny.dto.ProductAttributeParam;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductAttribute;

import java.util.List;

/**
 * @description: 商品属性
 * @create time:18:44
 * @Author: XiaoZhen
 **/
public interface PmsProductAttributeService {
    /**
     * @description: 获取指定id的商品属性
     * @param: id   商品属性id
     * @return: 商品属性对象
     */
    PmsProductAttribute getProductAttribute(Long id);

    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);

    /**
     * @description: 创建新的商品属性
     * @param: productAttribute  新的商品属性
     * @return: 影响行数
     */
    int createProductAttribute(ProductAttributeParam productAttributeParam);


    int deleteProductAttributeList(Long[] ids);

    /**
     * @description: 分页查询商品属性
     * @param: pageNum  页码
     * @param: pageSize 每页数量
     * @return: 商品属性对象列表
     */
    List<PmsProductAttribute> listProductAttribute(Long cid, Integer pageNum, Integer pageSize, Integer type);

    /**
     * @description: 更新指定id的商品属性
     * @param: id   商品属性id
     * @param: productAttribute  新的商品属性
     * @return: 影响行数
     */
    int updateProductAttribute(Long id, ProductAttributeParam productAttributeParam);

}
