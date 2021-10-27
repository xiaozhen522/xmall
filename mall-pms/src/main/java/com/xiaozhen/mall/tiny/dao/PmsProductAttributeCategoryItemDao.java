package com.xiaozhen.mall.tiny.dao;

import com.xiaozhen.mall.tiny.dto.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * @description :
 * @create time:2021/10/27 19:09
 * @Author : XiaoZhen
 **/
public interface PmsProductAttributeCategoryItemDao {

    List<PmsProductAttributeCategoryItem> listAllWithAttr();
}
