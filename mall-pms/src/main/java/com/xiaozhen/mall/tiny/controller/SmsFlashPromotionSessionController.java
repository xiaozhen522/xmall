package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.dto.SmsFlashPromotionSessionDeatil;
import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotionSession;
import com.xiaozhen.mall.tiny.service.SmsFlashPromotionSessionService;
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
 * @description : 限时场次管理
 * @create time:22:33
 * @Author : XiaoZhen
 **/
@Api(tags = "SmsFlashPromotionSessionController", description = "限时场次管理")
@Controller
@RequestMapping("/flashSession")
public class SmsFlashPromotionSessionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsFlashPromotionSessionController.class);
    @Autowired
    private SmsFlashPromotionSessionService flashSessionService;

    @ApiOperation("获取场次详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<SmsFlashPromotionSession> getById(@PathVariable("id")
                                                           @ApiParam("id") Long id) {
        return CommontResult.success(flashSessionService.getById(id));
    }

    @ApiOperation("添加场次")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult create(@RequestBody
                                @ApiParam("promotionSession") SmsFlashPromotionSession flashSession) {
        CommontResult commontResult;
        int count = flashSessionService.create(flashSession);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("create success:{}", flashSession);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("create failed:{}", flashSession);
        }
        return commontResult;
    }

    @ApiOperation("删除场次")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult deleteById(@PathVariable("id")
                                    @ApiParam("id") Long id) {
        CommontResult commontResult;
        int count = flashSessionService.deleteById(id);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("deleteById success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("deleteById failed:id={}", id);
        }
        return commontResult;
    }

    @ApiOperation("获取全部场次")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<SmsFlashPromotionSession>> list() {
        return CommontResult.success(flashSessionService.list());
    }

    @ApiOperation("获取全部可选场次及其数量")
    @RequestMapping(value = "/selectList", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<SmsFlashPromotionSessionDeatil>> selectList(@RequestParam(name = "flashPromotion")
                                                                          @ApiParam("flashPromotionId") Long flashPromotionId) {
        return CommontResult.success(flashSessionService.selectList(flashPromotionId));
    }

    @ApiOperation("修改场次")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateById(@PathVariable("id")
                                    @ApiParam("id") Long id,
                                    @RequestBody
                                    @ApiParam("promotionSession") SmsFlashPromotionSession flashSession) {
        CommontResult commontResult;
        int count = flashSessionService.updateById(id, flashSession);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateById success:{}", flashSession);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateById failed:{}", flashSession);
        }
        return commontResult;
    }

    @ApiOperation("修改启用状态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateStatusById(@PathVariable("id")
                                          @ApiParam("id") Long id,
                                          @RequestParam(name = "status")
                                          @ApiParam("status") Integer status) {
        CommontResult commontResult;
        int count = flashSessionService.updateStatusById(id, status);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateStatusById success:{}", status);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateStatusById failed:{}", status);
        }
        return commontResult;
    }

}
