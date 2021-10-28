package com.xiaozhen.mall.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaozhen.mall.tiny.common.utils.MyUtils;
import com.xiaozhen.mall.tiny.dao.SmsCouponParmDao;
import com.xiaozhen.mall.tiny.dto.SmsCouponParm;
import com.xiaozhen.mall.tiny.mbg.mapper.SmsCouponMapper;
import com.xiaozhen.mall.tiny.mbg.mapper.SmsCouponProductCategoryRelationMapper;
import com.xiaozhen.mall.tiny.mbg.mapper.SmsCouponProductRelationMapper;
import com.xiaozhen.mall.tiny.mbg.model.*;
import com.xiaozhen.mall.tiny.service.SmsCouponService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description : 优惠券SmsCouponService实现类
 * @create time:22:21
 * @Author : XiaoZhen
 **/
@Service
public class SmsCouponServiceImpl implements SmsCouponService {
    @Autowired
    private SmsCouponMapper couponMapper;
    @Autowired
    private SmsCouponParmDao couponParmDao;
    @Autowired
    private SmsCouponProductCategoryRelationMapper cpcrMapper;
    @Autowired
    private SmsCouponProductRelationMapper cprMapper;

    @Override
    public SmsCouponParm getById(Long id) {
        return couponParmDao.getById(id);
    }

    @Override
    public int create(SmsCouponParm couponParm) {
        int rows = 0;
        // 创建优惠券绑定的商品
        List<SmsCouponProductRelation> prList = couponParm.getCouponProductRelationList();
        for (SmsCouponProductRelation cpr : prList) {
            rows += cprMapper.insertSelective(cpr);
        }
        // 创建优惠券绑定的商品分类
        List<SmsCouponProductCategoryRelation> pcrList = couponParm.getCouponProductCategoryRelationList();
        for (SmsCouponProductCategoryRelation cpcr : pcrList) {
            rows += cpcrMapper.insertSelective(cpcr);
        }
        SmsCoupon coupon = new SmsCoupon();
        BeanUtils.copyProperties(couponParm, coupon);
        rows += couponMapper.insertSelective(coupon);
        return rows;
    }

    @Override
    public int deleteById(Long id) {
        int rows = 0;
        // 创建优惠券绑定的商品分类
        SmsCouponProductCategoryRelationExample cpcrExample = new SmsCouponProductCategoryRelationExample();
        cpcrExample.createCriteria().andCouponIdEqualTo(id);
        rows += cpcrMapper.deleteByExample(cpcrExample);
        // 创建优惠券绑定的商品
        SmsCouponProductRelationExample cprExample = new SmsCouponProductRelationExample();
        cprExample.createCriteria().andCouponIdEqualTo(id);
        rows += cprMapper.deleteByExample(cprExample);
        rows += couponMapper.deleteByPrimaryKey(id);
        return rows;
    }

    @Override
    public List<SmsCoupon> list(String name, Integer pageNum, Integer pageSize, Integer type) {
        SmsCouponExample example = new SmsCouponExample();
        SmsCouponExample.Criteria criteria = example.createCriteria();
        if (name != null) {
            criteria.andNameLike("%" + name + "%");
        }
        if (type != null) {
            criteria.andTypeEqualTo(type);
        }
        PageHelper.startPage(pageNum, pageSize);
        return couponMapper.selectByExample(example);
    }

    @Override
    public int updateById(Long id, SmsCouponParm couponParm) {
        int rows = 0;
        // 创建优惠券绑定的商品分类
        List<SmsCouponProductCategoryRelation> pcrList = couponParm.getCouponProductCategoryRelationList();
        for (SmsCouponProductCategoryRelation cpcr : pcrList) {
            rows += cpcrMapper.updateByPrimaryKeySelective(cpcr);
        }
        // 创建优惠券绑定的商品
        List<SmsCouponProductRelation> prList = couponParm.getCouponProductRelationList();
        for (SmsCouponProductRelation cpr : prList) {
            rows += cprMapper.updateByPrimaryKeySelective(cpr);
        }
        SmsCoupon coupon = new SmsCoupon();
        MyUtils.cast(couponParm, coupon);
        rows += couponMapper.updateByPrimaryKey(coupon);
        return rows;
    }

}
