package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.dao.UmsRoleDao;
import com.xiaozhen.mall.tiny.mbg.mapper.UmsRoleMapper;
import com.xiaozhen.mall.tiny.mbg.mapper.UmsRoleMenuRelationMapper;
import com.xiaozhen.mall.tiny.mbg.mapper.UmsRoleResourceRelationMapper;
import com.xiaozhen.mall.tiny.mbg.model.*;
import com.xiaozhen.mall.tiny.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @description : 后台用户角色UmsRoleService实现类
 * @create time:18:20
 * @Author : XiaoZhen
 **/
@Service
public class UmsRoleServiceImpl implements UmsRoleService {
    @Autowired
    private UmsRoleMapper roleMapper;
    @Autowired
    private UmsRoleMenuRelationMapper roleMenuRelationMapper;
    @Autowired
    private UmsRoleResourceRelationMapper roleResourceRelationMapper;
    @Autowired
    private UmsRoleDao roleDao;

    @Override
    public int allocMenu(Long roleId, Long[] menuIds) {
        int rows = 0;
        for (Long menuId : menuIds) {
            UmsRoleMenuRelation roleMenuRelation = new UmsRoleMenuRelation();
            roleMenuRelation.setMenuId(menuId);
            roleMenuRelation.setRoleId(roleId);
            rows += roleMenuRelationMapper.insertSelective(roleMenuRelation);
        }
        return rows;
    }

    @Override
    public int allocResource(Long roleId, Long[] resourceIds) {
        int rows = 0;
        for (Long resourceId : resourceIds) {
            UmsRoleResourceRelation roleResourceRelation = new UmsRoleResourceRelation();
            roleResourceRelation.setResourceId(resourceId);
            roleResourceRelation.setRoleId(roleId);
            rows += roleResourceRelationMapper.insertSelective(roleResourceRelation);
        }
        return rows;
    }

    @Override
    public int create(UmsRole role) {
        return roleMapper.insertSelective(role);
    }

    @Override
    public int delete(Long[] ids) {
        UmsRoleExample example = new UmsRoleExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        return roleMapper.deleteByExample(example);
    }

    @Override
    public List<UmsRole> list(Integer pageNum, Integer pageSize, String keyword) {
        UmsRoleExample example = new UmsRoleExample();
        if (keyword != null) {
            example.createCriteria().andNameLike("%" + keyword + "%");
        }
        PageHelper.startPage(pageNum, pageSize);
        return roleMapper.selectByExample(example);
    }

    @Override
    public List<UmsRole> listAll() {
        return roleMapper.selectByExample(new UmsRoleExample());
    }

    @Override
    public List<UmsMenu> listMenu(Long roleId) {
        return roleDao.listMenu(roleId);
    }

    @Override
    public List<UmsResource> listResource(Long roleId) {
        return roleDao.listResource(roleId);
    }

    @Override
    public int update(Long id, UmsRole role) {
        role.setId(id);
        return roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        UmsRole role = new UmsRole();
        role.setStatus(status);
        role.setId(id);
        return roleMapper.updateByPrimaryKeySelective(role);
    }
}
