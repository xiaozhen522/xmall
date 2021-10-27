package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.PmsProductAttributeCategoryItem;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductAttributeCategory;

import java.util.List;

/**
 * @description : 商品属性分类
 * @create time:16:17
 * @Author : XiaoZhen
 **/
public interface PmsProductAttributeCategoryService {

    PmsProductAttributeCategory getById(Long id);

    int create(String name);

    int deleteById(Long id);

    List<PmsProductAttributeCategory> list(Integer pageNum, Integer pageSize);

    List<PmsProductAttributeCategoryItem> listAllWithAttr();

    int updateById(Long id, String name);
}
