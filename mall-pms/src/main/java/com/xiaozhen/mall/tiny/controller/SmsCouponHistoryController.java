package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.mbg.model.SmsCouponHistory;
import com.xiaozhen.mall.tiny.service.SmsCouponHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description: 优惠券领取记录管理
 * @create time:17:40
 * @Author: XiaoZhen
 **/
@Api(tags = "SmsCouponHistoryController", description = "优惠券领取记录管理")
@Controller
@RequestMapping("/couponHistory")
public class SmsCouponHistoryController {
    @Autowired
    private SmsCouponHistoryService couponHistoryService;

    @ApiOperation("根据优惠券id,使用状态,订单编号分页获取领取记录")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<SmsCouponHistory>> listCouponHistory(@RequestParam(name = "couponId", defaultValue = "")
                                                                         @ApiParam("couponId") Long couponId,
                                                                         @RequestParam(value = "orderSn", defaultValue = "")
                                                                         @ApiParam("orderSn") String orderSn,
                                                                         @RequestParam(name = "pageNum", defaultValue = "1")
                                                                         @ApiParam("页码") Integer pageNum,
                                                                         @RequestParam(name = "pageSize", defaultValue = "5")
                                                                         @ApiParam("每页数量") Integer pageSize,
                                                                         @RequestParam(value = "useStatus", defaultValue = "")
                                                                         @ApiParam("useStatus") Integer useStatus) {
        List<SmsCouponHistory> couponHistoryList = couponHistoryService.listCouponHistory(couponId, orderSn, pageNum, pageSize, useStatus);
        return CommontResult.success(CommonPage.restPage(couponHistoryList));
    }
}
