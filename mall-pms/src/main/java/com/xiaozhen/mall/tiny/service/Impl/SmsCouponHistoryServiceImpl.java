package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.mbg.mapper.SmsCouponHistoryMapper;
import com.xiaozhen.mall.tiny.mbg.model.SmsCouponHistory;
import com.xiaozhen.mall.tiny.mbg.model.SmsCouponHistoryExample;
import com.xiaozhen.mall.tiny.service.SmsCouponHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description : 优惠券领取记录SmsCouponHistoryService实现类
 * @create time:17:40
 * @Author : XiaoZhen
 **/
@Service
public class SmsCouponHistoryServiceImpl implements SmsCouponHistoryService {
    @Autowired
    private SmsCouponHistoryMapper couponHistoryMapper;

    @Override
    public List<SmsCouponHistory> list(Long couponId, String orderSn, Integer pageNum, Integer pageSize, Integer useStatus) {
        SmsCouponHistoryExample example = new SmsCouponHistoryExample();
        SmsCouponHistoryExample.Criteria criteria = example.createCriteria();
        if (couponId != null) {
            criteria.andCouponIdEqualTo(couponId);
        }
        if (orderSn != null) {
            criteria.andOrderSnLike("%" + orderSn + "%");
        }
        if (useStatus != null) {
            criteria.andUseStatusEqualTo(useStatus);
        }
        PageHelper.startPage(pageNum, pageSize);
        return couponHistoryMapper.selectByExample(example);
    }
}
