package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.PmsBrandParm;
import com.xiaozhen.mall.tiny.mbg.model.PmsBrand;

import java.util.List;

/**
 * @description: 商品品牌
 * @create time:13:26
 * @Author: XiaoZhen
 **/
public interface PmsBrandService {
    /**
     * @description: 获取指定id的商品品牌
     * @param: id   商品品牌id
     * @return: 商品品牌对象
     */
    PmsBrand getBrand(Long id);

    /**
     * @description: 创建新的商品品牌
     * @param: brand  新的商品品牌
     * @return: 影响行数
     */
    int createBrand(PmsBrandParm brandParm);

    /**
     * @description: 删除指定id的商品品牌
     * @param: id   商品品牌id
     * @return: 影响行数
     */
    int deleteBrand(Long id);

    int deleteBrandBatch(Long[] ids);

    /**
     * @description: 分页查询商品品牌
     * @param: pageNum  页码
     * @param: pageSize 每页数量
     * @return: 商品品牌对象列表
     */
    List<PmsBrand> listBrand(String keyword, Integer pageNum, Integer pageSize);

    /**
     * @description: 获取所有商品品牌
     * @return: 商品品牌对象列表
     */
    List<PmsBrand> listAllBrand();

    /**
     * @description: 更新指定id的商品品牌
     * @param: id   商品品牌id
     * @param: brand  新的商品品牌
     * @return: 影响行数
     */
    int updateBrand(Long id, PmsBrand brand);

    int updateFactoryStatus(Integer factoryStatus, Long[] ids);

    int updateShowStatus(Integer showStatus, Long[] ids);
}
