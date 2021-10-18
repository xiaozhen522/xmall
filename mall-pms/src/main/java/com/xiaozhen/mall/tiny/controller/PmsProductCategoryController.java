package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.dto.PmsProductCategoryWithChildernItem;
import com.xiaozhen.mall.tiny.dto.ProductCategoryParam;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductCategory;
import com.xiaozhen.mall.tiny.service.PmsProductCategoryService;
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
 * @description: 商品分类管理
 * @create time:9:08
 * @Author: XiaoZhen
 **/
@Api(tags = "PmsProductCategoryController", description = "商品分类管理")
@Controller
@RequestMapping("/productCategory")
public class PmsProductCategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsProductCategoryController.class);
    @Autowired
    private PmsProductCategoryService productCategoryService;

    @ApiOperation("根据id获取商品分类")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<PmsProductCategory> getProductCategory(@PathVariable("id")
                                                                @ApiParam("id") Long id) {
        return CommontResult.success(productCategoryService.getProductCategory(id));
    }

    @ApiOperation("添加产品分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult createProductCategoryParam(@RequestBody
                                                    @ApiParam("productCategoryParam") ProductCategoryParam productCategoryParam) {
        CommontResult commontResult;
        int count = productCategoryService.createProductCategory(productCategoryParam);
        if (count == 1) {
            commontResult = CommontResult.success(productCategoryParam);
            LOGGER.debug("createProductCategoryParam success:{}", productCategoryParam);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("createProductCategoryParam failed:{}", productCategoryParam);
        }
        return commontResult;
    }


    @ApiOperation("删除商品分类")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult deleteProductCategory(@PathVariable("id")
                                               @ApiParam("id") Long id) {
        CommontResult commontResult;
        int count = productCategoryService.deleteProductCategory(id);
        if (count == 1) {
            commontResult = CommontResult.success(id);
            LOGGER.debug("deleteProductCategory success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("deleteProductCategory failed:id={}", id);
        }
        return commontResult;
    }

    @ApiOperation("分页查询商品分类")
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<PmsProductCategory>> listProductCategory(@RequestParam(name = "pageNum", defaultValue = "1")
                                                                             @ApiParam("页码") Integer pageNum,
                                                                             @RequestParam(name = "pageSize", defaultValue = "5")
                                                                             @ApiParam("每页数量") Integer pageSize,
                                                                             @PathVariable("parentId")
                                                                             @ApiParam("parentId") Long parentId) {
        List<PmsProductCategory> productCategoryList = productCategoryService.listProductCategory(pageNum, pageSize, parentId);
        return CommontResult.success(CommonPage.restPage(productCategoryList));
    }

    @ApiOperation("查询所有一级分类及子分类")
    @RequestMapping(value = "/list/withChildren", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<PmsProductCategoryWithChildernItem>> listAllProductCategoryWithChildernItem() {
        return CommontResult.success(productCategoryService.listAllProductCategoryWithChildernItem());
    }

    @ApiOperation("修改商品分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateProductCategory(@PathVariable("id")
                                               @ApiParam("id") Long id,
                                               @RequestBody
                                               @ApiParam("productCategoryParam") ProductCategoryParam productCategoryParam) {
        CommontResult commontResult;
        int count = productCategoryService.updateProductCategory(id, productCategoryParam);
        if (count == 1) {
            commontResult = CommontResult.success(productCategoryParam);
            LOGGER.debug("updateProductCategory success:{}", productCategoryParam);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateProductCategory failed:{}", productCategoryParam);
        }
        return commontResult;
    }

    @ApiOperation("修改导航栏显示状态")
    @RequestMapping(value = "/update/navStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateNavStatus(@RequestParam(name = "navStatus", defaultValue = "0")
                                         @ApiParam("navStatus") Integer navStatus,
                                         @RequestParam(name = "ids")
                                         @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = productCategoryService.updateNavStatus(navStatus, ids);
        if (count > 0) {
            commontResult = CommontResult.success(ids);
            LOGGER.debug("updateNavStatus success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateNavStatus failed:ids={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("修改显示状态")
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateShowStatus(@RequestParam(name = "showStatus", defaultValue = "0")
                                          @ApiParam("showStatus") Integer showStatus,
                                          @RequestParam(name = "ids")
                                          @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = productCategoryService.updateShowStatus(showStatus, ids);
        if (count > 0) {
            commontResult = CommontResult.success(ids);
            LOGGER.debug("updateShowStatus success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateShowStatus failed:ids={}", ids);
        }
        return commontResult;
    }
}
