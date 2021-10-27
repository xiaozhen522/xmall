package com.xiaozhen.mall.tiny.nosql.mongodb.repository;

import com.xiaozhen.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @description : 会员商品浏览历史记录Repository
 * @create time:2021/10/26
 * @Author : XiaoZhen
 **/
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory, String> {
    /**
     * 根据会员id按时间倒叙获取浏览记录
     *
     * @param memberId 会员id
     * @return
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}
