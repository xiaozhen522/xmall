package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.SmsHomeBrand;

import java.util.List;

/**
 * @description : 首页品牌
 * @create time:19:33
 * @Author : XiaoZhen
 **/
public interface SmsHomeBrandService {
    /**
     * @description : 创建新的首页品牌
     * @param: homeBrand  新的首页品牌
     * @return: 影响行数
     */
    int createHomeBrands(SmsHomeBrand[] homeBrandList);

    /**
     * @description : 删除指定id的首页品牌
     * @param: id   首页品牌id
     * @return: 影响行数
     */
    int deleteHomeBrands(Long[] ids);

    /**
     * @description : 分页查询首页品牌
     * @param: pageNum  页码
     * @param: pageSize 每页数量
     * @return: 首页品牌对象列表
     */
    List<SmsHomeBrand> listHomeBrand(String brandName, Integer pageNum, Integer pageSize);

    /**
     * @description : 更新指定id的首页品牌
     * @param: id   首页品牌id
     * @param: homeBrand  新的首页品牌
     * @return: 影响行数
     */
    int updateStatus(Long[] ids, Integer recommendStatus);

    int updateSort(Long id, Integer sort);

}
