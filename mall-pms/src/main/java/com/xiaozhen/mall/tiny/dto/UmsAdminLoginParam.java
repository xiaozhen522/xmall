package com.xiaozhen.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @description :
 * @create time:2021/10/25
 * @Author : XiaoZhen
 **/
public class UmsAdminLoginParam {
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("用户名")
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
