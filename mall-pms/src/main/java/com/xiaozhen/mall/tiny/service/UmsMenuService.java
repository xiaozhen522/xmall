package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.UmsMenuNode;
import com.xiaozhen.mall.tiny.mbg.model.UmsMenu;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 后台菜单
 * @create time:16:33
 * @Author : XiaoZhen
 **/
public interface UmsMenuService {

    UmsMenu getById(Long id);

    @Transactional
    int create(UmsMenu menu);

    @Transactional
    int deleteById(Long id);

    List<UmsMenu> list(Integer pageNum, Integer pageSize, Long parentId);

    List<UmsMenuNode> treeList(Long id);

    @Transactional
    int updateById(Long id, UmsMenu menu);

    @Transactional
    int updateHiddenById(Long id, Integer hidden);
}
