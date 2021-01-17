package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.RefundCustomerRecord;
import com.oym.mappercenter.mapper.RefundCustomerRecordMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 14:52
 */
@RestController()
@RequestMapping("/refundCustomerRecordMapper")
public class RefundCustomerRecordController {

    @Resource
    private RefundCustomerRecordMapper refundCustomerRecordMapper;

    @GetMapping("/insert")
    public int insert(RefundCustomerRecord refundCustomerRecord) {
        return refundCustomerRecordMapper.insert(refundCustomerRecord);
    }

    @GetMapping("/update")
    public int update(RefundCustomerRecord refundCustomerRecord) {
        return refundCustomerRecordMapper.update(refundCustomerRecord);
    }

    @GetMapping("/queryByRefundCustomerId")
    public RefundCustomerRecord queryByRefundCustomerId(String refundCustomerId) {
        return refundCustomerRecordMapper.queryByRefundCustomerId(refundCustomerId);
    }

    @GetMapping("/queryByOrderId")
    public RefundCustomerRecord queryByOrderId(String refundCustomerOrderId) {
        return refundCustomerRecordMapper.queryByOrderId(refundCustomerOrderId);
    }

    @GetMapping("/queryAll")
    public List<RefundCustomerRecord> queryAll(@Param("rowIndex") int rowIndex, 
                                               @Param("pageSize") int pageSize) {
        return refundCustomerRecordMapper.queryAll(rowIndex, pageSize);
    }

    @GetMapping("/queryByCondition")
    public List<RefundCustomerRecord> queryByCondition(
            @Param("refundCustomerRecordCondition") RefundCustomerRecord refundCustomerRecordCondition,
            @Param("rowIndex") int rowIndex,
            @Param("pageSize") int pageSize) {
        return refundCustomerRecordMapper
                .queryByCondition(refundCustomerRecordCondition, rowIndex, pageSize);
    }
    
}
