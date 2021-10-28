package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.dto.UmsAdminLoginParam;
import com.xiaozhen.mall.tiny.dto.UpdatePasswordParam;
import com.xiaozhen.mall.tiny.mbg.model.UmsAdmin;
import com.xiaozhen.mall.tiny.mbg.model.UmsPermission;
import com.xiaozhen.mall.tiny.mbg.model.UmsRole;
import com.xiaozhen.mall.tiny.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description : 后台用户管理
 * @create time:17:35
 * @Author : XiaoZhen
 **/
@Api(tags = "UmsAdminController", description = "后台用户管理")
@Controller
@RequestMapping("/admin")
public class UmsAdminController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminController.class);
    @Autowired
    private UmsAdminService adminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation("获取指定用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<UmsAdmin> getById(@PathVariable("id") Long id) {
        return CommontResult.success(adminService.getById(id));
    }

    @ApiOperation("删除指定用户信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult deleteById(@PathVariable("id") Long id) {
        CommontResult commontResult;
        int count = adminService.deleteById(id);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("deleteById success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("deleteById failed:id={}", id);
        }
        return commontResult;
    }

    @ApiOperation("获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult getInfoByName(@RequestParam(name = "name")
                                 @ApiParam("name") String name) {
        return CommontResult.success(adminService.getInfoByName(name));
    }

    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<UmsAdmin>> list(@RequestParam(name = "keyword", defaultValue = "")
                                                    @ApiParam("keyword") String keyword,
                                                    @RequestParam(name = "pageNum", defaultValue = "1")
                                                    @ApiParam("页码") Integer pageNum,
                                                    @RequestParam(name = "pageSize", defaultValue = "5")
                                                    @ApiParam("每页数量") Integer pageSize) {
        List<UmsAdmin> adminList = adminService.list(keyword, pageNum, pageSize);
        return CommontResult.success(CommonPage.restPage(adminList));
    }

    @ApiOperation("登陆以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult login(@RequestBody
                               @ApiParam("umsAdminLoginParam") UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommontResult.vaildateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommontResult.success(token);
    }

    @ApiOperation("登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult logout() {
        return CommontResult.success(adminService.lougot());
    }

    @ApiOperation("刷新token")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult refreshToken(Map<String, String> tokenMap) {
        return CommontResult.success(adminService.refreshToken(tokenMap));
    }

    @ApiOperation("用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult<UmsAdmin> register(@RequestBody
                                            @ApiParam("umsAdminParm") UmsAdmin umsAdminParam, BindingResult result) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            return CommontResult.failed();
        }
        return CommontResult.success(umsAdmin);
    }

    @ApiOperation("获取指定用户的角色")
    @RequestMapping(value = "/role/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<UmsRole>> getRoleListById(@PathVariable("adminId")
                                                    @ApiParam("adminId") Long adminId) {
        return CommontResult.success(adminService.getRoleListById(adminId));
    }

    @ApiOperation("给用户分配角色")
    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateRole(@RequestParam(name = "adminId")
                                    @ApiParam("adminId") Long adminId,
                                    @RequestParam(name = "roleIds")
                                    @ApiParam("roleIds") Long... roleIds) {
        CommontResult commontResult;
        int count = adminService.updateRole(adminId, roleIds);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateRole success:adminId={}", adminId);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateRole failed:adminId={}", adminId);
        }
        return commontResult;
    }

    @ApiOperation("修改指定用户信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateById(@RequestBody
                                @ApiParam("admin") UmsAdmin admin,
                                @RequestParam(name = "id")
                                @ApiParam("id") Long id) {
        CommontResult commontResult;
        int count = adminService.updateById(id, admin);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateById success:{}", admin);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateById failed:{}", admin);
        }
        return commontResult;
    }

    @ApiOperation("修改指定用户信息")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updatePassword(@RequestBody
                                        @ApiParam("updatePasswordParam") UpdatePasswordParam passwordParam) {
        CommontResult commontResult;
        int count = adminService.updatePassword(passwordParam.getOldPassword(), passwordParam.getUsername(),
                passwordParam.getNewPassword());
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updatePassword success:{}", passwordParam);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updatePassword failed:{}", passwordParam);
        }
        return commontResult;
    }

    @ApiOperation("修改账号状态")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateStatusById(@RequestParam(name = "id")
                                      @ApiParam("id") Long id,
                                      @RequestParam(name = "status")
                                      @ApiParam("status") Integer status) {
        CommontResult commontResult;
        int count = adminService.updateStatusById(id, status);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateStatusById success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateStatusById failed:id={}", id);
        }
        return commontResult;
    }

    @ApiOperation("或偶去用户所有权限(包括+-权限)")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<UmsPermission>> getPermissionListById(@PathVariable("adminId")
                                                                @ApiParam("adminId") Long adminId) {
        List<UmsPermission> permissionList = adminService.getPermissionListById(adminId);
        return CommontResult.success(permissionList);
    }

}
