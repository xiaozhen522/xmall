package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.service.UmsMerberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description : 会员登录注册管理Controller
 * @create time:2021/10/26
 * @Author : XiaoZhen
 **/
@Api(tags = "UmsMemberController", description = "会员登录注册管理")
@Controller
@RequestMapping("/sso")
public class UmsMemberController {
    @Autowired
    private UmsMerberService merberService;

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult getAuthCode(@RequestParam(name = "telephone")
                                     @ApiParam("telephone") String telephone) {
        return merberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult verifyAuthCode(@RequestParam(name = "telephone")
                                        @ApiParam("telephone") String telephone,
                                        @RequestParam(name = "authCode")
                                        @ApiParam("authCode") String authCode) {
        return merberService.verifyAuthCode(telephone, authCode);
    }
}
