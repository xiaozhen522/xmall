package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.mbg.model.UmsResource;
import com.xiaozhen.mall.tiny.service.UmsResourceService;
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
 * @description : 后台资源管理
 * @create time:17:59
 * @Author : XiaoZhen
 **/
@Api(tags = "UmsResourceController", description = "后台资源管理")
@Controller
@RequestMapping("/resource")
public class UmsResourceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsResourceController.class);
    @Autowired
    private UmsResourceService resourceService;

    @ApiOperation("根据id获取资源详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<UmsResource> get(@PathVariable("id")
                                          @ApiParam("id") Long id) {
        return CommontResult.success(resourceService.get(id));
    }

    @ApiOperation("添加后台资源")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult create(@RequestBody
                                @ApiParam("umsResource") UmsResource resource) {
        CommontResult commontResult;
        int count = resourceService.create(resource);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("create success:{}", resource);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("create failed:{}", resource);
        }
        return commontResult;
    }

    @ApiOperation("根据id删除后台资源")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult delete(@PathVariable("id")
                                @ApiParam("id") Long id) {
        CommontResult commontResult;
        int count = resourceService.delete(id);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("delete success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("delete failed:id={}", id);
        }
        return commontResult;
    }

    @ApiOperation("分页模糊查询后台资源")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<UmsResource>> list(@RequestParam(name = "pageNum", defaultValue = "1")
                                                       @ApiParam("页码") Integer pageNum,
                                                       @RequestParam(name = "pageSize", defaultValue = "5")
                                                       @ApiParam("每页数量") Integer pageSize,
                                                       @RequestParam(name = "categoryId", defaultValue = "")
                                                       @ApiParam("categoryId") Long categoryId,
                                                       @RequestParam(name = "nameKeyword", defaultValue = "")
                                                       @ApiParam("nameKeyword") String nameKeyword,
                                                       @RequestParam(name = "urlKeyword", defaultValue = "")
                                                       @ApiParam("urlKeyword") String urlKeyword) {
        List<UmsResource> resourceList = resourceService.list(pageNum, pageSize, categoryId, nameKeyword, urlKeyword);
        return CommontResult.success(CommonPage.restPage(resourceList));
    }

    @ApiOperation("查询所有后台资源")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<UmsResource>> listAll() {
        return CommontResult.success(resourceService.listAll());
    }

    @ApiOperation("修改后台资源")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult update(@PathVariable("id")
                                @ApiParam("id") Long id,
                                @RequestBody
                                @ApiParam("umsResource") UmsResource resource) {
        CommontResult commontResult;
        int count = resourceService.update(id, resource);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("update success:{}", resource);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("update failed:{}", resource);
        }
        return commontResult;
    }
}
