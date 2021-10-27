package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.SmsHomeRecommendSubject;

import java.util.List;

/**
 * @description : 首页专题推荐
 * @create time:14:05
 * @Author : XiaoZhen
 **/
public interface SmsHomeRecommendSubjectService {

    int createHomeRecommendSubject(SmsHomeRecommendSubject[] homeRecommendSubjectList);

    int deleteHomeRecommendSubject(Long[] ids);

    List<SmsHomeRecommendSubject> listHomeRecommendSubject(Integer pageNum, Integer pageSize, Integer recommendStatus,
                                                           String subjectName);

    int updateRecommendStatus(Long[] ids, Integer recommendStatus);

    int updateSort(Long id, Integer sort);
}
