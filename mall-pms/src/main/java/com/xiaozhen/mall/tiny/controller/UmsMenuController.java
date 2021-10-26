package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.dto.UmsMenuNode;
import com.xiaozhen.mall.tiny.mbg.model.UmsMenu;
import com.xiaozhen.mall.tiny.service.UmsMenuService;
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
 * @description : 后台菜单管理
 * @create time:16:33
 * @Author : XiaoZhen
 **/
@Api(tags = "UmsMenuController", description = "后台菜单管理")
@Controller
@RequestMapping("/menu")
public class UmsMenuController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsMenuController.class);
    @Autowired
    private UmsMenuService menuService;

    @ApiOperation("根据id获取菜单详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<UmsMenu> get(@PathVariable("id")
                                      @ApiParam("id") Long id) {
        return CommontResult.success(menuService.get(id));
    }

    @ApiOperation("添加后台菜单")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult create(@RequestBody
                                @ApiParam("umsMenu") UmsMenu menu) {
        CommontResult commontResult;
        int count = menuService.create(menu);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("create success:{}", menu);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("create failed:{}", menu);
        }
        return commontResult;
    }

    @ApiOperation("根据id删除后台菜单")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult delete(@PathVariable("id")
                                @ApiParam("id") Long id) {
        CommontResult commontResult;
        int count = menuService.delete(id);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("delete success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("delete failed:id={}", id);
        }
        return commontResult;
    }

    @ApiOperation("分页查询后台菜单")
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<UmsMenu>> list(@RequestParam(name = "pageNum", defaultValue = "1")
                                                   @ApiParam("页码") Integer pageNum,
                                                   @RequestParam(name = "pageSize", defaultValue = "5")
                                                   @ApiParam("每页数量") Integer pageSize,
                                                   @PathVariable("parentId")
                                                   @ApiParam("parentId") Long parentId) {
        List<UmsMenu> menuList = menuService.list(pageNum, pageSize, parentId);
        return CommontResult.success(CommonPage.restPage(menuList));
    }

    @ApiOperation("树形结构返回所有菜单列表")
    @RequestMapping(value = "/treeList", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<UmsMenuNode>> treeList(@RequestParam(name = "id", defaultValue = "0")
                                                     @ApiParam("id") Long id) {
        return CommontResult.success(menuService.treeList(id));
    }

    @ApiOperation("修改后台菜单")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult update(@PathVariable("id")
                                @ApiParam("id") Long id,
                                @RequestBody
                                @ApiParam("umsMenu") UmsMenu menu) {
        CommontResult commontResult;
        int count = menuService.update(id, menu);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("update success:{}", menu);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("update failed:{}", menu);
        }
        return commontResult;
    }

    @ApiOperation("修改菜单显示状态")
    @RequestMapping(value = "/updateHidden/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateHidden(@PathVariable("id")
                                      @ApiParam("id") Long id,
                                      @RequestParam(name = "hidden")
                                      @ApiParam("hidden") Integer hidden) {
        CommontResult commontResult;
        int count = menuService.updateHidden(id, hidden);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateHidden success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateHidden failed:id={}", id);
        }
        return commontResult;
    }
}
