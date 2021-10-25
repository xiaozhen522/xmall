package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.mbg.model.SmsHomeNewProduct;
import com.xiaozhen.mall.tiny.service.SmsHomeNewProductService;
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
 * @description: 首页新品管理
 * @create time:11:35
 * @Author: XiaoZhen
 **/
@Api(tags = "SmsHomeNewProductController", description = "首页新品管理")
@Controller
@RequestMapping("/home/newProduct")
public class SmsHomeNewProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsHomeNewProductController.class);
    @Autowired
    private SmsHomeNewProductService homeNewProductService;

    @ApiOperation("添加首页推荐商品")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult createHomeNewProduct(@RequestBody
                                              @ApiParam("homeProductList") SmsHomeNewProduct... homeNewProductList) {
        CommontResult commontResult;
        int count = homeNewProductService.createHomeNewProduct(homeNewProductList);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("createHomeNewProduct success:{}", homeNewProductList);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("createHomeNewProduct failed:{}", homeNewProductList);
        }
        return commontResult;
    }

    @ApiOperation("批量删除推荐")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult deleteHomeNewProduct(@RequestParam(name = "ids")
                                              @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = homeNewProductService.deleteHomeNewProduct(ids);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("deleteHomeNewProduct success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("deleteHomeNewProduct failed:ids={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("分页查询推荐")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<SmsHomeNewProduct>> listHomeNewProduct(@RequestParam(name = "pageNum", defaultValue = "1")
                                                                           @ApiParam("页码") Integer pageNum,
                                                                           @RequestParam(name = "pageSize", defaultValue = "5")
                                                                           @ApiParam("每页数量") Integer pageSize,
                                                                           @RequestParam(name = "productName", defaultValue = "")
                                                                           @ApiParam("productName") String productName,
                                                                           @RequestParam(name = "recommendStatus", defaultValue = "")
                                                                           @ApiParam("recommendStatus") Integer recommendStatus) {

        List<SmsHomeNewProduct> homeNewProductList = homeNewProductService.listHomeNewProduct(pageNum, pageSize,
                productName, recommendStatus);
        return CommontResult.success(CommonPage.restPage(homeNewProductList));
    }

    @ApiOperation("批量修改推荐状态")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateRecommendStatus(@RequestParam(name = "recommendStatus")
                                               @ApiParam("recommendStatus") Integer recommendStatus,
                                               @RequestParam(name = "ids")
                                               @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = homeNewProductService.updateRecommendStatus(ids, recommendStatus);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateRecommendStatus success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateRecommendStatus failed:ids={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("修改推荐排序")
    @RequestMapping(value = "/update/sort/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateSort(@PathVariable("id")
                                    @ApiParam("id") Long id,
                                    @RequestParam(name = "sort")
                                    @ApiParam("port") Integer sort) {
        CommontResult commontResult;
        int count = homeNewProductService.updateSort(id, sort);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateSort success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateSort failed:id={}", id);
        }
        return commontResult;
    }
}
