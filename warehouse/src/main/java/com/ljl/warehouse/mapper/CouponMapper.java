package com.ljl.warehouse.mapper;

import com.ljl.warehouse.entity.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/18 16:35
 */
@FeignClient(name = "mapper-center")
@Service
public interface CouponMapper {
    /**
     * 添加订货单
     * 
     * @param coupon
     * @return
     */
    @GetMapping("/couponMapper/insert")
    int insert(@RequestParam("coupon") Coupon coupon);

    /**
     * 更新订货单信息
     *
     * @param coupon
     * @return
     */
    @GetMapping("/couponMapper/update")
    int update(@RequestParam("coupon") Coupon coupon);

    /**
     * 通过ID查询订货单
     * 
     * @param couponId
     * @return
     */
    @GetMapping("/couponMapper/queryByCouponId")
    Coupon queryByCouponId(@RequestParam("couponId") Long couponId);

    /**
     * 通过发起职工ID查询订货单
     *
     * @param staffId
     * @return
     */
    @GetMapping("/couponMapper/queryByStaffId")
    List<Coupon> queryByStaffId(@RequestParam("staffId") int staffId);

    /**
     * 一键查询
     * 
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/couponMapper/queryAll")
    List<Coupon> queryAll(@RequestParam("rowIndex") int rowIndex,
                          @RequestParam("pageSize") int pageSize);

    /**
     * 订货单模糊查询
     *
     * @param couponCondition
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/couponMapper/queryByCondition")
    List<Coupon> queryByCondition(@RequestParam("couponCondition") Coupon couponCondition,
                                  @RequestParam("rowIndex") int rowIndex,
                                  @RequestParam("pageSize") int pageSize);
}
