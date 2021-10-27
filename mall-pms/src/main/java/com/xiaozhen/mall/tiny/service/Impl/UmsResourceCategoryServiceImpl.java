package com.xiaozhen.mall.tiny.service.Impl;

import com.xiaozhen.mall.tiny.mbg.mapper.UmsResourceCategoryMapper;
import com.xiaozhen.mall.tiny.mbg.model.UmsResourceCategory;
import com.xiaozhen.mall.tiny.mbg.model.UmsResourceCategoryExample;
import com.xiaozhen.mall.tiny.service.UmsResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description : 后台资源分类UmsResourceCategoryService实现类
 * @create time:17:46
 * @Author : XiaoZhen
 **/
@Service
public class UmsResourceCategoryServiceImpl implements UmsResourceCategoryService {
    @Autowired
    private UmsResourceCategoryMapper resourceCateGoryMapper;

    @Override
    public int create(UmsResourceCategory resourceCateGory) {
        return resourceCateGoryMapper.insertSelective(resourceCateGory);
    }

    @Override
    public int delete(Long id) {
        return resourceCateGoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UmsResourceCategory> listAll() {
        return resourceCateGoryMapper.selectByExample(new UmsResourceCategoryExample());
    }

    @Override
    public int update(Long id, UmsResourceCategory resourceCateGory) {
        resourceCateGory.setId(id);
        return resourceCateGoryMapper.updateByPrimaryKey(resourceCateGory);
    }

}
