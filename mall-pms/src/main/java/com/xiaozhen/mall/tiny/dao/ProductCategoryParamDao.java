package com.xiaozhen.mall.tiny.dao;

import com.xiaozhen.mall.tiny.dto.PmsProductCategoryWithChildernItem;
import com.xiaozhen.mall.tiny.dto.ProductCategoryParam;

import java.util.List;

/**
 * @description :
 * @create time:2021/10/27 20:01
 * @Author : XiaoZhen
 **/
public interface ProductCategoryParamDao {

    List<PmsProductCategoryWithChildernItem> listWithChildren(Long id);
}
