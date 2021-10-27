package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.UmsMenu;
import com.xiaozhen.mall.tiny.mbg.model.UmsResource;
import com.xiaozhen.mall.tiny.mbg.model.UmsRole;

import java.util.List;

/**
 * @description : 后台用户角色
 * @create time:18:20
 * @Author : XiaoZhen
 **/
public interface UmsRoleService {

    int allocMenu(Long roleId, Long[] menuIds);

    int allocResource(Long roleId, Long[] resourceIds);

    int create(UmsRole role);

    int delete(Long[] ids);

    List<UmsRole> list(Integer pageNum, Integer pageSize, String keyword);

    List<UmsRole> listAll();

    List<UmsMenu> listMenu(Long roleId);

    List<UmsResource> listResource(Long roleId);

    int update(Long id, UmsRole role);

    int updateStatus(Long id, Integer status);
}
