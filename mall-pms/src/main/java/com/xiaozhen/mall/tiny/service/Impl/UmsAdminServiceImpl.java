package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.common.utils.JwtTokenUtil;
import com.xiaozhen.mall.tiny.dao.AdminRoleRealationDao;
import com.xiaozhen.mall.tiny.mbg.mapper.UmsAdminMapper;
import com.xiaozhen.mall.tiny.mbg.mapper.UmsAdminRoleRelationMapper;
import com.xiaozhen.mall.tiny.mbg.model.*;
import com.xiaozhen.mall.tiny.service.UmsAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description : 后台用户UmsAdminService实现类
 * @create time:17:35
 * @Author : XiaoZhen
 **/
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AdminRoleRealationDao adminRoleRelationDao;
    @Autowired
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;

    @Override
    public UmsAdmin get(Long id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int create(UmsAdmin admin) {
        return adminMapper.insertSelective(admin);
    }

    @Override
    public List<UmsAdmin> list(String keyword, Integer pageNum, Integer pageSize) {
        UmsAdminExample example = new UmsAdminExample();
        if (keyword != null) {
            example.createCriteria().andUsernameLike("%" + keyword + "%");
            UmsAdminExample.Criteria criteria = example.createCriteria().andNickNameLike("%" + keyword + "%");
            example.or(criteria);
        }
        PageHelper.startPage(pageNum, pageSize);
        return adminMapper.selectByExample(new UmsAdminExample());
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public int lougot() {
        return 1;
    }

    @Override
    public Map<String, String> refreshToken(Map<String, String> tokenMap) {
        String token = tokenMap.get("token");
        boolean canRefresh = jwtTokenUtil.canRefresh(token);
        if (!canRefresh) {
            token = jwtTokenUtil.refreshToken(token);
        }
        tokenMap.put("token", token);
        return tokenMap;
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        UmsAdmin admin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, admin);
        admin.setCreateTime(new Date());
        admin.setStatus(1);
        // 查询是否有相同的用户名
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(admin.getUsername());
        List<UmsAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList.size() > 0) {
            return null;
        }
        // 将密码进行加密操作
        String encodePassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodePassword);
        adminMapper.insert(admin);
        return admin;
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        return adminRoleRelationDao.getRoleList(adminId);
    }

    @Override
    public int updateRole(Long adminId, Long[] roleIds) {
        int rows = 0;
        for (Long roleId : roleIds) {
            UmsAdminRoleRelation adminRoleRelation = new UmsAdminRoleRelation();
            adminRoleRelation.setAdminId(adminId);
            adminRoleRelation.setRoleId(roleId);
            rows += adminRoleRelationMapper.insertSelective(adminRoleRelation);
        }
        return rows;
    }

    @Override
    public int update(Long id, UmsAdmin admin) {
        admin.setId(id);
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public int updatePassword(String oldPassword, String username, String newPassword) {
        UmsAdminExample example = new UmsAdminExample();
        UmsAdminExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(oldPassword);
        List<UmsAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList.size() == 1) {
            UmsAdmin admin = adminList.get(0);
            String encodePassword = passwordEncoder.encode(admin.getPassword());
            admin.setPassword(encodePassword);
            return adminMapper.updateByPrimaryKeySelective(admin);
        }
        return 0;
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        UmsAdmin admin = new UmsAdmin();
        admin.setId(id);
        admin.setStatus(status);
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return adminRoleRelationDao.getPermissionList(adminId);
    }
}
