package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.mbg.model.PmsSkuStock;
import com.xiaozhen.mall.tiny.service.PmsSkuStockService;
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
 * @description: sku商品库存管理
 * @create time:15:20
 * @Author: XiaoZhen
 **/
@Api(tags = "PmsSkuStockController", description = "sku商品库存管理")
@Controller
@RequestMapping("/sku")
public class PmsSkuStockController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsSkuStockController.class);
    @Autowired
    private PmsSkuStockService skuService;

    @ApiOperation("根据商品编号及编号模糊搜索sku库存")
    @RequestMapping(value = "/get/{pid}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<PmsSkuStock>> getSkuStock(@PathVariable("pid")
                                                        @ApiParam("pid") Long pid,
                                                        @RequestParam(name = "keyword",defaultValue = "")
                                                        @ApiParam("keyword") String keyword) {
        return CommontResult.success(skuService.getSkuStock(pid, keyword));
    }

    @ApiOperation("批量更新库存信息")
    @RequestMapping(value = "/update/{pid}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateSkuStockList(@PathVariable("pid")
                                            @ApiParam("pid") Long pid,
                                            @RequestBody
                                            @ApiParam("skuStockList") PmsSkuStock... skuStockList) {
        CommontResult commontResult;
        int count = skuService.updateSkuStockList(pid, skuStockList);
        if (count > 0) {
            commontResult = CommontResult.success(skuStockList);
            LOGGER.debug("updateSkuStockList success:{}", skuStockList);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateSkuStockList failed:{}", skuStockList);
        }
        return commontResult;
    }

}
