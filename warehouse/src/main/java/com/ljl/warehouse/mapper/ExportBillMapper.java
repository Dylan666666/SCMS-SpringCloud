package com.ljl.warehouse.mapper;

import com.ljl.warehouse.entity.ExportBill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/18 19:09
 */
@FeignClient(name = "mapper-center")
@Service
public interface ExportBillMapper {
    /**
     * 生成入库单
     * 
     * @param exportBill
     * @return
     */
    @GetMapping("/exportBillMapper/insert")
    int insert(@RequestParam("exportBill") ExportBill exportBill);

    /**
     * 更新入库单信息
     * 
     * @param exportBill
     * @return
     */
    @GetMapping("/exportBillMapper/update")
    int update(@RequestParam("exportBill") ExportBill exportBill);

    /**
     * 通过入库单ID查询入库单
     * 
     * @param id
     * @return
     */
    @GetMapping("/exportBillMapper/queryByBillId")
    ExportBill queryByBillId(@RequestParam("id") String id);

    /**
     * 通过订货单ID查询入库单
     *
     * @param couponId
     * @return
     */
    @GetMapping("/exportBillMapper/queryByCouponId")
    ExportBill queryByCouponId(@RequestParam("couponId") Long couponId);

    /**
     * 通过入库单状态查询入库单集合
     *
     * @param exportBillStatus
     * @return
     */
    @GetMapping("/exportBillMapper/queryByBillStatus")
    List<ExportBill> queryByBillStatus(@RequestParam("exportBillStatus") int exportBillStatus);

    /**
     * 一键查询入库单
     * 
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/exportBillMapper/queryAll")
    List<ExportBill> queryAll(@RequestParam("rowIndex") int rowIndex,
                              @RequestParam("pageSize") int pageSize);

    /**
     * 模糊查询入库单
     * 
     * @param exportBillCondition
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/exportBillMapper/queryByCondition")
    List<ExportBill> queryByCondition(@RequestParam("exportBillCondition") ExportBill exportBillCondition,
                                      @RequestParam("rowIndex") int rowIndex,
                                      @RequestParam("pageSize") int pageSize);
}
