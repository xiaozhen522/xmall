package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.dao.UmsMenuDao;
import com.xiaozhen.mall.tiny.dto.UmsMenuNode;
import com.xiaozhen.mall.tiny.mbg.mapper.UmsMenuMapper;
import com.xiaozhen.mall.tiny.mbg.model.UmsMenu;
import com.xiaozhen.mall.tiny.mbg.model.UmsMenuExample;
import com.xiaozhen.mall.tiny.service.UmsMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description : 后台菜单UmsMenuService实现类
 * @create time:16:33
 * @Author : XiaoZhen
 **/
@Service
public class UmsMenuServiceImpl implements UmsMenuService {
    @Autowired
    private UmsMenuMapper menuMapper;
    @Autowired
    private UmsMenuDao menuDao;

    @Override
    public UmsMenu get(Long id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(UmsMenu menu) {
        return menuMapper.insertSelective(menu);
    }

    @Override
    public int delete(Long id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UmsMenu> list(Integer pageNum, Integer pageSize, Long parentId) {
        UmsMenuExample example = new UmsMenuExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        PageHelper.startPage(pageNum, pageSize);
        return menuMapper.selectByExample(example);
    }

    @Override
    public List<UmsMenuNode> treeList(Long id) {
        return menuDao.treeList(id);
    }

    @Override
    public int update(Long id, UmsMenu menu) {
        menu.setId(id);
        return menuMapper.updateByPrimaryKey(menu);
    }

    @Override
    public int updateHidden(Long id, Integer hidden) {
        UmsMenu menu = new UmsMenu();
        menu.setId(id);
        menu.setHidden(hidden);
        return menuMapper.updateByPrimaryKeySelective(menu);
    }
}
