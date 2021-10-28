package com.xiaozhen.mall.tiny.service;

import com.xiaozhen.mall.tiny.mbg.model.OmsOrderReturnReason;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description : 退货原因
 * @create time:20:56
 * @Author : XiaoZhen
 **/
public interface OmsOrderReturnReasonService {

    /**
     * 获取指定id的退货原因
     *
     * @param id 退货原因id
     * @return 退货原因对象
     */
    OmsOrderReturnReason getById(Long id);

    /**
     * 新建退货原因
     *
     * @param returnReason 退货原因对象
     * @return 创建行数
     */
    @Transactional
    int create(OmsOrderReturnReason returnReason);

    /**
     * 批量删除退货原因
     *
     * @param ids 退货原因id列表
     * @return 删除行数
     */
    @Transactional
    int delete(Long[] ids);

    /**
     * 更新指定的退货原因
     *
     * @param id           退货原因id
     * @param returnReason 新的退货原因对象
     * @return 更新行数
     */
    @Transactional
    int updateById(Long id, OmsOrderReturnReason returnReason);

    /**
     * 分页查询退货原因
     *
     * @param pageNum  页码
     * @param pageSize 每页数量
     * @return List
     */
    List<OmsOrderReturnReason> list(Integer pageNum, Integer pageSize);

    /**
     * 批量更新退货原因状态
     *
     * @param ids    退货原因id列表
     * @param status 退货原因状态
     * @return 更新行数
     */
    @Transactional
    int updateStatus(Long[] ids, Integer status);
}
