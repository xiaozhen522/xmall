package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.UmsResource;

import java.util.List;

/**
 * @description : 后台资源
 * @create time:17:59
 * @Author : XiaoZhen
 **/
public interface UmsResourceService {

    UmsResource get(Long id);

    int create(UmsResource resource);

    int delete(Long id);

    List<UmsResource> list(Integer pageNum, Integer pageSize, Long categoryId, String nameKeyword, String urlKeyword);

    List<UmsResource> listAll();

    int update(Long id, UmsResource resource);
}
