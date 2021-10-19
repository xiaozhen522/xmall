package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.mbg.model.CmsPrefrenceArea;
import com.xiaozhen.mall.tiny.service.CmsPrefrenceAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 商品优选管理
 * @create time:21:34
 * @Author: XiaoZhen
 **/
@Api(tags = "CmsPrefrenceAreaController", description = "商品优选管理")
@Controller
@RequestMapping("/prefrenceArea")
public class CmsPrefrenceAreaController {
    @Autowired
    private CmsPrefrenceAreaService prefrenceAreaService;
    @ApiOperation("获取所有商品优选")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<CmsPrefrenceArea>> listAllPrefrenceArea() {
        return CommontResult.success(prefrenceAreaService.listAllPrefrenceArea());
    }
}
