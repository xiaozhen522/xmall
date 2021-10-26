package com.xiaozhen.mall.tiny.dao;

import com.xiaozhen.mall.tiny.dto.UmsMenuNode;

import java.util.List;

/**
 * @description :
 * @create time:2021/10/26
 * @Author : XiaoZhen
 **/
public interface UmsMenuDao {
    List<UmsMenuNode> treeList(Long id);
}
