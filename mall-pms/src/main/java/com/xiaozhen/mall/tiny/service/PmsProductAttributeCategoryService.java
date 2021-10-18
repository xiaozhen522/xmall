package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.PmsProductAttributeCategoryItem;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductAttributeCategory;

import java.util.List;

/**
 * @description: 商品属性分类
 * @create time:16:17
 * @Author: XiaoZhen
 **/
public interface PmsProductAttributeCategoryService {
    /**
     * @description: 获取指定id的商品属性分类
     * @param: id   商品属性分类id
     * @return: 商品属性分类对象
     */
    PmsProductAttributeCategory getProductAttributeCategory(Long id);

    /**
     * @description: 创建新的商品属性分类
     * @param: productAttribute  新的商品属性分类
     * @return: 影响行数
     */
    int createProductAttributeCategory(String name);

    /**
     * @description: 删除指定id的商品属性分类
     * @param: id   商品属性分类id
     * @return: 影响行数
     */
    int deleteProductAttributeCategory(Long id);

    /**
     * @description: 分页查询商品属性分类
     * @param: pageNum  页码
     * @param: pageSize 每页数量
     * @return: 商品属性分类对象列表
     */
    List<PmsProductAttributeCategory> listProductAttributeCategory(Integer pageNum, Integer pageSize);

    /**
     * @description: 获取所有商品属性分类
     * @return: 商品属性分类对象列表
     */
    List<PmsProductAttributeCategoryItem> listAllProductAttributeCategory();

    /**
     * @description: 更新指定id的商品属性分类
     * @param: id   商品属性分类id
     * @param: productAttribute  新的商品属性分类
     * @return: 影响行数
     */
    int updateProductAttributeCategory(Long id, String name);
}
