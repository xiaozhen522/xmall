package com.xiaozhen.mall.tiny.nosql.mongodb.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @description : 用户商品浏览历史记录
 * @create time:2021/10/26
 * @Author : XiaoZhen
 **/
@Data
@Document("MemberReadHistory")
public class MemberReadHistory {
    @Id
    private String id;
    @Indexed
    private Long memberId;
    private String memberNickname;
    private String memberIcon;
    @Indexed
    private Long productId;
    private String productName;
    private String productPic;
    private String productPrice;
    private Date createTime;
}
