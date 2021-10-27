package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.dto.OMSMoneyInfoParam;
import com.xiaozhen.mall.tiny.dto.OmsOrderDeliveryParam;
import com.xiaozhen.mall.tiny.dto.OmsOrderDetail;
import com.xiaozhen.mall.tiny.dto.OmsReceiverInfoParam;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrder;
import com.xiaozhen.mall.tiny.service.OmsOrderService;
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
 * @description : 订单管理
 * @create time:17:22
 * @Author : XiaoZhen
 **/
@Api(tags = "OmsOrderController", description = "订单管理")
@Controller
@RequestMapping("/order")
public class OmsOrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OmsOrderController.class);
    @Autowired
    private OmsOrderService orderService;

    @ApiOperation("获取订单详情:订单信息、商品信息、操作记录")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<OmsOrderDetail> getOrderDetail(@PathVariable("id")
                                                        @ApiParam("id") Long id) {
        return CommontResult.success(orderService.getOrderDetail(id));
    }

    @ApiOperation("批量删除订单")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult deleteOrderList(@RequestParam("ids")
                                         @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = orderService.deleteOrderList(ids);
        if (count > 0) {
            commontResult = CommontResult.success(ids);
            LOGGER.debug("deleteOrderList success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("deleteOrderList failed:ids={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("查询订单")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<OmsOrder>> listOrder(@RequestParam(name = "createTime", defaultValue = "")
                                                         @ApiParam("订单提交时间") String createTime,
                                                         @RequestParam(name = "orderSn", defaultValue = "")
                                                         @ApiParam("订单编号") String orderSn,
                                                         @RequestParam(name = "orderType", defaultValue = "")
                                                         @ApiParam("订单类型:0->正常订单;1->秒杀订单") Integer orderType,
                                                         @RequestParam(name = "pageNum", defaultValue = "1")
                                                         @ApiParam("页码") Integer pageNum,
                                                         @RequestParam(name = "pageSize", defaultValue = "5")
                                                         @ApiParam("每页数量") Integer pageSize,
                                                         @RequestParam(name = "receiveKeyword", defaultValue = "")
                                                         @ApiParam("收货人姓名/号码") String receiveKeyword,
                                                         @RequestParam(name = "sourceType", defaultValue = "")
                                                         @ApiParam("订单来源:0->PC订单;1->app订单") Integer sourceType,
                                                         @RequestParam(name = "status", defaultValue = "")
                                                         @ApiParam("订单状态:0->待付款;1->代发货;2->已发货;3->已完成;4->已关闭;5->无效订单") Integer status) {
        List<OmsOrder> orderList = orderService.listOrder(createTime, orderSn, orderType, pageNum, pageSize,
                receiveKeyword, sourceType, status);
        return CommontResult.success(CommonPage.restPage(orderList));
    }

    @ApiOperation("批量更新订单状态")
    @RequestMapping(value = "/update/status", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateStatus(@RequestParam(name = "status", defaultValue = "")
                                      @ApiParam("订单状态") Integer status,
                                      @RequestParam(name = "ids")
                                      @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = orderService.updateStatus(status, ids);
        if (count > 0) {
            commontResult = CommontResult.success(ids);
            LOGGER.debug("updateStatus success:{}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateStatus failed:{}", ids);
        }
        return commontResult;
    }

    @ApiOperation("批量发货")
    @RequestMapping(value = "/update/delivery", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateDelivery(@RequestBody
                                        @ApiParam("deliveryParamList") List<OmsOrderDeliveryParam> orderDeliveryParamList) {
        CommontResult commontResult;
        int count = orderService.updateDelivery(orderDeliveryParamList);
        if (count > 0) {
            commontResult = CommontResult.success(orderDeliveryParamList);
            LOGGER.debug("updateDelivery success:{}", orderDeliveryParamList);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateDelivery failed:{}", orderDeliveryParamList);
        }
        return commontResult;
    }

    @ApiOperation("修改订单费用信息")
    @RequestMapping(value = "/update/moneyInfo", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateMoneyInfo(@RequestBody
                                         @ApiParam("moneyInfoParam") OMSMoneyInfoParam moneyInfoParam) {
        CommontResult commontResult;
        int count = orderService.updateMoneyInfo(moneyInfoParam);
        if (count == 1) {
            commontResult = CommontResult.success(moneyInfoParam);
            LOGGER.debug("updateMoneyInfo success:{}", moneyInfoParam);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateMoneyInfo failed:{}", moneyInfoParam);
        }
        return commontResult;
    }

    @ApiOperation("备注订单")
    @RequestMapping(value = "/update/note", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateNote(@RequestParam(name = "id")
                                    @ApiParam("id") Long id,
                                    @RequestParam(name = "note")
                                    @ApiParam("note") String note,
                                    @RequestParam(name = "status")
                                    @ApiParam("status") Integer status) {
        CommontResult commontResult;
        int count = orderService.updateNote(id, note, status);
        if (count == 1) {
            commontResult = CommontResult.success(id);
            LOGGER.debug("updateNote success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateNote failed:id={}", id);
        }
        return commontResult;
    }

    @ApiOperation("修改收货人信息")
    @RequestMapping(value = "/update/receiverInfo", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateReceiverInfo(@RequestBody
                                            @ApiParam("moneyInfoParam") OmsReceiverInfoParam receiverInfoParam) {
        CommontResult commontResult;
        int count = orderService.updateReceiverInfo(receiverInfoParam);
        if (count == 1) {
            commontResult = CommontResult.success(receiverInfoParam);
            LOGGER.debug("updateReceiverInfo success:{}", receiverInfoParam);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateReceiverInfo failed:{}", receiverInfoParam);
        }
        return commontResult;
    }
}
