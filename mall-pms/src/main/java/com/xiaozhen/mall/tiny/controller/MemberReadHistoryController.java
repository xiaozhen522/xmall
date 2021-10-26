package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import com.xiaozhen.mall.tiny.service.MemberReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description : 会员商品浏览记录管理Controller
 * @create time:2021/10/26
 * @Author : XiaoZhen
 **/
@Api(tags = "MemberReadHistoryController", description = "会员商品浏览记录管理")
@Controller
@RequestMapping("/member/readHistory")
public class MemberReadHistoryController {
    @Autowired(required = false)
    private MemberReadHistoryService memberReadHistoryService;

    @ApiOperation("创建浏览记录")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult create(@RequestBody
                                @ApiParam("memberReadHistory") MemberReadHistory memberReadHistory) {
        int count = memberReadHistoryService.create(memberReadHistory);
        if (count == 1) {
            return CommontResult.success(count);
        } else {
            return CommontResult.failed();
        }
    }

    @ApiOperation("删除浏览记录")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult delete(@RequestParam(name = "ids")
                                @ApiParam("ids") List<String> ids) {
        int count = memberReadHistoryService.delete(ids);
        if (count > 0) {
            return CommontResult.success(count);
        } else {
            return CommontResult.failed();
        }
    }

    @ApiOperation("展示浏览记录")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<MemberReadHistory>> list(@RequestParam("memberId")
                                                       @ApiParam("memberId") Long memberId) {
        return CommontResult.success(memberReadHistoryService.list(memberId));

    }
}
