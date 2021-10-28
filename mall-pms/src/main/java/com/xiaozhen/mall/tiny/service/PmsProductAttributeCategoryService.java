package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.PmsProductAttributeCategoryItem;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductAttributeCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 商品属性分类
 * @create time:16:17
 * @Author : XiaoZhen
 **/
public interface PmsProductAttributeCategoryService {

    PmsProductAttributeCategory getById(Long id);

    @Transactional
    int create(String name);

    @Transactional
    int deleteById(Long id);

    List<PmsProductAttributeCategory> list(Integer pageNum, Integer pageSize);

    List<PmsProductAttributeCategoryItem> listAllWithAttr();

    @Transactional
    int updateById(Long id, String name);
}
