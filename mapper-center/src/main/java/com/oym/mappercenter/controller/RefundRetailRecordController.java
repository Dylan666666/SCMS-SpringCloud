package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.RefundRetailRecord;
import com.oym.mappercenter.mapper.RefundRetailRecordMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 15:00
 */
@RestController()
@RequestMapping("/refundRetailRecordMapper")
public class RefundRetailRecordController {

    @Resource
    private RefundRetailRecordMapper refundRetailRecordMapper;
    
    @GetMapping("/insert")
    public int insert(RefundRetailRecord refundRetailRecord) {
        return refundRetailRecordMapper.insert(refundRetailRecord);
    }

    @GetMapping("/update")
    public int update(RefundRetailRecord refundRetailRecord) {
        return refundRetailRecordMapper.update(refundRetailRecord);
    }

    @GetMapping("/queryByRefundRetailId")
    public RefundRetailRecord queryByRefundRetailId(String refundRetailId) {
        return refundRetailRecordMapper.queryByRefundRetailId(refundRetailId);
    }

    @GetMapping("/queryAll")
    public List<RefundRetailRecord> queryAll(@Param("rowIndex") int rowIndex, 
                                             @Param("pageSize") int pageSize) {
        return refundRetailRecordMapper.queryAll(rowIndex, pageSize);
    }

    @GetMapping("/queryByCondition")
    public List<RefundRetailRecord> queryByCondition(
            @Param("refundRetailRecordCondition") RefundRetailRecord refundRetailRecordCondition,
            @Param("rowIndex") int rowIndex,
            @Param("pageSize") int pageSize) {
        return refundRetailRecordMapper
                .queryByCondition(refundRetailRecordCondition, rowIndex, pageSize);
    }
    
    
}
