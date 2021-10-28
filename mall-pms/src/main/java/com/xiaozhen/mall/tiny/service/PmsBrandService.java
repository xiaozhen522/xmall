package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.PmsBrandParm;
import com.xiaozhen.mall.tiny.mbg.model.PmsBrand;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 商品品牌
 * @create time:13:26
 * @Author : XiaoZhen
 **/
public interface PmsBrandService {
    PmsBrand getById(Long id);

    @Transactional
    int create(PmsBrandParm brandParm);

    @Transactional
    int deleteById(Long id);

    @Transactional
    int deleteBatch(Long[] ids);

    List<PmsBrand> list(String keyword, Integer pageNum, Integer pageSize);

    List<PmsBrand> listAll();

    @Transactional
    int updateById(Long id, PmsBrand brand);

    @Transactional
    int updateFactoryStatus(Integer factoryStatus, Long[] ids);

    @Transactional
    int updateShowStatus(Integer showStatus, Long[] ids);
}
