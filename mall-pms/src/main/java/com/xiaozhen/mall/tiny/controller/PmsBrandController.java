package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.dto.PmsBrandParm;
import com.xiaozhen.mall.tiny.mbg.model.PmsBrand;
import com.xiaozhen.mall.tiny.service.PmsBrandService;
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
 * @description : 商品品牌管理
 * @create time:13:26
 * @Author : XiaoZhen
 **/
@Api(tags = "PmsBrandController", description = "商品品牌管理")
@Controller
@RequestMapping("/brand")
public class PmsBrandController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);
    @Autowired
    private PmsBrandService brandService;

    @ApiOperation("根据编号查询品牌信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<PmsBrand> getById(@PathVariable("id")
                                           @ApiParam("id") Long id) {
        return CommontResult.success(brandService.getById(id));
    }

    @ApiOperation("添加品牌品牌")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult create(@RequestBody
                                @ApiParam("pmsBrand") PmsBrandParm brandParm) {
        CommontResult commontResult;
        int count = brandService.create(brandParm);
        if (count == 1) {
            commontResult = CommontResult.success(brandParm);
            LOGGER.debug("create success:{}", brandParm);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("create failed:{}", brandParm);
        }
        return commontResult;
    }

    @ApiOperation("删除品牌")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult deleteById(@PathVariable("id")
                                    @ApiParam("id") Long id) {
        CommontResult commontResult;
        int count = brandService.deleteById(id);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("deleteById success:id={}", id);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("deleteById failed:id={}", id);
        }
        return commontResult;
    }

    @ApiOperation("批量删除品牌")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult deleteBatch(@RequestParam(name = "ids")
                                     @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = brandService.deleteBatch(ids);
        if (count > 0) {
            commontResult = CommontResult.success(ids);
            LOGGER.debug("deleteBatch success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("deleteBatch failed:ids={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("根据品牌名称分页获取品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<PmsBrand>> list(@RequestParam(name = "pageNum", defaultValue = "1")
                                                    @ApiParam("页码") Integer pageNum,
                                                    @RequestParam(name = "pageSize", defaultValue = "5")
                                                    @ApiParam("每页数量") Integer pageSize,
                                                    @RequestParam(name = "keyword", defaultValue = "")
                                                    @ApiParam("keyword") String keyword) {
        List<PmsBrand> brandList = brandService.list(keyword, pageNum, pageSize);
        return CommontResult.success(CommonPage.restPage(brandList));
    }

    @CrossOrigin(origins = "http://127.0.0.1:8848")
    @ApiOperation("获取所有品牌列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<PmsBrand>> listAll() {
        return CommontResult.success(brandService.listAll());
    }

    @ApiOperation("更新品牌")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateById(@PathVariable("id")
                                    @ApiParam("id") Long id,
                                    @RequestBody
                                    @ApiParam("pmsBrandParam") PmsBrand brand) {

        CommontResult commontResult;
        int count = brandService.updateById(id, brand);
        if (count == 1) {
            commontResult = CommontResult.success(null);
            LOGGER.debug("updateById success:{}", brand);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateById failed:{}", brand);
        }
        return commontResult;
    }

    @ApiOperation("批量更新厂家制造商状态")
    @RequestMapping(value = "/update/factoryStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateFactoryStatus(@RequestParam(name = "factoryStatus", defaultValue = "0")
                                             @ApiParam("fatcoryStatus") Integer factoryStatus,
                                             @RequestParam(name = "ids")
                                             @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = brandService.updateFactoryStatus(factoryStatus, ids);
        if (count > 0) {
            commontResult = CommontResult.success(ids);
            LOGGER.debug("updateFactoryStatus success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateFactoryStatus failed:ids={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("批量更新显示状态")
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateShowStatus(@RequestParam(name = "showStatus", defaultValue = "0")
                                          @ApiParam("showStatus") Integer showStatus,
                                          @RequestParam(name = "ids")
                                          @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = brandService.updateShowStatus(showStatus, ids);
        if (count > 0) {
            commontResult = CommontResult.success(ids);
            LOGGER.debug("updateShowStatus success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateShowStatus failed:ids={}", ids);
        }
        return commontResult;
    }

}
