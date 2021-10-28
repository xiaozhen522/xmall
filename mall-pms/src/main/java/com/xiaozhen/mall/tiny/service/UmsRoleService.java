package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.UmsMenu;
import com.xiaozhen.mall.tiny.mbg.model.UmsResource;
import com.xiaozhen.mall.tiny.mbg.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 后台用户角色
 * @create time:18:20
 * @Author : XiaoZhen
 **/
public interface UmsRoleService {
    @Transactional
    int allocMenu(Long roleId, Long[] menuIds);

    @Transactional
    int allocResource(Long roleId, Long[] resourceIds);

    @Transactional
    int create(UmsRole role);

    @Transactional
    int delete(Long[] ids);

    List<UmsRole> list(Integer pageNum, Integer pageSize, String keyword);

    List<UmsRole> listAll();

    List<UmsMenu> listMenuById(Long roleId);

    List<UmsResource> listResourceById(Long roleId);

    @Transactional
    int updateById(Long id, UmsRole role);

    @Transactional
    int updateStatusById(Long id, Integer status);
}
