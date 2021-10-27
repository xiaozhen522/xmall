package com.xiaozhen.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description 提交品牌参数表单
 * @create time:2021/10/17
 * @Author : XiaoZhen
 **/
@Data
public class PmsBrandParm {
    private String name;
    @ApiModelProperty(value = "首字母")
    private String firstLetter;
    private Integer sort;
    @ApiModelProperty(value = "是否为品牌制造商：0->不是；1->是")
    private Integer factoryStatus;
    private Integer showStatus;
    @ApiModelProperty(value = "品牌logo")
    private String logo;
    @ApiModelProperty(value = "专区大图")
    private String bigPic;
    @ApiModelProperty(value = "品牌故事")
    private String brandStory;
}
