package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.dto.OmsUpdateStatusParam;
import com.xiaozhen.mall.tiny.mbg.model.OmsOrderReturnApply;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 订单退货申请
 * @create time:10:45
 * @Author : XiaoZhen
 **/
public interface OmsOrderReturnApplyService {
    /**
     * 获取指定的订单退货申请
     *
     * @param id 订单退货申请id
     * @return 订单退货申请对象
     */
    OmsOrderReturnApply getById(Long id);

    /**
     * 批量删除订单退货申请
     *
     * @param ids 订单退货申请id列表
     * @return 删除行数
     */
    @Transactional
    int delete(Long[] ids);

    /**
     * 根据条件分页查询订单退货申请
     *
     * @param createTime      创建书简
     * @param handleMan       处理人员
     * @param handleTime      处理时间
     * @param id              订单退货申请id
     * @param pageNum         页码
     * @param pageSize        每页数量
     * @param receiverKeyword 收获人姓名/号码
     * @param ststus          订单退货申请状态
     * @return List
     */
    List<OmsOrderReturnApply> list(String createTime, String handleMan, String handleTime, Long id, Integer pageNum, Integer pageSize, String receiverKeyword, Integer ststus);

    /**
     * 更新指定的订单退货申请
     *
     * @param id          订单退货申请id
     * @param statusParam 订单状态对象
     * @return 更新行数
     */
    @Transactional
    int updateStatusById(Long id, OmsUpdateStatusParam statusParam);

}
