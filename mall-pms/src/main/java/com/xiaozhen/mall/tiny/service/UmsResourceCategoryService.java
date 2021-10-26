package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.UmsResourceCategory;

import java.util.List;

/**
 * @description : 后台资源分类
 * @create time:17:46
 * @Author : XiaoZhen
 **/
public interface UmsResourceCategoryService {

    int create(UmsResourceCategory resourceCateGory);

    int delete(Long id);

    int update(Long id, UmsResourceCategory resourceCateGory);

    List<UmsResourceCategory> listAll();

}
