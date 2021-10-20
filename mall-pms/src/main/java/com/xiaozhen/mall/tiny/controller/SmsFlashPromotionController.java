package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotion;
import com.xiaozhen.mall.tiny.service.SmsFlashPromotionService;
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
 * @description: 显示购活动管理
 * @create time:18:02
 * @Author: XiaoZhen
 **/
@Api(tags = "SmsFlashPromotionController", description = "限时购活动管理")
@Controller
@RequestMapping("/flash")
public class SmsFlashPromotionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsFlashPromotionController.class);
    @Autowired
    private SmsFlashPromotionService flashService;

    @ApiOperation("获取活动详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<SmsFlashPromotion> getFlashPromotion(@PathVariable("id")
                                                              @ApiParam("id") Long id) {
        return CommontResult.success(flashService.getFlashPromotion(id));
    }

    @ApiOperation("添加活动")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult createFlashPromotion(@RequestBody
                                              @ApiParam("flashPromotion") SmsFlashPromotion flashPromotion) {
        CommontResult commontResult;
        int count = flashService.createFlashPromotion(flashPromotion);
        if (count == 1) {
            commontResult = CommontResult.success(flashPromotion);
            LOGGER.debug("createFlashPromotion success:{}", flashPromotion);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("createFlashPromotion failed:{}", flashPromotion);
        }
        return commontResult;
    }

    @ApiOperation("删除活动信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult deleteFlashPromotion(@PathVariable("id")
                                              @ApiParam("id") Long id) {
        CommontResult commontResult;
        int count = flashService.deleteFlashPromotion(id);
        if (count == 1) {
            commontResult = CommontResult.success(id);
            LOGGER.debug("deleteFlashPromotion success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("deleteFlashPromotion failed:id={}", id);
        }
        return commontResult;
    }

    @ApiOperation("根据活动名称分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<SmsFlashPromotion>> listFlashPromotion(@RequestParam(name = "keyword", defaultValue = "")
                                                                           @ApiParam("keyword") String keyword,
                                                                           @RequestParam(name = "pageNum", defaultValue = "1")
                                                                           @ApiParam("页码") Integer pageNum,
                                                                           @RequestParam(name = "pageSize", defaultValue = "5")
                                                                           @ApiParam("每页数量") Integer pageSize) {
        List<SmsFlashPromotion> flashList = flashService.listFlashPromotion(keyword, pageNum, pageSize);
        return CommontResult.success(CommonPage.restPage(flashList));
    }

    @ApiOperation("更新活动信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateFlashPromotion(@PathVariable("id")
                                              @ApiParam("id") Long id,
                                              @RequestBody
                                              @ApiParam("flashPromotion") SmsFlashPromotion flashPromotion) {
        CommontResult commontResult;
        int count = flashService.updateFlashPromotion(id, flashPromotion);
        if (count == 1) {
            commontResult = CommontResult.success(flashPromotion);
            LOGGER.debug("updateFlashPromotion success:{}", flashPromotion);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateFlashPromotion failed:{}", flashPromotion);
        }
        return commontResult;
    }

    @ApiOperation("修改上下线状态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateStatus(@PathVariable("id")
                                      @ApiParam("id") Long id,
                                      @RequestParam(name = "status", defaultValue = "")
                                      @ApiParam("status") Integer status) {
        CommontResult commontResult;
        int count = flashService.updateStatus(id, status);
        if (count == 1) {
            commontResult = CommontResult.success(id);
            LOGGER.debug("updateStatus success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateStatus failed:id={}", id);
        }
        return commontResult;
    }

}
