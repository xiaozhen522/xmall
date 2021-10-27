package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.CmsSubject;

import java.util.List;

/**
 * @description : 商品专题
 * @create time:21:44
 * @Author : XiaoZhen
 **/
public interface CmsSubjectService {
    /**
     * 根据关键字分页查询商品专题
     *
     * @param keyword  关键字
     * @param pageNum  页码
     * @param pageSize 每页数量
     * @return List
     */
    List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 获取所有商品专题列表
     *
     * @return List
     */
    List<CmsSubject> listAll();
}
