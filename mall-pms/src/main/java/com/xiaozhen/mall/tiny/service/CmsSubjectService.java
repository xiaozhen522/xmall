package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.CmsSubject;

import java.util.List;

/**
 * @description: 商品专题
 * @create time:21:44
 * @Author: XiaoZhen
 **/
public interface CmsSubjectService {

    /**
     * @description: 分页查询商品专题
     * @param: pageNum  页码
     * @param: pageSize 每页数量
     * @return: 商品专题对象列表
     */
    List<CmsSubject> listSubject(String keyword, Integer pageNum, Integer pageSize);

    /**
     * @description: 获取所有商品专题
     * @return: 商品专题对象列表
     */
    List<CmsSubject> listAllSubject();
}
