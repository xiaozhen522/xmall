package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.PmsProductCategoryWithChildernItem;
import com.xiaozhen.mall.tiny.dto.ProductCategoryParam;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 商品分类
 * @create time:9:08
 * @Author : XiaoZhen
 **/
public interface PmsProductCategoryService {
    PmsProductCategory getById(Long id);

    @Transactional
    int create(ProductCategoryParam productCategoryParam);

    @Transactional
    int deleteById(Long id);

    List<PmsProductCategory> listByParentId(Integer pageNum, Integer pageSize, Long parentId);

    List<PmsProductCategoryWithChildernItem> listWithChildren(Long id);

    @Transactional
    int updateById(Long id, ProductCategoryParam productCategoryParam);

    @Transactional
    int updateNavStatus(Integer navStatus, Long[] ids);

    @Transactional
    int updateShowStatus(Integer showStatus, Long[] ids);
}
