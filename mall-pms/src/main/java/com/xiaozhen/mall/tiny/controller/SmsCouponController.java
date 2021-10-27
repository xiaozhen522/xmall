package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.dto.SmsCouponParm;
import com.xiaozhen.mall.tiny.mbg.model.SmsCoupon;
import com.xiaozhen.mall.tiny.service.SmsCouponService;
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
 * @description : 优惠券管理
 * @create time:22:21
 * @Author : XiaoZhen
 **/
@Api(tags = "SmsCouponController", description = "优惠券管理")
@Controller
@RequestMapping("/coupon")
public class SmsCouponController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsCouponController.class);
    @Autowired
    private SmsCouponService couponService;

    @ApiOperation("获取单个优惠券的详细信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<SmsCouponParm> getCouponParm(@PathVariable("id")
                                                      @ApiParam("id") Long id) {
        return CommontResult.success(couponService.getCouponParm(id));
    }

    @ApiOperation("添加优惠券")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult createCoupon(@RequestBody
                                      @ApiParam("couponPram") SmsCouponParm couponParm) {
        CommontResult commontResult;
        int count = couponService.createCoupon(couponParm);
        if (count > 0) {
            commontResult = CommontResult.success(couponParm);
            LOGGER.debug("createCoupon success:{}", couponParm);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("createCoupon failed:{}", couponParm);
        }
        return commontResult;
    }

    @ApiOperation("删除优惠券")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult deleteCoupon(@PathVariable("id")
                                      @ApiParam("id") Long id) {
        CommontResult commontResult;
        int count = couponService.deleteCoupon(id);
        if (count > 0) {
            commontResult = CommontResult.success(id);
            LOGGER.debug("deleteCoupon success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("deleteCoupon failed:id={}", id);
        }
        return commontResult;
    }

    @ApiOperation("根据优惠券名称和类型分页获取优惠券列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<SmsCoupon>> listCoupon(@RequestParam(name = "name", defaultValue = "")
                                                           @ApiParam("name") String name,
                                                           @RequestParam(name = "pageNum", defaultValue = "1")
                                                           @ApiParam("页码") Integer pageNum,
                                                           @RequestParam(name = "pageSize", defaultValue = "5")
                                                           @ApiParam("每页数量") Integer pageSize,
                                                           @RequestParam(name = "type", defaultValue = "")
                                                           @ApiParam("type") Integer type) {
        List<SmsCoupon> couponList = couponService.listCoupon(name, pageNum, pageSize, type);
        return CommontResult.success(CommonPage.restPage(couponList));
    }

    @ApiOperation("修改优惠券")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateCoupon(@PathVariable("id")
                                      @ApiParam("id") Long id,
                                      @RequestBody
                                      @ApiParam("couponParam") SmsCouponParm couponParm) {
        CommontResult commontResult;
        int count = couponService.updateCoupon(id, couponParm);
        if (count > 0) {
            commontResult = CommontResult.success(couponParm);
            LOGGER.debug("updateCoupon success:{}", couponParm);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateCoupon failed:{}", couponParm);
        }
        return commontResult;
    }

}
