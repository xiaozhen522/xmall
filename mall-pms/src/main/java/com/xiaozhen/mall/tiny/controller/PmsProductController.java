package com.xiaozhen.mall.tiny.controller;

import com.xiaozhen.mall.tiny.common.api.CommonPage;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import com.xiaozhen.mall.tiny.dto.PmsProductParam;
import com.xiaozhen.mall.tiny.dto.PmsProductResult;
import com.xiaozhen.mall.tiny.mbg.model.PmsProduct;
import com.xiaozhen.mall.tiny.service.PmsProductService;
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
 * @description : 商品管理
 * @create time:11:26
 * @Author : XiaoZhen
 **/
@Api(tags = "PmsProductController", description = "商品管理")
@Controller
@RequestMapping("/product")
public class PmsProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsProductController.class);
    @Autowired
    private PmsProductService productService;

    @ApiOperation("创建商品")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult createProduct(@RequestBody PmsProductParam productParam) {
        CommontResult commontResult;
        int count = productService.createProduct(productParam);
        if (count == 1) {
            commontResult = CommontResult.success(productParam);
            LOGGER.debug("createProduct success:{}", productParam);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("createProduct failed:{}", productParam);
        }
        return commontResult;
    }

    @ApiOperation("查询商品")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<CommonPage<PmsProduct>> listProduct(@RequestParam(name = "brandId", defaultValue = "")
                                                             @ApiParam("商品品牌编号") Long brandId,
                                                             @RequestParam(name = "keyword", defaultValue = "")
                                                             @ApiParam("商品名称模糊关键字") String keyword,
                                                             @RequestParam(name = "pageNum", defaultValue = "1")
                                                             @ApiParam("页码") Integer pageNum,
                                                             @RequestParam(name = "pageSize", defaultValue = "5")
                                                             @ApiParam("每页数量") Integer pageSize,
                                                             @RequestParam(name = "productCategoryId", defaultValue = "")
                                                             @ApiParam("商品分类编号") Long productCategoryId,
                                                             @RequestParam(name = "productSn", defaultValue = "")
                                                             @ApiParam(value = "商品货号", defaultValue = "") String productSn,
                                                             @RequestParam(name = "publishStatus", defaultValue = "")
                                                             @ApiParam("上架状态") Integer publishStatus,
                                                             @RequestParam(name = "verifyStatus", defaultValue = "")
                                                             @ApiParam("审核状态") Integer verifyStatus) {
        List<PmsProduct> productList = productService.listProduct(brandId, "%" + keyword + "%", pageNum, pageSize,
                productCategoryId
                , productSn, publishStatus, verifyStatus);
        return CommontResult.success(CommonPage.restPage(productList));
    }

    @ApiOperation("根据商品名称或货号模糊查询")
    @RequestMapping(value = "/simpleList", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<List<PmsProduct>> simepleListProduct(@RequestParam(name = "keyword") String keyword) {
        return CommontResult.success(productService.simepleListProduct("%" + keyword + "%"));
    }

    @ApiOperation("更新商品")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateProduct(@PathVariable("id") Long id, @RequestBody PmsProductParam productParam) {
        CommontResult commontResult;
        int count = productService.updateProduct(id, productParam);
        if (count == 1) {
            commontResult = CommontResult.success(productParam);
            LOGGER.debug("updateProduct success:{}", productParam);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateProduct failed:{}", productParam);
        }
        return commontResult;
    }

    @ApiOperation("批量修改删除状态")
    @RequestMapping(value = "/update/deleteStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateProductDeleteStatus(@RequestParam(name = "deleteStatus")
                                                   @ApiParam("deleteStatus") Integer deleteStatus,
                                                   @RequestParam(name = "ids")
                                                   @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = productService.updateProductDeleteStatus(deleteStatus, ids);
        if (count > 0) {
            commontResult = CommontResult.success(ids);
            LOGGER.debug("updateProductDeleteStatus success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateProductDeleteStatus failed:ids={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("批量设为新品")
    @RequestMapping(value = "/update/newStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateProductNewStatus(@RequestParam(name = "newStatus")
                                                @ApiParam("newStatus") Integer newStatus,
                                                @RequestParam(name = "ids")
                                                @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = productService.updateProductNewStatus(newStatus, ids);
        if (count > 0) {
            commontResult = CommontResult.success(ids);
            LOGGER.debug("updateProductNewStatus success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateProductNewStatus failed:ids={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("批量上下架")
    @RequestMapping(value = "/update/publishStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateProductPublishStatus(@RequestParam(name = "publishStatus")
                                                    @ApiParam("publishStatus") Integer publishStatus,
                                                    @RequestParam(name = "ids")
                                                    @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = productService.updateProductPublishStatus(publishStatus, ids);
        if (count > 0) {
            commontResult = CommontResult.success(ids);
            LOGGER.debug("updateProductPublishStatus success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateProductPublishStatus failed:ids={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("批量推荐商品")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateProductRecommendStatus(@RequestParam(name = "recommendStatus")
                                                      @ApiParam("recommendStatus") Integer recommendStatus,
                                                      @RequestParam(name = "ids")
                                                      @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = productService.updateProductRecommendStatus(recommendStatus, ids);
        if (count > 0) {
            commontResult = CommontResult.success(ids);
            LOGGER.debug("updateProductRecommendStatus success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateProductRecommendStatus failed:ids={}", ids);
        }
        return commontResult;
    }

    @ApiOperation("批量修改审核状态")
    @RequestMapping(value = "/update/verifyStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommontResult updateProductVerifyStatus(@RequestParam(name = "verifyStatus")
                                                   @ApiParam("verifyStatus") Integer verifyStatus,
                                                   @RequestParam(name = "ids")
                                                   @ApiParam("ids") Long... ids) {
        CommontResult commontResult;
        int count = productService.updateProductVerifyStatus(verifyStatus, ids);
        if (count > 0) {
            commontResult = CommontResult.success(ids);
            LOGGER.debug("updateProductVerifyStatus success:ids={}", ids);
        } else {
            commontResult = CommontResult.failed("操作失败");
            LOGGER.debug("updateProductVerifyStatus failed:ids={}", ids);
        }
        return commontResult;
    }
    @ApiOperation("根据商品id获取商品编辑信息")
    @RequestMapping(value = "/updateInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommontResult<PmsProductResult> updateInfo(@PathVariable("id")Long id){
        return CommontResult.success(productService.updateInfo(id));
    }

}
