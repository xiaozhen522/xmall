package com.xiaozhen.mall.tiny.dto;

import com.xiaozhen.mall.tiny.mbg.model.PmsProductCategory;

import java.util.List;

/**
 * @description:
 * @create time:2021/10/18
 * @Author: XiaoZhen
 **/
public class PmsProductCategoryWithChildernItem extends PmsProductCategory {
    private List<PmsProductCategory> children;

    public List<PmsProductCategory> getChildren() {
        return children;
    }

    public void setChildren(List<PmsProductCategory> children) {
        this.children = children;
    }
}
