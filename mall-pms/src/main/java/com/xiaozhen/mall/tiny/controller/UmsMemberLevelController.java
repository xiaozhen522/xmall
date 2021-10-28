package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.mbg.model.UmsMemberLevel;
import com.xiaozhen.mall.tiny.service.UmsMemberLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description : 会员等级管理
 * @create time:23:28
 * @Author : XiaoZhen
 **/
@Api(tags = "UmsMemberLevelController", description = "会员等级管理")
@Controller
@RequestMapping("/memberLevel")
public class UmsMemberLevelController {
    @Autowired
    private UmsMemberLevelService memberLevelService;


    @ApiOperation("查询所有会员等级")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<UmsMemberLevel>> list(@RequestParam(name = "defaultStatus", defaultValue = "")
                                                    @ApiParam("defaultStatus") Integer defaultStatus) {
        return CommontResult.success(memberLevelService.list(defaultStatus));
    }
}
