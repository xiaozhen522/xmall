package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.mbg.model.SmsHomeRecommendSubject;
import com.xiaozhen.mall.tiny.service.SmsHomeRecommendSubjectService;
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
 * @description : 首页专题推荐管理
 * @create time:14:05
 * @Author : XiaoZhen
 **/
@Api(tags = "SmsHomeRecommendSubjectController", description = "首页专题推荐管理")
@Controller
@RequestMapping("/home/recommendSubject")
public class SmsHomeRecommendSubjectController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsHomeRecommendSubjectController.class);
    @Autowired
    private SmsHomeRecommendSubjectService homeRecommendSubjectService;

    @ApiOperation("添加首页推荐专题")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult create(@RequestBody
                                @ApiParam("homeRecommendSubjectList") SmsHomeRecommendSubject... homeRecommendSubjectList) {
        CommontResult commontResult;
        int count = homeRecommendSubjectService.create(homeRecommendSubjectList);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("create success:{}", homeRecommendSubjectList);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("create failed:{}", homeRecommendSubjectList);
        }
        return commontResult;
    }

    @ApiOperation("批量删除推荐")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult delete(@RequestParam(name = "ids")
                                @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = homeRecommendSubjectService.delete(ids);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("delete success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("delete failed:ids={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("分页查询推荐")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<SmsHomeRecommendSubject>> list(@RequestParam(name = "pageNum", defaultValue = "1")
                                                                   @ApiParam("页码") Integer pageNum,
                                                                   @RequestParam(name = "pageSize", defaultValue = "5")
                                                                   @ApiParam("每页数量") Integer pageSize,
                                                                   @RequestParam(name = "recommendStatus", defaultValue = "")
                                                                   @ApiParam("recommendStatus") Integer recommendStatus,
                                                                   @RequestParam(name = "subjectName", defaultValue = "")
                                                                   @ApiParam("subjectName") String subjectName) {
        List<SmsHomeRecommendSubject> homeRecommendSubjectList =
                homeRecommendSubjectService.list(pageNum, pageSize, recommendStatus, subjectName);
        return CommontResult.success(CommonPage.restPage(homeRecommendSubjectList));
    }

    @ApiOperation("批量修改推荐")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateRecommendStatus(@RequestParam(name = "recommendStatus", defaultValue = "")
                                               @ApiParam("recommendStatus") Integer recommendStatus,
                                               @RequestParam(name = "ids")
                                               @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = homeRecommendSubjectService.updateRecommendStatus(ids, recommendStatus);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateRecommendStatus success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateRecommendStatus failed:ids={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("批量推荐排序")
    @RequestMapping(value = "/update/sort/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateSortById(@PathVariable("id")
                                        @ApiParam("id") Long id,
                                        @RequestParam(name = "sort")
                                        @ApiParam("sort") Integer sort) {
        CommontResult commontResult;
        int count = homeRecommendSubjectService.updateSortById(id, sort);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateSortById success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateSortById failed:id={}", id);
        }
        return commontResult;
    }
}
