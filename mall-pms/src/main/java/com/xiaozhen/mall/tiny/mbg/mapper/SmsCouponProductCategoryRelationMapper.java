package com.xiaozhen.mall.tiny.mbg.mapper;

import com.xiaozhen.mall.tiny.mbg.model.SmsCouponProductCategoryRelation;
import com.xiaozhen.mall.tiny.mbg.model.SmsCouponProductCategoryRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsCouponProductCategoryRelationMapper {
    long countByExample(SmsCouponProductCategoryRelationExample example);

    int deleteByExample(SmsCouponProductCategoryRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsCouponProductCategoryRelation record);

    int insertSelective(SmsCouponProductCategoryRelation record);

    List<SmsCouponProductCategoryRelation> selectByExample(SmsCouponProductCategoryRelationExample example);

    SmsCouponProductCategoryRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsCouponProductCategoryRelation record, @Param("example") SmsCouponProductCategoryRelationExample example);

    int updateByExample(@Param("record") SmsCouponProductCategoryRelation record, @Param("example") SmsCouponProductCategoryRelationExample example);

    int updateByPrimaryKeySelective(SmsCouponProductCategoryRelation record);

    int updateByPrimaryKey(SmsCouponProductCategoryRelation record);
}