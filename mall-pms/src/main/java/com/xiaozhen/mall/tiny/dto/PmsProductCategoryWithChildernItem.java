package com.xiaozhen.mall.tiny.dto;

import com.xiaozhen.mall.tiny.mbg.model.PmsProductCategory;
import lombok.Data;

import java.util.List;

/**
 * @description :
 * @create time:2021/10/18
 * @Author : XiaoZhen
 **/
@Data
public class PmsProductCategoryWithChildernItem extends PmsProductCategory {
    private List<PmsProductCategory> children;
}
