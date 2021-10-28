package com.xiaozhen.mall.tiny.dto;

import com.xiaozhen.mall.tiny.mbg.model.*;
import lombok.Data;

import java.util.List;

/**
 * @description : 提交商品参数表单
 * @create time:2021/10/16
 * @Author : XiaoZhen
 **/
@Data
public class PmsProductParam extends PmsProduct {
    private List<PmsMemberPrice> memberPriceList;
    private List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList;
    private List<PmsProductAttributeValue> productAttributeValueList;
    private List<PmsProductFullReduction> productFullReductionList;
    private List<PmsProductLadder> productLadderList;
    private List<PmsSkuStock> skuStockList;
    private List<CmsSubjectProductRelation> subjectProductRelationList;
}
