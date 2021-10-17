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
 * @description: 商品属性分类管理
 * @create time:16:17
 * @Author: XiaoZhen
 **/
@Api(tags = "PmsProductAttributeCategoryController", description = "商品属性分类管理")
@Controller
@RequestMapping("/productAttribute")
public class PmsProductAttributeCategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsProductAttributeCategoryController.class);
    @Autowired
    private PmsProductAttributeCategoryService productAttributeService;

    @ApiOperation("获取单个商品属性分类信息")
    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<PmsProductAttributeCategory> getProductAttributeCategory(@PathVariable("id")
                                                                                  @ApiParam("id") Long id) {
        return CommontResult.success(productAttributeService.getProductAttributeCategory(id));
    }

    @ApiOperation("添加商品属性分类")
    @RequestMapping(value = "/category/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult createProductAttributeCategory(@RequestParam(name = "name")
                                                        @ApiParam("name") String name) {
        CommontResult commontResult;
        int count = productAttributeService.createProductAttributeCategory(name);
        if (count == 1) {
            commontResult = CommontResult.success(name);
            LOGGER.debug("createProductAttributeCategory success:{}", name);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("createProductAttributeCategory failed:{}", name);
        }
        return commontResult;
    }

    @ApiOperation("删除单个商品属性分类")
    @RequestMapping(value = "/category/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult deleteProductAttributeCategory(@PathVariable("id")
                                                        @ApiParam("id") Long id) {
        CommontResult commontResult;
        int count = productAttributeService.deleteProductAttributeCategory(id);
        if (count == 1) {
            commontResult = CommontResult.success(id);
            LOGGER.debug("deleteProductAttributeCategory success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("deleteProductAttributeCategory failed:id={}", id);
        }
        return commontResult;
    }

    @ApiOperation("分页获取所有商品属性分类")
    @RequestMapping(value = "/category/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<PmsProductAttributeCategory>> listProductAttributeCategory(@RequestParam(name = "pageNum", defaultValue = "1")
                                                                                               @ApiParam("页码") Integer pageNum,
                                                                                               @RequestParam(name = "pageSize", defaultValue = "5")
                                                                                               @ApiParam("每页数量") Integer pageSize) {
        List<PmsProductAttributeCategory> productAttributeList = productAttributeService.listProductAttributeCategory(pageNum, pageSize);
        return CommontResult.success(CommonPage.restPage(productAttributeList));
    }

    @ApiOperation("获取所有商品属性分类及其下属下")
    @RequestMapping(value = "/category/listAll/withAttr", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<PmsProductAttributeCategoryItem>> listAllProductAttributeCategoryWithAttr() {
        return CommontResult.success(productAttributeService.listAllProductAttributeCategory());
    }

    @ApiOperation("修改商品属性分类")
    @RequestMapping(value = "/catagory/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateProductAttributeCategory(@PathVariable("id")
                                                        @ApiParam("id") Long id,
                                                        @RequestParam(name = "name")
                                                        @ApiParam("name") String name) {
        CommontResult commontResult;
        int count = productAttributeService.updateProductAttributeCategory(id, name);
        if (count == 1) {
            commontResult = CommontResult.success(name);
            LOGGER.debug("updateProductAttributeCategory success:{}", name);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateProductAttributeCategory failed:{}", name);
        }
        return commontResult;
    }
}
