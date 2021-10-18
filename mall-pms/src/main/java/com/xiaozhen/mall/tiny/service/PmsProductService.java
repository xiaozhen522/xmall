package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.PmsProductParam;
import com.xiaozhen.mall.tiny.dto.PmsProductResult;
import com.xiaozhen.mall.tiny.mbg.model.PmsProduct;

import java.util.List;

/**
 * @description: 商品
 * @create time:11:26
 * @Author: XiaoZhen
 **/
public interface PmsProductService {
    /**
     * @description: 创建新的商品
     * @param: product  新的商品
     * @return: 影响行数
     */
    int createProduct(PmsProductParam productParam);

    /**
     * @description: 更新指定id的商品
     * @param: id   商品id
     * @param: product  新的商品
     * @return: 影响行数
     */
    int updateProduct(Long id, PmsProductParam productParam);


    List<PmsProduct> listProduct(Long brandId, String keyword, Integer pageNum, Integer pageSize,
                                 Long productCategoryId, String productSn, Integer publishStatus, Integer verifyStatus);

    List<PmsProduct> simepleListProduct(String keyword);

    int updateProductDeleteStatus(Integer deleteStatus, Long[] ids);

    int updateProductPublishStatus(Integer publishStatus, Long[] ids);

    int updateProductNewStatus(Integer newStatus, Long[] ids);

    int updateProductRecommendStatus(Integer recommendStatus, Long[] ids);

    int updateProductVerifyStatus(Integer verifyStatus, Long[] ids);

    PmsProductResult updateInfo(Long id) ;
}
