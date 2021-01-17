package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.ExportBill;
import com.oym.mappercenter.mapper.ExportBillMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 11:03
 */
@RestController()
@RequestMapping("/exportBillMapper")
public class ExportBillController {
    
    @Resource
    private ExportBillMapper exportBillMapper;

    @GetMapping("/insert")
    public int insert(ExportBill exportBill) {
        return exportBillMapper.insert(exportBill);
    }

    @GetMapping("/update")
    public int update(ExportBill exportBill) {
        return exportBillMapper.update(exportBill);
    }

    @GetMapping("/queryByBillId")
    public ExportBill queryByBillId(String id) {
        return exportBillMapper.queryByBillId(id);
    }

    @GetMapping("/queryByCouponId")
    public ExportBill queryByCouponId(Long couponId) {
        return exportBillMapper.queryByCouponId(couponId);
    }

    @GetMapping("/queryByBillStatus")
    public List<ExportBill> queryByBillStatus(int exportBillStatus) {
        return exportBillMapper.queryByBillStatus(exportBillStatus);
    }

    @GetMapping("/queryAll")
    public List<ExportBill> queryAll(@Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize) {
        return exportBillMapper.queryAll(rowIndex, pageSize);
    }

    @GetMapping("/queryByCondition")
    public List<ExportBill> queryByCondition(@Param("exportBillCondition") ExportBill exportBillCondition,
                                             @Param("rowIndex") int rowIndex,
                                             @Param("pageSize") int pageSize) {
        return exportBillMapper.queryByCondition(exportBillCondition, rowIndex, pageSize);
    }
    
}
