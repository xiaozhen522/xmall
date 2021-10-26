package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.common.api.CommontResult;

/**
 * @description :
 * @create time:2021/10/26
 * @Author : XiaoZhen
 **/
public interface UmsMerberService {
    CommontResult generateAuthCode(String telephone);

    CommontResult verifyAuthCode(String telephone, String authCode);
}
