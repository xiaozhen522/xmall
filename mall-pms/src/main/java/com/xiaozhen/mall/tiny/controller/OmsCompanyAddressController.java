package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.mbg.model.OmsCompanyAddress;
import com.xiaozhen.mall.tiny.service.OmsCompanyAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description : 公司收发货地址管理
 * @create time:16:58
 * @Author : XiaoZhen
 **/
@Api(tags = "OmsCompanyAddressController", description = "收获地址管理")
@Controller
@RequestMapping("/companyAddress")
public class OmsCompanyAddressController {
    @Autowired
    private OmsCompanyAddressService companyAddressService;

    @ApiOperation("获取所有公司收发货地址")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<OmsCompanyAddress>> listCompanyAddress() {
        return CommontResult.success(companyAddressService.listCompanyAddress());
    }
}
