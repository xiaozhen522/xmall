package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.mbg.mapper.SmsHomeRecommendSubjectMapper;
import com.xiaozhen.mall.tiny.mbg.model.SmsHomeRecommendSubject;
import com.xiaozhen.mall.tiny.mbg.model.SmsHomeRecommendSubjectExample;
import com.xiaozhen.mall.tiny.service.SmsHomeRecommendSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @description : 首页专题推荐SmsHomeRecommendSubjectService实现类
 * @create time:14:05
 * @Author : XiaoZhen
 **/
@Service
public class SmsHomeRecommendSubjectServiceImpl implements SmsHomeRecommendSubjectService {
    @Autowired
    private SmsHomeRecommendSubjectMapper homeRecommendSubjectMapper;

    @Override
    public int createHomeRecommendSubject(SmsHomeRecommendSubject[] homeRecommendSubjectList) {
        int rows = 0;
        for (SmsHomeRecommendSubject homeRecommendSubject : homeRecommendSubjectList) {
            rows += homeRecommendSubjectMapper.insertSelective(homeRecommendSubject);
        }
        return rows;
    }

    @Override
    public int deleteHomeRecommendSubject(Long[] ids) {
        SmsHomeRecommendSubjectExample example = new SmsHomeRecommendSubjectExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        return homeRecommendSubjectMapper.deleteByExample(example);
    }

    @Override
    public List<SmsHomeRecommendSubject> listHomeRecommendSubject(Integer pageNum, Integer pageSize, Integer recommendStatus,
                                                                  String subjectName) {
        SmsHomeRecommendSubjectExample example = new SmsHomeRecommendSubjectExample();
        SmsHomeRecommendSubjectExample.Criteria criteria = example.createCriteria();
        if (subjectName != null && !"".equals(subjectName)) {
            criteria.andSubjectNameLike("%" + subjectName + "%");
        }
        if (recommendStatus != null) {
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        PageHelper.startPage(pageNum, pageSize);
        return homeRecommendSubjectMapper.selectByExample(example);
    }

    @Override
    public int updateRecommendStatus(Long[] ids, Integer recommendStatus) {
        SmsHomeRecommendSubjectExample example = new SmsHomeRecommendSubjectExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        SmsHomeRecommendSubject homeRecommendSubject = new SmsHomeRecommendSubject();
        homeRecommendSubject.setRecommendStatus(recommendStatus);
        return homeRecommendSubjectMapper.updateByExampleSelective(homeRecommendSubject, example);
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeRecommendSubject homeRecommendSubject = new SmsHomeRecommendSubject();
        homeRecommendSubject.setId(id);
        homeRecommendSubject.setSort(sort);
        return homeRecommendSubjectMapper.updateByPrimaryKeySelective(homeRecommendSubject);
    }


}
