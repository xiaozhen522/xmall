package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.mbg.model.SmsHomeRecommendProduct;
import com.xiaozhen.mall.tiny.service.SmsHomeRecommendProductService;
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
 * @description: 首页人气推荐管理
 * @create time:13:06
 * @Author: XiaoZhen
 **/
@Api(tags = "SmsHomeRecommendProductController", description = "首页人气推荐管理")
@Controller
@RequestMapping("/home/recommendProduct")
public class SmsHomeRecommendProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsHomeRecommendProductController.class);
    @Autowired
    private SmsHomeRecommendProductService homeRecommendProductService;

    @ApiOperation("添加首页推荐")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult createHomeRecommendProduct(@RequestBody
                                                    @ApiParam("homeRecommendProductList") SmsHomeRecommendProduct... homeRecommendProductList) {
        CommontResult commontResult;
        int count = homeRecommendProductService.createHomeRecommendProduct(homeRecommendProductList);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("createHomeRecommendProduct success:{}", homeRecommendProductList);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("createHomeRecommendProduct failed:{}", homeRecommendProductList);
        }
        return commontResult;
    }

    @ApiOperation("批量删除推荐")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult deleteHomeRecommendProduct(@RequestParam(name = "ids")
                                                    @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = homeRecommendProductService.deleteHomeRecommendProduct(ids);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("deleteHomeRecommendProduct success:id={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("deleteHomeRecommendProduct failed:id={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("分页查询推荐")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<SmsHomeRecommendProduct>> listHomeRecommendProduct(@RequestParam(name = "pageNum", defaultValue = "1")
                                                                                       @ApiParam("页码") Integer pageNum,
                                                                                       @RequestParam(name = "pageSize", defaultValue = "5")
                                                                                       @ApiParam("每页数量") Integer pageSize,
                                                                                       @RequestParam(name = "productName", defaultValue = "")
                                                                                       @ApiParam("productName") String productName,
                                                                                       @RequestParam(name = "recommendStatus", defaultValue = "")
                                                                                       @ApiParam("recommendStatus") Integer recommendStatus) {
        List<SmsHomeRecommendProduct> homeRecommendProductList =
                homeRecommendProductService.listHomeRecommendProduct(pageNum, pageSize, productName, recommendStatus);
        return CommontResult.success(CommonPage.restPage(homeRecommendProductList));
    }

    @ApiOperation("批量修改推荐状态")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateRecommendStatus(@RequestParam(name = "recommendStatus")
                                               @ApiParam("recommendStatus") Integer recommendStatus,
                                               @RequestParam(name = "ids")
                                               @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = homeRecommendProductService.updateRecommendStatus(ids, recommendStatus);
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
        int count = homeRecommendProductService.updateSort(id, sort);
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
