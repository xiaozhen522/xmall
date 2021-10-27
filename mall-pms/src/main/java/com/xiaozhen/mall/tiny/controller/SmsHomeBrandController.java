package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.mbg.model.SmsHomeBrand;
import com.xiaozhen.mall.tiny.service.SmsHomeBrandService;
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
 * @description : 首页品牌管理
 * @create time:19:33
 * @Author : XiaoZhen
 **/
@Api(tags = "SmsHomeBrandController", description = "首页品牌管理")
@Controller
@RequestMapping("/home/brand")
public class SmsHomeBrandController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsHomeBrandController.class);
    @Autowired
    private SmsHomeBrandService homeBrandService;

    @ApiOperation("添加首页推荐品牌")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult createHomeBrands(@RequestBody
                                          @ApiParam("homeBrandList") SmsHomeBrand... homeBrandList) {
        CommontResult commontResult;
        int count = homeBrandService.createHomeBrands(homeBrandList);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("createHomeBrand success:{}", homeBrandList);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("createHomeBrand failed:{}", homeBrandList);
        }
        return commontResult;
    }

    @ApiOperation("批量删除推荐品牌")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult deleteHomeBrands(@RequestParam(name = "ids")
                                          @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = homeBrandService.deleteHomeBrands(ids);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("deleteHomeBrand success:id={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("deleteHomeBrand failed:id={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("分页查询推荐品牌")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<SmsHomeBrand>> listHomeBrand(@RequestParam(name = "brandName",defaultValue = "")
                                                                 @ApiParam("brandName") String brandName,
                                                                 @RequestParam(name = "pageNum", defaultValue = "1")
                                                                 @ApiParam("页码") Integer pageNum,
                                                                 @RequestParam(name = "pageSize", defaultValue = "5")
                                                                 @ApiParam("每页数量") Integer pageSize) {
        List<SmsHomeBrand> homeBrandList = homeBrandService.listHomeBrand(brandName, pageNum, pageSize);
        return CommontResult.success(CommonPage.restPage(homeBrandList));
    }

    @ApiOperation("批量修改推荐状态")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateStatus(@RequestParam(name = "recommendStatus")
                                      @ApiParam("recommendStatus") Integer recommendStatus,
                                      @RequestParam(name = "ids")
                                      @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = homeBrandService.updateStatus(ids, recommendStatus);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateStatus success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateStatus failed:ids={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("批量品牌排序")
    @RequestMapping(value = "/update/sort/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateSort(@PathVariable("id")
                                    @ApiParam("id") Long id,
                                    @RequestParam(name = "sort")
                                    @ApiParam("sort") Integer sort) {
        CommontResult commontResult;
        int count = homeBrandService.updateSort(id, sort);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateSort success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateSort failed:id={}", id);
        }
        return commontResult;
    }

}
