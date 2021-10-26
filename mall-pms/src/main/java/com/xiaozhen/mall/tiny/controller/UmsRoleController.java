package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.mbg.model.UmsMenu;
import com.xiaozhen.mall.tiny.mbg.model.UmsResource;
import com.xiaozhen.mall.tiny.mbg.model.UmsRole;
import com.xiaozhen.mall.tiny.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description : 后台用户角色管理
 * @create time:18:20
 * @Author : XiaoZhen
 **/
@Api(tags = "UmsRoleController", description = "后台用户角色管理")
@Controller
@RequestMapping("/role")
public class UmsRoleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsRoleController.class);
    @Autowired
    private UmsRoleService roleService;

    @ApiOperation("给角色分配菜单")
    @RequestMapping(value = "/allocMenu", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult allocMenu(@RequestParam(name = "roleId")
                                   @ApiParam("roleId") Long roleId,
                                   @RequestParam(name = "menuIds")
                                   @ApiParam("menuIds") Long... menuIds) {
        CommontResult commontResult;
        int count = roleService.allocMenu(roleId, menuIds);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("allocMenu success:id={}", roleId);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("allocMenu failed:id={}", roleId);
        }
        return commontResult;
    }

    @ApiOperation("给角色分配资源")
    @RequestMapping(value = "/allocResource", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult allocResource(@RequestParam(name = "roleId")
                                       @ApiParam("roleId") Long roleId,
                                       @RequestParam(name = "resourceIds")
                                       @ApiParam("resourceIds") Long... resourceIds) {
        CommontResult commontResult;
        int count = roleService.allocResource(roleId, resourceIds);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("allocResource success:id={}", roleId);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("allocResource failed:id={}", roleId);
        }
        return commontResult;
    }

    @ApiOperation("添加角色")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult create(@RequestBody
                                @ApiParam("role") UmsRole role) {
        CommontResult commontResult;
        int count = roleService.create(role);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("create success:{}", role);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("create failed:{}", role);
        }
        return commontResult;
    }

    @ApiOperation("批量删除角色")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult delete(@RequestParam(name = "ids")
                                @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = roleService.delete(ids);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("delete success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("delete failed:ids={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("根据角色名称分页获取角色列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<UmsRole>> list(@RequestParam(name = "pageNum", defaultValue = "1")
                                                   @ApiParam("页码") Integer pageNum,
                                                   @RequestParam(name = "pageSize", defaultValue = "5")
                                                   @ApiParam("每页数量") Integer pageSize,
                                                   @RequestParam(name = "keyword", defaultValue = "")
                                                   @ApiParam("keyword") String keyword) {
        List<UmsRole> roleList = roleService.list(pageNum, pageSize, keyword);
        return CommontResult.success(CommonPage.restPage(roleList));
    }

    @ApiOperation("获取所有角色")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<UmsRole>> listAll() {
        return CommontResult.success(roleService.listAll());
    }

    @ApiOperation("获取相关角色菜单")
    @RequestMapping(value = "/listMenu/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<UmsMenu>> listMenu(@PathVariable("roleId")
                                                 @ApiParam("roleId") Long roleId) {
        return CommontResult.success(roleService.listMenu(roleId));
    }

    @ApiOperation("获取相关角色菜单")
    @RequestMapping(value = "/listResource/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<UmsResource>> listResource(@PathVariable("roleId")
                                                         @ApiParam("roleId") Long roleId) {
        return CommontResult.success(roleService.listResource(roleId));
    }

    @ApiOperation("修改角色")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult update(@PathVariable("id")
                                @ApiParam("id") Long id,
                                @RequestBody
                                @ApiParam("role") UmsRole role) {
        CommontResult commontResult;
        int count = roleService.update(id, role);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("update success:{}", role);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("update failed:{}", role);
        }
        return commontResult;
    }

    @ApiOperation("修改角色状态")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateStatus(@PathVariable("id")
                                      @ApiParam("id") Long id,
                                      @RequestParam(name = "status")
                                      @ApiParam("status") Integer status) {
        CommontResult commontResult;
        int count = roleService.updateStatus(id, status);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateStatus success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateStatus failed:id={}", id);
        }
        return commontResult;
    }

}
