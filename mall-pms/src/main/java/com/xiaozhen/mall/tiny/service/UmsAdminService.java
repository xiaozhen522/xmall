package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.UmsAdmin;
import com.xiaozhen.mall.tiny.mbg.model.UmsPermission;
import com.xiaozhen.mall.tiny.mbg.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @description : 后台用户
 * @create time:17:35
 * @Author : XiaoZhen
 **/
public interface UmsAdminService {

    UmsAdmin getById(Long id);

    @Transactional
    int deleteById(Long id);

    UmsAdmin getInfoByName(String username);

    @Transactional
    int create(UmsAdmin admin);

    List<UmsAdmin> list(String keyword, Integer pageNum, Integer pageSize);

    @Transactional
    String login(String username, String password);

    int lougot();

    Map<String, String> refreshToken(Map<String, String> tokenMap);

    @Transactional
    UmsAdmin register(UmsAdmin umsAdminParam);

    List<UmsRole> getRoleListById(Long adminId);

    @Transactional
    int updateRole(Long adminId, Long[] roleIds);

    @Transactional
    int updateById(Long id, UmsAdmin admin);

    @Transactional
    int updatePassword(String oldPassword, String username, String newPassword);

    @Transactional
    int updateStatusById(Long id, Integer status);

    List<UmsPermission> getPermissionListById(Long adminId);
}
