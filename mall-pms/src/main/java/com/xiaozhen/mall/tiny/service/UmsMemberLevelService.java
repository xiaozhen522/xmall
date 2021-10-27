package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.UmsMemberLevel;

import java.util.List;

/**
 * @description: 会员等级
 * @create time:23:28
 * @Author: XiaoZhen
 **/
public interface UmsMemberLevelService {
    List<UmsMemberLevel> list(Integer defaultStatus);
}
