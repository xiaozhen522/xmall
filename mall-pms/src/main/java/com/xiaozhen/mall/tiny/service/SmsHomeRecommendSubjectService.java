package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.SmsHomeRecommendSubject;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 首页专题推荐
 * @create time:14:05
 * @Author : XiaoZhen
 **/
public interface SmsHomeRecommendSubjectService {
    @Transactional
    int create(SmsHomeRecommendSubject[] homeRecommendSubjectList);

    @Transactional
    int delete(Long[] ids);

    List<SmsHomeRecommendSubject> list(Integer pageNum, Integer pageSize, Integer recommendStatus,
                                       String subjectName);

    @Transactional
    int updateRecommendStatus(Long[] ids, Integer recommendStatus);

    @Transactional
    int updateSortById(Long id, Integer sort);
}
