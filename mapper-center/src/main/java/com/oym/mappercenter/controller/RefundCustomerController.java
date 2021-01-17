package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.RefundCustomer;
import com.oym.mappercenter.mapper.RefundCustomerMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 14:49
 */
@RestController()
@RequestMapping("/refundCustomerMapper")
public class RefundCustomerController {
    
    @Resource
    private RefundCustomerMapper refundCustomerMapper;

    @GetMapping("/insert")
    public int insert(RefundCustomer refundCustomer) {
        return refundCustomerMapper.insert(refundCustomer);
    }

    @GetMapping("/update")
    public int update(RefundCustomer refundCustomer) {
        return refundCustomerMapper.update(refundCustomer);
    }

    @GetMapping("/queryByRefundId")
    public List<RefundCustomer> queryByRefundId(String refundCustomerId) {
        return refundCustomerMapper.queryByRefundId(refundCustomerId);
    }

    @GetMapping("/queryByDoubleId")
    public RefundCustomer queryByDoubleId(@Param("refundCustomerId") String refundCustomerId,
                                          @Param("refundCustomerStockGoodsId") Long refundCustomerStockGoodsId) {
        return refundCustomerMapper.queryByDoubleId(refundCustomerId, refundCustomerStockGoodsId);
    }

    @GetMapping("/queryAll")
    public List<RefundCustomer> queryAll(@Param("rowIndex") int rowIndex, 
                                         @Param("pageSize") int pageSize) {
        return refundCustomerMapper.queryAll(rowIndex, pageSize);
    }
    
}
