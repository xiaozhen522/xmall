package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.dto.ProductAttrInfo;
import com.xiaozhen.mall.tiny.dto.ProductAttributeParam;
import com.xiaozhen.mall.tiny.mbg.model.PmsProductAttribute;
import com.xiaozhen.mall.tiny.service.PmsProductAttributeService;
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
 * @description : 商品属性管理
 * @create time:18:44
 * @Author : XiaoZhen
 **/
@Api(tags = "PmsProductAttributeController", description = "商品属性管理")
@Controller
@RequestMapping("/productAttribute")
public class PmsProductAttributeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsProductAttributeController.class);
    @Autowired
    private PmsProductAttributeService productAttributeService;

    @ApiOperation("查询单个商品属性")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<PmsProductAttribute> getById(@PathVariable("id")
                                                      @ApiParam("id") Long id) {
        return CommontResult.success(productAttributeService.getById(id));
    }

    @ApiOperation("根据商品分类的id获取商品属性及属性分类")
    @RequestMapping(value = "/attrInfo/{productCategoryId}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<ProductAttrInfo>> getAttrInfoByproductCategoryId(@PathVariable("productCategoryId")
                                                                               @ApiParam("productCategoryId") Long productCategoryId) {
        return CommontResult.success(productAttributeService.getAttrInfoByproductCategoryId(productCategoryId));
    }

    @ApiOperation("添加商品属性信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult create(@RequestBody ProductAttributeParam productAttributeParam) {
        CommontResult commontResult;
        int count = productAttributeService.create(productAttributeParam);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("create success:{}", productAttributeParam);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("create failed:{}", productAttributeParam);
        }
        return commontResult;
    }

    @ApiOperation("批量删除商品属性")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult delete(@RequestParam("ids")
                                @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = productAttributeService.delete(ids);
        if (count > 0) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("delete success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("delete failed:ids={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("根据分类查询属性列表或参数列表")
    @RequestMapping(value = "/list/{cid}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<PmsProductAttribute>> listByCidOrType(@RequestParam(name = "pageNum",
            defaultValue = "1")
                                                                          @ApiParam("页码") Integer pageNum,
                                                                          @RequestParam(name = "pageSize", defaultValue = "5")
                                                                          @ApiParam("每页数量") Integer pageSize,
                                                                          @PathVariable("cid")
                                                                          @ApiParam("cid") Long cid,
                                                                          @RequestParam(name = "type", defaultValue = "")
                                                                          @ApiParam("0表示属性，1表示参数") Integer type) {

        List<PmsProductAttribute> productAttributeList = productAttributeService.listByCidOrType(cid, pageNum,
                pageSize, type);
        return CommontResult.success(CommonPage.restPage(productAttributeList));
    }

    @ApiOperation("修改商品属性信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateById(@PathVariable("id")
                                    @ApiParam("id") Long id,
                                    @RequestBody ProductAttributeParam productAttributeParam) {

        CommontResult commontResult;
        int count = productAttributeService.updateById(id, productAttributeParam);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateById success:{}", productAttributeParam);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateById failed:{}", productAttributeParam);
        }
        return commontResult;
    }

}
