package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.mbg.model.CmsSubject;
import com.xiaozhen.mall.tiny.service.CmsSubjectService;
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
 * @description : 商品专题管理
 * @create time:21:44
 * @Author : XiaoZhen
 **/
@Api(tags = "CmsSubjectController", description = "商品专题管理")
@Controller
@RequestMapping("/subject")
public class CmsSubjectController {
    @Autowired
    private CmsSubjectService subjectService;

    @ApiOperation("根据专题名称获取分页专题")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<CmsSubject>> listSubject(@RequestParam(name = "keyword", defaultValue = "")
                                                             @ApiParam("keyword") String keyword,
                                                             @RequestParam(name = "pageNum", defaultValue = "1")
                                                             @ApiParam("页码") Integer pageNum,
                                                             @RequestParam(name = "pageSize", defaultValue = "5")
                                                             @ApiParam("每页数量") Integer pageSize) {
        List<CmsSubject> subjectList = subjectService.listSubject(keyword, pageNum, pageSize);
        return CommontResult.success(CommonPage.restPage(subjectList));
    }

    @ApiOperation("获取全部商品专题")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<CmsSubject>> listAllSubject() {
        return CommontResult.success(subjectService.listAllSubject());
    }
}
