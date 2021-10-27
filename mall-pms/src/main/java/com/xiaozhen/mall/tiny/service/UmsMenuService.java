package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.UmsMenuNode;
import com.xiaozhen.mall.tiny.mbg.model.UmsMenu;

import java.util.List;

/**
 * @description : 后台菜单
 * @create time:16:33
 * @Author : XiaoZhen
 **/
public interface UmsMenuService {

    UmsMenu get(Long id);

    int create(UmsMenu menu);

    int delete(Long id);

    List<UmsMenu> list(Integer pageNum, Integer pageSize, Long parentId);

    List<UmsMenuNode> treeList(Long id);

    int update(Long id, UmsMenu menu);

    int updateHidden(Long id, Integer hidden);
}
