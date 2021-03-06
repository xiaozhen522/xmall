package com.xiaozhen.mall.tiny.service.Impl;

import com.xiaozhen.mall.tiny.dao.SmsFlashPromotionSessionDeatilDao;
import com.xiaozhen.mall.tiny.dto.SmsFlashPromotionSessionDeatil;
import com.xiaozhen.mall.tiny.mbg.mapper.SmsFlashPromotionSessionMapper;
import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotionSession;
import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotionSessionExample;
import com.xiaozhen.mall.tiny.service.SmsFlashPromotionSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description : 显示场次管理SmsFlashPromotionSessionService实现类
 * @create time:22:33
 * @Author : XiaoZhen
 **/
@Service
public class SmsFlashPromotionSessionServiceImpl implements SmsFlashPromotionSessionService {
    @Autowired
    private SmsFlashPromotionSessionMapper flashSessionMapper;
    @Autowired
    private SmsFlashPromotionSessionDeatilDao flashPromotionSessionDeatilDao;

    @Override
    public SmsFlashPromotionSession getById(Long id) {
        return flashSessionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(SmsFlashPromotionSession flashSession) {
        return flashSessionMapper.insertSelective(flashSession);
    }

    @Override
    public int deleteById(Long id) {
        return flashSessionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SmsFlashPromotionSession> list() {
        return flashSessionMapper.selectByExample(new SmsFlashPromotionSessionExample());
    }

    @Override
    public List<SmsFlashPromotionSessionDeatil> selectList(Long flashPromotionId) {
        return flashPromotionSessionDeatilDao.listFlashPromotionSessionDetail(flashPromotionId);
    }

    @Override
    public int updateById(Long id, SmsFlashPromotionSession flashSession) {
        flashSession.setId(id);
        return flashSessionMapper.updateByPrimaryKey(flashSession);
    }

    @Override
    public int updateStatusById(Long id, Integer status) {
        SmsFlashPromotionSession flashPromotionSession = new SmsFlashPromotionSession();
        flashPromotionSession.setId(id);
        flashPromotionSession.setStatus(status);
        return flashSessionMapper.updateByPrimaryKeySelective(flashPromotionSession);
    }
}
