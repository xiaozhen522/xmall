package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.PmsProductParam;
import com.xiaozhen.mall.tiny.dto.PmsProductResult;
import com.xiaozhen.mall.tiny.mbg.model.PmsProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 商品
 * @create time:11:26
 * @Author : XiaoZhen
 **/
public interface PmsProductService {
    @Transactional
    int create(PmsProductParam productParam);

    @Transactional
    int updateById(Long id, PmsProductParam productParam);

    List<PmsProduct> list(Long brandId, String keyword, Integer pageNum, Integer pageSize, Long productCategoryId,
                          String productSn, Integer publishStatus, Integer verifyStatus);

    List<PmsProduct> simpleList(String keyword);

    @Transactional
    int updateDeleteStatus(Integer deleteStatus, Long[] ids);

    @Transactional
    int updatePublishStatus(Integer publishStatus, Long[] ids);

    @Transactional
    int updateNewStatus(Integer newStatus, Long[] ids);

    @Transactional
    int updateRecommendStatus(Integer recommendStatus, Long[] ids);

    @Transactional
    int updateVerifyStatus(Integer verifyStatus, Long[] ids);

    PmsProductResult getUpdateInfoById(Long id);
}
