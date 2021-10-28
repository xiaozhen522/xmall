package com.xiaozhen.mall.tiny.dto;

import com.xiaozhen.mall.tiny.mbg.model.UmsMenu;
import lombok.Data;

import java.util.List;

/**
 * @description :
 * @create time:2021/10/26
 * @Author : XiaoZhen
 **/
@Data
public class UmsMenuNode extends UmsMenu {
    List<UmsMenuNode> children;
}
