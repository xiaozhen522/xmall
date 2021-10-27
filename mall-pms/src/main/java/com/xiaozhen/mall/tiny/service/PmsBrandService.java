package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.PmsBrandParm;
import com.xiaozhen.mall.tiny.mbg.model.PmsBrand;

import java.util.List;

/**
 * @description : 商品品牌
 * @create time:13:26
 * @Author : XiaoZhen
 **/
public interface PmsBrandService {
    PmsBrand getById(Long id);

    int create(PmsBrandParm brandParm);

    int deleteById(Long id);

    int deleteBatch(Long[] ids);

    List<PmsBrand> list(String keyword, Integer pageNum, Integer pageSize);

    List<PmsBrand> listAll();

    int updateById(Long id, PmsBrand brand);

    int updateFactoryStatus(Integer factoryStatus, Long[] ids);

    int updateShowStatus(Integer showStatus, Long[] ids);
}
