package com.xiaozhen.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description: Mybatis配置文件
 * @create time:2021/10/16
 * @Author: XiaoZhen
 **/
@Configuration
@MapperScan("com.xiaozhen.mall.tiny.mbg.mapper")
public class MybatisConfig {
}
