package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.UmsAdmin;
import com.xiaozhen.mall.tiny.mbg.model.UmsPermission;
import com.xiaozhen.mall.tiny.mbg.model.UmsRole;

import java.util.List;
import java.util.Map;

/**
 * @description : 后台用户
 * @create time:17:35
 * @Author : XiaoZhen
 **/
public interface UmsAdminService {

    UmsAdmin get(Long id);

    int delete(Long id);

    UmsAdmin getAdminByUsername(String username);

    int create(UmsAdmin admin);

    List<UmsAdmin> list(String keyword, Integer pageNum, Integer pageSize);

    String login(String username, String password);

    int lougot();

    Map<String, String> refreshToken(Map<String, String> tokenMap);

    UmsAdmin register(UmsAdmin umsAdminParam);

    List<UmsRole> getRoleList(Long adminId);

    int updateRole(Long adminId, Long[] roleIds);

    int update(Long id, UmsAdmin admin);

    int updatePassword(String oldPassword, String username, String newPassword);

    int updateStatus(Long id, Integer status);

    List<UmsPermission> getPermissionList(Long adminId);
}
