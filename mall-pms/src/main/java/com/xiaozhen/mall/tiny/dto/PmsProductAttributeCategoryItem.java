package com.xiaozhen.mall.tiny.dto;

import com.xiaozhen.mall.tiny.mbg.model.PmsProductAttribute;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductAttributeCategory;
import lombok.Data;

import java.util.List;

/**
 * @description :
 * @create time:2021/10/17
 * @Author : XiaoZhen
 **/
@Data
public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {
    private List<PmsProductAttribute> productAttributeList;
}
