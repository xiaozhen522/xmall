package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrderSetting;
import com.xiaozhen.mall.tiny.service.OmsOrderSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @description : 订单设置管理
 * @create time:19:42
 * @Author : XiaoZhen
 **/
@Api(tags = "OmsOrderSettingController", description = "订单设置管理")
@Controller
@RequestMapping("/orderSetting")
public class OmsOrderSettingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OmsOrderSettingController.class);
    @Autowired
    private OmsOrderSettingService orderSettingService;

    @ApiOperation("获取指定订单设置")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<OmsOrderSetting> get(@PathVariable("id")
                                              @ApiParam("id") Long id) {
        return CommontResult.success(orderSettingService.get(id));
    }

    @ApiOperation("修改指定订单设置")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult update(@PathVariable("id")
                                @ApiParam("id") Long id,
                                @RequestBody
                                @ApiParam("orderSetting") OmsOrderSetting orderSetting) {
        CommontResult commontResult;
        int count = orderSettingService.update(id, orderSetting);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("update success:{}", orderSetting);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("update failed:{}", orderSetting);
        }
        return commontResult;
    }
}
