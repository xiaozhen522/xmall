package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * @description : 会员浏览记录管理Service
 * @create time:2021/10/26
 * @Author : XiaoZhen
 **/
public interface MemberReadHistoryService {
    int create(MemberReadHistory memberReadHistory);

    int delete(List<String> ids);

    List<MemberReadHistory> list(Long memberId);
}
