package com.xiaozhen.mall.tiny.service.Impl;

import com.xiaozhen.mall.tiny.mbg.mapper.UmsMemberLevelMapper;
import com.xiaozhen.mall.tiny.mbg.model.UmsMemberLevel;
import com.xiaozhen.mall.tiny.mbg.model.UmsMemberLevelExample;
import com.xiaozhen.mall.tiny.service.UmsMemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 会员等级UmsMemberLevelService实现类
 * @create time:23:28
 * @Author: XiaoZhen
 **/
@Service
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService {
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;


    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {
        UmsMemberLevelExample example = new UmsMemberLevelExample();
        if (defaultStatus != null) {
            example.createCriteria().andDefaultStatusEqualTo(defaultStatus);
        }
        return memberLevelMapper.selectByExample(example);
    }

}
