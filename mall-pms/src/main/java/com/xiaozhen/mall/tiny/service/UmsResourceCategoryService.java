package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.UmsResourceCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 后台资源分类
 * @create time:17:46
 * @Author : XiaoZhen
 **/
public interface UmsResourceCategoryService {
    @Transactional
    int create(UmsResourceCategory resourceCateGory);
    @Transactional
    int deleteById(Long id);
    @Transactional
    int updateById(Long id, UmsResourceCategory resourceCateGory);

    List<UmsResourceCategory> listAll();

}
