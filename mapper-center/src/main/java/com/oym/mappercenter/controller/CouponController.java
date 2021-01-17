package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.Coupon;
import com.oym.mappercenter.mapper.CouponMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 10:28
 */
@RestController()
@RequestMapping("/couponMapper")
public class CouponController {
    
    @Resource
    private CouponMapper couponMapper;
    
    @GetMapping("/insert")
    public int insert(Coupon coupon) {
        return couponMapper.insert(coupon);
    }

    @GetMapping("/update")
    public int update(Coupon coupon) {
        return couponMapper.update(coupon);
    }

    @GetMapping("/queryByCouponId")
    public Coupon queryByCouponId(Long couponId) {
        return couponMapper.queryByCouponId(couponId);
    }

    @GetMapping("/queryByStaffId")
    public List<Coupon> queryByStaffId(int staffId) {
        return couponMapper.queryByStaffId(staffId);
    }

    @GetMapping("/queryAll")
    public List<Coupon> queryAll(@Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize) {
        return couponMapper.queryAll(rowIndex, pageSize);
    }

    @GetMapping("/queryByCondition")
    public List<Coupon> queryByCondition(@Param("couponCondition")Coupon couponCondition,
                                         @Param("rowIndex")int rowIndex,
                                         @Param("pageSize")int pageSize) {
        return couponMapper.queryByCondition(couponCondition, rowIndex, pageSize);
    }
    
    
}
