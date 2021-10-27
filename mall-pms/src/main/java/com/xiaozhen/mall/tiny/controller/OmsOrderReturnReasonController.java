package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrderReturnReason;
import com.xiaozhen.mall.tiny.service.OmsOrderReturnReasonService;
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
 * @description : 退货原因管理
 * @create time:20:56
 * @Author : XiaoZhen
 **/
@Api(tags = "OmsOrderReturnReasonController", description = "退货原因管理")
@Controller
@RequestMapping("/returnReason")
public class OmsOrderReturnReasonController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OmsOrderReturnReasonController.class);
    @Autowired
    private OmsOrderReturnReasonService returnReasonService;

    @ApiOperation("获取单个退货原因详情信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<OmsOrderReturnReason> get(@PathVariable("id")
                                                   @ApiParam("id") Long id) {
        return CommontResult.success(returnReasonService.get(id));
    }

    @ApiOperation("添加退货原因")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult create(@RequestBody
                                @ApiParam("returnReason") OmsOrderReturnReason returnReason) {
        CommontResult commontResult;
        int count = returnReasonService.create(returnReason);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("create success:{}", returnReason);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("create failed:{}", returnReason);
        }
        return commontResult;
    }

    @ApiOperation("批量删除退货原因")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult delete(@RequestParam("ids")
                                @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = returnReasonService.delete(ids);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("delete success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("delete failed:ids={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("分页查询全部退货原因")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<OmsOrderReturnReason>> list(@RequestParam(name = "pageNum", defaultValue = "1")
                                                                @ApiParam("页码") Integer pageNum,
                                                                @RequestParam(name = "pageSize", defaultValue = "5")
                                                                @ApiParam("每页数量") Integer pageSize) {
        List<OmsOrderReturnReason> returnReasonList = returnReasonService.list(pageNum, pageSize);
        return CommontResult.success(CommonPage.restPage(returnReasonList));
    }

    @ApiOperation("修改退货原因")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult update(@PathVariable("id")
                                @ApiParam("id") Long id,
                                @RequestBody
                                @ApiParam("returnReason") OmsOrderReturnReason returnReason) {
        CommontResult commontResult;
        int count = returnReasonService.update(id, returnReason);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("update success:{}", returnReason);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("update failed:{}", returnReason);
        }
        return commontResult;
    }

    @ApiOperation("修改退货原因启用状态")
    @RequestMapping(value = "/update/status", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateStatus(@RequestParam(name = "status", defaultValue = "")
                                      @ApiParam("status") Integer status,
                                      @RequestParam(name = "ids")
                                      @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = returnReasonService.updateStatus(ids, status);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateStatus success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateStatus failed:ids={}", ids);
        }
        return commontResult;
    }

}
