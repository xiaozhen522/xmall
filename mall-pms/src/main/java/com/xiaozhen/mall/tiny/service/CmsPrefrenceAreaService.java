package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.CmsPrefrenceArea;

import java.util.List;

/**
 * @description : 商品优选
 * @create time:21:34
 * @Author : XiaoZhen
 **/
public interface CmsPrefrenceAreaService {
    /**
     * 获取所有商品优选
     *
     * @return List
     */
    List<CmsPrefrenceArea> listAllPrefrenceArea();
}
