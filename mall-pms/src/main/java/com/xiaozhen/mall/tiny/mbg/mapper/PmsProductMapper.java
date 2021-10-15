package com.xiaozhen.mall.tiny.mbg.mapper;

import com.xiaozhen.mall.tiny.mbg.model.PmsProduct;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbggenerated
     */
    int countByExample(PmsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbggenerated
     */
    int deleteByExample(PmsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbggenerated
     */
    int insert(PmsProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbggenerated
     */
    int insertSelective(PmsProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbggenerated
     */
    List<PmsProduct> selectByExampleWithBLOBs(PmsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbggenerated
     */
    List<PmsProduct> selectByExample(PmsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbggenerated
     */
    PmsProduct selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PmsProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(PmsProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PmsProduct record);
}