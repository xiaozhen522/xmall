package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.dto.SmsFlashPromotionProduct;
import com.xiaozhen.mall.tiny.mbg.model.SmsFlashPromotionProductRelation;
import com.xiaozhen.mall.tiny.service.SmsFlashPromotionProductRelationService;
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
 * @description : 限时购和商品关系管理
 * @create time:18:25
 * @Author : XiaoZhen
 **/
@Api(tags = "SmsFlashPromotionProductRelationController", description = "限时购和商品关系管理")
@Controller
@RequestMapping("/flashProductRelation")
public class SmsFlashPromotionProductRelationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsFlashPromotionProductRelationController.class);
    @Autowired
    private SmsFlashPromotionProductRelationService flashProductRelationService;

    @ApiOperation("获取管理商品促销信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<SmsFlashPromotionProductRelation> getById(@PathVariable("id")
                                                                   @ApiParam("id") Long id) {
        return CommontResult.success(flashProductRelationService.getById(id));
    }

    @ApiOperation("批量选择商品关系关联")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult create(@RequestBody
                                @ApiParam("relationList") SmsFlashPromotionProductRelation... fpprList) {
        CommontResult commontResult;
        int count = flashProductRelationService.create(fpprList);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("create success:{}", fpprList);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("create failed:{}", fpprList);
        }
        return commontResult;
    }

    @ApiOperation("删除关联")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult deleteById(@PathVariable("id")
                                    @ApiParam("id") Long id) {
        CommontResult commontResult;
        int count = flashProductRelationService.deleteById(id);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("deleteById success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("deleteById failed:id={}", id);
        }
        return commontResult;
    }

    @ApiOperation("分页查询限时购和商品关系")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<SmsFlashPromotionProduct>> list(@RequestParam(name = "flashPromotionId", defaultValue = "")
                                                                    @ApiParam("flashPromotionId") Long flashPromotionId,
                                                                    @RequestParam(name = "flashPromotionSessionId", defaultValue = "")
                                                                    @ApiParam("flashPromotionSessionId") Long flashPromotionSessionId,
                                                                    @RequestParam(name = "pageNum", defaultValue = "1")
                                                                    @ApiParam("页码") Integer pageNum,
                                                                    @RequestParam(name = "pageSize", defaultValue = "5")
                                                                    @ApiParam("每页数量") Integer pageSize) {
        List<SmsFlashPromotionProduct> fppList = flashProductRelationService.list(flashPromotionId, flashPromotionSessionId,
                pageNum, pageSize);
        return CommontResult.success(CommonPage.restPage(fppList));
    }

    @ApiOperation("修改关联信息相关信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateById(@PathVariable("id")
                                    @ApiParam("id") Long id,
                                    @RequestBody
                                    @ApiParam("relation") SmsFlashPromotionProductRelation flashProductRelation) {
        CommontResult commontResult;
        int count = flashProductRelationService.updateById(id, flashProductRelation);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateById success:{}", flashProductRelation);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateById failed:{}", flashProductRelation);
        }
        return commontResult;
    }

}
