package com.xiaozhen.mall.tiny.dto;

/**
 * @description:
 * @create time:2021/10/17
 * @Author: XiaoZhen
 **/
public class ProductAttrInfo {
    private Long attributeCategoryId;
    private Long attributeId;

    public Long getAttributeCategoryId() {
        return attributeCategoryId;
    }

    public void setAttributeCategoryId(Long attributeCategoryId) {
        this.attributeCategoryId = attributeCategoryId;
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }
}
