package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.mbg.model.SmsHomeAdvertise;
import com.xiaozhen.mall.tiny.service.SmsHomeAdvertiseService;
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
 * @description: 首页轮播广告管理
 * @create time:18:38
 * @Author: XiaoZhen
 **/
@Api(tags = "SmsHomeAdvertiseController", description = "首页轮播广告管理")
@Controller
@RequestMapping("/homeAdvertise")       // /home/advertise 路径不能设置
public class SmsHomeAdvertiseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsHomeAdvertiseController.class);
    @Autowired
    private SmsHomeAdvertiseService homeAdvertiseService;

    @ApiOperation("获取广告详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<SmsHomeAdvertise> getHomeAdvertise(@PathVariable("id")
                                                            @ApiParam("id") Long id) {
        return CommontResult.success(homeAdvertiseService.getHomeAdvertise(id));
    }

    @ApiOperation("添加广告")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult createHomeAdvertise(@RequestBody
                                             @ApiParam("advertise") SmsHomeAdvertise homeAdvertise) {
        CommontResult commontResult;
        int count = homeAdvertiseService.createHomeAdvertise(homeAdvertise);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("createHomeAdvertise success:{}", homeAdvertise);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("createHomeAdvertise failed:{}", homeAdvertise);
        }
        return commontResult;
    }

    @ApiOperation("删除广告")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult deleteHomeAdvertise(@RequestParam(name = "ids")
                                             @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = homeAdvertiseService.deleteHomeAdvertise(ids);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("deleteHomeAdvertise success:id={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("deleteHomeAdvertise failed:id={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("分页查询广告")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<SmsHomeAdvertise>> listHomeAdvertise(@RequestParam(name = "endTime",defaultValue = "")
                                                                         @ApiParam("endTime") String endTime,
                                                                         @RequestParam(name = "name",defaultValue = "")
                                                                         @ApiParam("name") String name,
                                                                         @RequestParam(name = "pageNum", defaultValue = "1")
                                                                         @ApiParam("页码") Integer pageNum,
                                                                         @RequestParam(name = "pageSize", defaultValue = "5")
                                                                         @ApiParam("每页数量") Integer pageSize) {
        List<SmsHomeAdvertise> homeList = homeAdvertiseService.listHomeAdvertise(endTime, name, pageNum, pageSize);
        return CommontResult.success(CommonPage.restPage(homeList));
    }

    @ApiOperation("修改广告")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateHomeAdvertise(@PathVariable("id")
                                             @ApiParam("id") Long id,
                                             @RequestBody
                                             @ApiParam("advertise") SmsHomeAdvertise homeAdvertise) {
        CommontResult commontResult;
        int count = homeAdvertiseService.updateHomeAdvertise(id, homeAdvertise);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateHomeAdvertise success:{}", homeAdvertise);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateHomeAdvertise failed:{}", homeAdvertise);
        }
        return commontResult;
    }

    @ApiOperation("修改上下线状态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateStatus(@PathVariable("id")
                                      @ApiParam("id") Long id,
                                      @RequestParam(name = "status")
                                      @ApiParam("status") Integer status) {
        CommontResult commontResult;
        int count = homeAdvertiseService.updateStatus(id, status);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateStatus success:{}", status);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateStatus failed:{}", status);
        }
        return commontResult;
    }

}
