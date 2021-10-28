package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.UmsResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 后台资源
 * @create time:17:59
 * @Author : XiaoZhen
 **/
public interface UmsResourceService {

    UmsResource getById(Long id);

    @Transactional
    int create(UmsResource resource);

    @Transactional
    int deleteById(Long id);

    List<UmsResource> list(Integer pageNum, Integer pageSize, Long categoryId, String nameKeyword, String urlKeyword);

    List<UmsResource> listAll();

    @Transactional
    int updateById(Long id, UmsResource resource);
}
