package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.mbg.mapper.SmsFlashPromotionMapper;
import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotion;
import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotionExample;
import com.xiaozhen.mall.tiny.service.SmsFlashPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 显示购活动SmsFlashPromotionService实现类
 * @create time:18:02
 * @Author: XiaoZhen
 **/
@Service
public class SmsFlashPromotionServiceImpl implements SmsFlashPromotionService {
    @Autowired
    private SmsFlashPromotionMapper flashPromotionMapper;

    @Override
    public SmsFlashPromotion getFlashPromotion(Long id) {
        return flashPromotionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int createFlashPromotion(SmsFlashPromotion flashPromotion) {
        return flashPromotionMapper.insertSelective(flashPromotion);
    }

    @Override
    public int deleteFlashPromotion(Long id) {
        return flashPromotionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SmsFlashPromotion> listFlashPromotion(String keyword, Integer pageNum, Integer pageSize) {
        SmsFlashPromotionExample example = new SmsFlashPromotionExample();
        if (keyword != null) {
            example.createCriteria().andTitleLike("%" + keyword + "%");
        }
        PageHelper.startPage(pageNum, pageSize);
        return flashPromotionMapper.selectByExample(example);
    }

    @Override
    public int updateFlashPromotion(Long id, SmsFlashPromotion flashPromotion) {
        flashPromotion.setId(id);
        return flashPromotionMapper.updateByPrimaryKey(flashPromotion);
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        SmsFlashPromotion flashPromotion = new SmsFlashPromotion();
        flashPromotion.setId(id);
        flashPromotion.setStatus(status);
        return flashPromotionMapper.updateByPrimaryKeySelective(flashPromotion);
    }
}
