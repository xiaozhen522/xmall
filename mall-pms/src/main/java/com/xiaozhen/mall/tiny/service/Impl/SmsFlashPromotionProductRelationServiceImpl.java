package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.xiaozhen.mall.tiny.common.utils.MyUtils;
import com.xiaozhen.mall.tiny.dto.SmsFlashPromotionProduct;
import com.xiaozhen.mall.tiny.mbg.mapper.PmsProductMapper;
import com.xiaozhen.mall.tiny.mbg.mapper.SmsFlashPromotionProductRelationMapper;
import com.xiaozhen.mall.tiny.mbg.model.PmsProduct;
import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotionProductRelation;
import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotionProductRelationExample;
import com.xiaozhen.mall.tiny.service.SmsFlashPromotionProductRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 限时购和商品关系SmsFlashPromotionProductRelationService实现类
 * @create time:18:25
 * @Author: XiaoZhen
 **/
@Service
public class SmsFlashPromotionProductRelationServiceImpl implements SmsFlashPromotionProductRelationService {
    @Autowired
    private SmsFlashPromotionProductRelationMapper fpprMapper;
    @Autowired
    private PmsProductMapper productMapper;

    @Override
    public SmsFlashPromotionProductRelation getFlashPromotionProductRelation(Long id) {
        return fpprMapper.selectByPrimaryKey(id);
    }

    @Override
    public int createFlashPromotionProductRelation(SmsFlashPromotionProductRelation[] fpprList) {
        int rows = 0;
        for (SmsFlashPromotionProductRelation fppr : fpprList) {
            rows += fpprMapper.insertSelective(fppr);
        }
        return rows;
    }

    @Override
    public int deleteFlashPromotionProductRelation(Long id) {
        return fpprMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SmsFlashPromotionProduct> listFlashPromotionProduct(Long flashPromotionId, Long flashPromotionSessionId, Integer pageNum, Integer pageSize) {

        SmsFlashPromotionProductRelationExample example = new SmsFlashPromotionProductRelationExample();
        SmsFlashPromotionProductRelationExample.Criteria criteria = example.createCriteria();
        if (flashPromotionId != null) {
            criteria.andFlashPromotionIdEqualTo(flashPromotionId);
        }
        if (flashPromotionSessionId != null) {
            criteria.andFlashPromotionSessionIdEqualTo(flashPromotionSessionId);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<SmsFlashPromotionProductRelation> fpprList = fpprMapper.selectByExample(example);
        List<SmsFlashPromotionProduct> fppList = new ArrayList<>();
        for (SmsFlashPromotionProductRelation fppr : fpprList) {
            // 获取商品信息
            PmsProduct product = productMapper.selectByPrimaryKey(fppr.getProductId());
            SmsFlashPromotionProduct fpp = new SmsFlashPromotionProduct();
            MyUtils.cast(fppr, fpp);
            fpp.setProduct(product);
            fppList.add(fpp);
        }
        return fppList;
    }

    @Override
    public int updateFlashPromotionProductRelation(Long id, SmsFlashPromotionProductRelation flashProductRelation) {
        flashProductRelation.setId(id);
        return fpprMapper.updateByPrimaryKey(flashProductRelation);
    }
}
