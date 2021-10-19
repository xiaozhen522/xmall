package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.mbg.mapper.CmsSubjectMapper;
import com.xiaozhen.mall.tiny.mbg.model.CmsSubject;
import com.xiaozhen.mall.tiny.mbg.model.CmsSubjectExample;
import com.xiaozhen.mall.tiny.service.CmsSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 商品专题CmsSubjectService实现类
 * @create time:21:44
 * @Author: XiaoZhen
 **/
@Service
public class CmsSubjectServiceImpl implements CmsSubjectService {
    @Autowired
    private CmsSubjectMapper subjectMapper;

    @Override
    public List<CmsSubject> listSubject(String keyword, Integer pageNum, Integer pageSize) {
        CmsSubjectExample example = new CmsSubjectExample();
        example.createCriteria().andCategoryNameLike("%" + keyword + "%");
        PageHelper.startPage(pageNum, pageSize);
        return subjectMapper.selectByExample(example);
    }

    @Override
    public List<CmsSubject> listAllSubject() {
        return subjectMapper.selectByExample(new CmsSubjectExample());
    }
}
