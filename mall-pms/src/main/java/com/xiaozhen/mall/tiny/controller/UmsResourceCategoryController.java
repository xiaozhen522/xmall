package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.mbg.model.UmsResourceCategory;
import com.xiaozhen.mall.tiny.service.UmsResourceCategoryService;
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
 * @description : 后台资源分类管理
 * @create time:17:46
 * @Author : XiaoZhen
 **/
@Api(tags = "UmsResourceCategoryController", description = "后台资源分类管理")
@Controller
@RequestMapping("/resourceCateGory")
public class UmsResourceCategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsResourceCategoryController.class);
    @Autowired
    private UmsResourceCategoryService resourceCateGoryService;

    @ApiOperation("添加后台资源分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult create(@RequestBody
                                @ApiParam("umsResourceCategory") UmsResourceCategory resourceCateGory) {
        CommontResult commontResult;
        int count = resourceCateGoryService.create(resourceCateGory);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("create success:{}", resourceCateGory);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("create failed:{}", resourceCateGory);
        }
        return commontResult;
    }

    @ApiOperation("根据id删除后台资源")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult delete(@PathVariable("id")
                                @ApiParam("id") Long id) {
        CommontResult commontResult;
        int count = resourceCateGoryService.delete(id);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("delete success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("delete failed:id={}", id);
        }
        return commontResult;
    }

    @ApiOperation("查询所有后台资源分类")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<UmsResourceCategory>> listAll() {
        return CommontResult.success(resourceCateGoryService.listAll());
    }

    @ApiOperation("修改后台资源分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult update(@PathVariable("id")
                                @ApiParam("id") Long id,
                                @RequestBody
                                @ApiParam("umsResourceCategory") UmsResourceCategory resourceCateGory) {
        CommontResult commontResult;
        int count = resourceCateGoryService.update(id, resourceCateGory);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("update success:{}", resourceCateGory);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("update failed:{}", resourceCateGory);
        }
        return commontResult;
    }

}
