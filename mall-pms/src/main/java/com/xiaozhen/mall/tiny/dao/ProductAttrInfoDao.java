package com.xiaozhen.mall.tiny.dao;

import com.xiaozhen.mall.tiny.dto.ProductAttrInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description : 自定义查询
 * @create time:2021/10/17
 * @Author : XiaoZhen
 **/
public interface ProductAttrInfoDao {

    List<ProductAttrInfo> getAttrInfoByproductCategoryId(@Param("productCategoryId") Long productCategoryId);
}
