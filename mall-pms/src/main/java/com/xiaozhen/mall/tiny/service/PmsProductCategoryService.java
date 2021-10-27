package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.PmsProductCategoryWithChildernItem;
import com.xiaozhen.mall.tiny.dto.ProductCategoryParam;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductCategory;

import java.util.List;

/**
 * @description : 商品分类
 * @create time:9:08
 * @Author : XiaoZhen
 **/
public interface PmsProductCategoryService {
    /**
     * @description : 获取指定id的商品分类
     * @param: id   商品分类id
     * @return: 商品分类对象
     */
    PmsProductCategory getById(Long id);

    /**
     * @description : 创建新的商品分类
     * @param: productCategory  新的商品分类
     * @return: 影响行数
     */
    int create(ProductCategoryParam productCategoryParam);

    /**
     * @description : 删除指定id的商品分类
     * @param: id   商品分类id
     * @return: 影响行数
     */
    int deleteById(Long id);

    /**
     * @description : 分页查询商品分类
     * @param: pageNum  页码
     * @param: pageSize 每页数量
     * @return: 商品分类对象列表
     */
    List<PmsProductCategory> listByParentId(Integer pageNum, Integer pageSize, Long parentId);

    List<PmsProductCategoryWithChildernItem> listWithChildern();

    /**
     * @description : 更新指定id的商品分类
     * @param: id   商品分类id
     * @param: productCategory  新的商品分类
     * @return: 影响行数
     */
    int updateById(Long id, ProductCategoryParam productCategoryParam);

    int updateNavStatus(Integer navStatus, Long[] ids);

    int updateShowStatus(Integer showStatus, Long[] ids);
}
