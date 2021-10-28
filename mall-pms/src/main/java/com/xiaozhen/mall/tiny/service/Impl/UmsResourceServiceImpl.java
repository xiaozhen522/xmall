package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.mbg.mapper.UmsResourceMapper;
import com.xiaozhen.mall.tiny.mbg.model.UmsResource;
import com.xiaozhen.mall.tiny.mbg.model.UmsResourceExample;
import com.xiaozhen.mall.tiny.service.UmsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description : 后台资源UmsResourceService实现类
 * @create time:17:59
 * @Author : XiaoZhen
 **/
@Service
public class UmsResourceServiceImpl implements UmsResourceService {
    @Autowired
    private UmsResourceMapper resourceMapper;

    @Override
    public UmsResource getById(Long id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(UmsResource resource) {
        return resourceMapper.insertSelective(resource);
    }

    @Override
    public int deleteById(Long id) {
        return resourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UmsResource> list(Integer pageNum, Integer pageSize, Long categoryId, String nameKeyword, String urlKeyword) {
        UmsResourceExample example = new UmsResourceExample();
        UmsResourceExample.Criteria criteria = example.createCriteria();
        if (categoryId != null) {
            criteria.andCategoryIdEqualTo(categoryId);
        }
        if (nameKeyword != null) {
            criteria.andNameLike("%" + nameKeyword + "%");
        }
        if (urlKeyword != null) {
            criteria.andUrlLike("%" + urlKeyword + "%");
        }
        PageHelper.startPage(pageNum, pageSize);
        return resourceMapper.selectByExample(example);
    }

    @Override
    public List<UmsResource> listAll() {
        return resourceMapper.selectByExample(new UmsResourceExample());
    }

    @Override
    public int updateById(Long id, UmsResource resource) {
        resource.setId(id);
        return resourceMapper.updateByPrimaryKey(resource);
    }
}
