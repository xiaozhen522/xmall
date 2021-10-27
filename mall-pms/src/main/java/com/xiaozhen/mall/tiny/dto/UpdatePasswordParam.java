package com.xiaozhen.mall.tiny.dto;

/**
 * @description :
 * @create time:2021/10/25
 * @Author : XiaoZhen
 **/
public class UpdatePasswordParam {
    private String newPassword;
    private String oldPassword;
    private String username;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
