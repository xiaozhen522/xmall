package com.xiaozhen.mall.tiny.dao;

import com.xiaozhen.mall.tiny.mbg.model.UmsPermission;
import com.xiaozhen.mall.tiny.mbg.model.UmsRole;

import java.util.List;

/**
 * @description :
 * @create time:2021/10/25
 * @Author : XiaoZhen
 **/
public interface AdminRoleRealationDao {
    List<UmsPermission> getPermissionList(Long adminId);

    List<UmsRole> getRoleList(Long adminId);
}
