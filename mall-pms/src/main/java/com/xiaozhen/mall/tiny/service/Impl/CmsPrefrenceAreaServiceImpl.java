package com.xiaozhen.mall.tiny.service.Impl;

import com.xiaozhen.mall.tiny.mbg.mapper.CmsPrefrenceAreaMapper;
import com.xiaozhen.mall.tiny.mbg.model.CmsPrefrenceArea;
import com.xiaozhen.mall.tiny.mbg.model.CmsPrefrenceAreaExample;
import com.xiaozhen.mall.tiny.service.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description : 商品优选CmsPrefrenceAreaService实现类
 * @create time:21:34
 * @Author : XiaoZhen
 **/
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
