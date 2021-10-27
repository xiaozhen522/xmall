package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.dto.PmsProductAttributeCategoryItem;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductAttributeCategory;
import com.xiaozhen.mall.tiny.service.PmsProductAttributeCategoryService;
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
 * @description : 商品属性分类管理
 * @create time:16:17
 * @Author : XiaoZhen
 **/
@Api(tags = "PmsProductAttributeCategoryController", description = "商品属性分类管理")
@Controller
@RequestMapping("/productAttribute/category")
public class PmsProductAttributeCategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsProductAttributeCategoryController.class);
    @Autowired
    private PmsProductAttributeCategoryService productAttributeService;

    @ApiOperation("获取单个商品属性分类信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<PmsProductAttributeCategory> getById(@PathVariable("id")
                                                              @ApiParam("id") Long id) {
        return CommontResult.success(productAttributeService.getById(id));
    }

    @ApiOperation("添加商品属性分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult create(@RequestParam("name")
                                @ApiParam("name") String name) {
        CommontResult commontResult;
        int count = productAttributeService.create(name);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("create success:{}", name);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("create failed:{}", name);
        }
        return commontResult;
    }

    @ApiOperation("删除单个商品属性分类")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult deleteById(@PathVariable("id")
                                    @ApiParam("id") Long id) {
        CommontResult commontResult;
        int count = productAttributeService.deleteById(id);
        if (count == 1) {
            commontResult = CommontResult.success(id);
            LOGGER.debug("deleteById success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("deleteById failed:id={}", id);
        }
        return commontResult;
    }

    @ApiOperation("分页获取所有商品属性分类")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<PmsProductAttributeCategory>> list(@RequestParam(name = "pageNum", defaultValue =
            "1")
                                                                       @ApiParam("页码") Integer pageNum,
                                                                       @RequestParam(name = "pageSize", defaultValue = "5")
                                                                       @ApiParam("每页数量") Integer pageSize) {
        List<PmsProductAttributeCategory> productAttributeList = productAttributeService.list(pageNum, pageSize);
        return CommontResult.success(CommonPage.restPage(productAttributeList));
    }

    @ApiOperation("获取所有商品属性分类及其下属下")
    @RequestMapping(value = "/listAll/withAttr", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<PmsProductAttributeCategoryItem>> listAllWithAttr() {
        return CommontResult.success(productAttributeService.listAllWithAttr());
    }

    @ApiOperation("修改商品属性分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateById(@PathVariable("id")
                                    @ApiParam("id") Long id,
                                    @RequestParam("name")
                                    @ApiParam("name") String name) {
        CommontResult commontResult;
        int count = productAttributeService.updateById(id, name);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateById success:{}", name);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateById failed:{}", name);
        }
        return commontResult;
    }
}
