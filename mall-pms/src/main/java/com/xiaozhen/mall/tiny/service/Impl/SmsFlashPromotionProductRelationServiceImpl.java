package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.dao.SmsFlashPromotionProductDao;
import com.xiaozhen.mall.tiny.dto.SmsFlashPromotionProduct;
import com.xiaozhen.mall.tiny.mbg.mapper.SmsFlashPromotionProductRelationMapper;
import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotionProductRelation;
import com.xiaozhen.mall.tiny.service.SmsFlashPromotionProductRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description : 限时购和商品关系SmsFlashPromotionProductRelationService实现类
 * @create time:18:25
 * @Author : XiaoZhen
 **/
@Service
public class SmsFlashPromotionProductRelationServiceImpl implements SmsFlashPromotionProductRelationService {
    @Autowired
    private SmsFlashPromotionProductRelationMapper fpprMapper;
    @Autowired
    private SmsFlashPromotionProductDao flashPromotionProductDao;

    @Override
    public SmsFlashPromotionProductRelation getById(Long id) {
        return fpprMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(SmsFlashPromotionProductRelation[] fpprList) {
        int rows = 0;
        for (SmsFlashPromotionProductRelation fppr : fpprList) {
            rows += fpprMapper.insertSelective(fppr);
        }
        return rows;
    }

    @Override
    public int deleteById(Long id) {
        return fpprMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SmsFlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return flashPromotionProductDao.list(flashPromotionId, flashPromotionSessionId);
    }

    @Override
    public int updateById(Long id, SmsFlashPromotionProductRelation flashProductRelation) {
        flashProductRelation.setId(id);
        return fpprMapper.updateByPrimaryKey(flashProductRelation);
    }
}
