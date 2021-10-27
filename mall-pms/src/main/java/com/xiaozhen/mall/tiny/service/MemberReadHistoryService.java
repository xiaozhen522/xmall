package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * @description : 会员浏览记录管理Service
 * @create time:2021/10/26
 * @Author : XiaoZhen
 **/
public interface MemberReadHistoryService {
    /**
     * 创建浏览记录
     *
     * @param memberReadHistory 浏览记录对象
     * @return 影响行数
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     *
     * @param ids 浏览记录id集合
     * @return 删除条数
     */
    int delete(List<String> ids);

    /**
     * 获取指定用户的浏览记录
     *
     * @param memberId 用户id
     * @return List
     */
    List<MemberReadHistory> list(Long memberId);
}
