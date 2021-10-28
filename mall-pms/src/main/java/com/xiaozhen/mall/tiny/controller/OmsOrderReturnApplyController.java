package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.dto.OmsUpdateStatusParam;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrderReturnApply;
import com.xiaozhen.mall.tiny.service.OmsOrderReturnApplyService;
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
 * @description : 订单退货申请管理
 * @create time:10:45
 * @Author : XiaoZhen
 **/
@Api(tags = "OmsOrderReturnApplyController", description = "订单退货申请管理")
@Controller
@RequestMapping("/returnApply")
public class OmsOrderReturnApplyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OmsOrderReturnApplyController.class);
    @Autowired
    private OmsOrderReturnApplyService orderReturnApplyService;

    @ApiOperation("获取退货申请详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<OmsOrderReturnApply> getById(@PathVariable("id")
                                                  @ApiParam("id") Long id) {
        return CommontResult.success(orderReturnApplyService.getById(id));
    }

    @ApiOperation("批量删除申请")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult delete(@RequestParam("ids")
                                @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = orderReturnApplyService.delete(ids);
        if (count > 0) {
            commontResult = CommontResult.success(ids);
            LOGGER.debug("delete success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("delete failed:ids={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("分页查询退货申请")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<OmsOrderReturnApply>> list(@RequestParam(name = "createTime", defaultValue = "")
                                                               @ApiParam("申请时间") String createTime,
                                                               @RequestParam(name = "handleMan", defaultValue = "")
                                                               @ApiParam("处理人员") String handleMan,
                                                               @RequestParam(name = "handleTime", defaultValue = "")
                                                               @ApiParam("处理时间") String handleTime,
                                                               @RequestParam(name = "id", defaultValue = "")
                                                               @ApiParam("服务单号") Long id,
                                                               @RequestParam(name = "pageNum", defaultValue = "1")
                                                               @ApiParam("页码") Integer pageNum,
                                                               @RequestParam(name = "pageSize", defaultValue = "5")
                                                               @ApiParam("每页数量") Integer pageSize,
                                                               @RequestParam(name = "receiverKeyword"
                                                                       , defaultValue = "")
                                                               @ApiParam("收货人姓名/号码") String receiverKeyword,
                                                               @RequestParam(name = "ststus", defaultValue = "")
                                                               @ApiParam("申请状态:0->待处理;1->退货中;2->已完成;" +
                                                                       "3->已拒绝") Integer ststus) {
        List<OmsOrderReturnApply> returnApplyList = orderReturnApplyService.list(createTime, handleMan,
                handleTime, id, pageNum, pageSize, receiverKeyword, ststus);
        return CommontResult.success(CommonPage.restPage(returnApplyList));
    }

    @ApiOperation("修改申请状态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateStatusById(@PathVariable("id")
                                      @ApiParam("id") Long id,
                                      @RequestBody
                                      @ApiParam("statusParam") OmsUpdateStatusParam statusParam) {
        CommontResult commontResult;
        int count = orderReturnApplyService.updateStatusById(id, statusParam);
        if (count == 1) {
            commontResult = CommontResult.success(statusParam);
            LOGGER.debug("updateStatusById success:{}", statusParam);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateStatusById failed:{}", statusParam);
        }
        return commontResult;
    }

}
