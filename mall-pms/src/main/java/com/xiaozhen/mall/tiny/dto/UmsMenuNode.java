package com.xiaozhen.mall.tiny.dto;

import com.xiaozhen.mall.tiny.mbg.model.UmsMenu;

import java.util.List;

/**
 * @description :
 * @create time:2021/10/26
 * @Author : XiaoZhen
 **/
public class UmsMenuNode extends UmsMenu {
    List<UmsMenuNode> children;

    public List<UmsMenuNode> getChildren() {
        return children;
    }

    public void setChildren(List<UmsMenuNode> children) {
        this.children = children;
    }
}
