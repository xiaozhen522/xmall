package com.xiaozhen.mall.tiny.dao;

import com.xiaozhen.mall.tiny.mbg.model.UmsMenu;
import com.xiaozhen.mall.tiny.mbg.model.UmsResource;

import java.util.List;

/**
 * @description :
 * @create time:2021/10/26
 * @Author : XiaoZhen
 **/
public interface UmsRoleDao {
    List<UmsMenu> listMenu(Long roleId);

    List<UmsResource> listResource(Long roleId);

}
