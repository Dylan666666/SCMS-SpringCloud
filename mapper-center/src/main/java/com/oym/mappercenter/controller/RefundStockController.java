package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.RefundStock;
import com.oym.mappercenter.mapper.RefundStockMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 15:06
 */
@RequestMapping("/refundStockMapper")
public class RefundStockController {

    @Resource
    private RefundStockMapper refundStockMapper;

    @GetMapping("/insert")
    public int insert(RefundStock refundStock) {
        return refundStockMapper.insert(refundStock);
    }

    @GetMapping("/update")
    public int update(RefundStock refundStock) {
        return refundStockMapper.update(refundStock);
    }

    @GetMapping("/queryByDoubleId")
    public RefundStock queryByDoubleId(@Param("refundCustomerId") String refundCustomerId,
                                       @Param("refundCustomerStockGoodsId") Long refundCustomerStockGoodsId) {
        return refundStockMapper.queryByDoubleId(refundCustomerId, refundCustomerStockGoodsId);
    }

    @GetMapping("/queryByRefundCustomerId")
    public List<RefundStock> queryByRefundCustomerId(String refundCustomerId) {
        return refundStockMapper.queryByRefundCustomerId(refundCustomerId);
    }

    @GetMapping("/queryByRefundCustomerStockGoodsId")
    public List<RefundStock> queryByRefundCustomerStockGoodsId(Long refundCustomerStockGoodsId) {
        return refundStockMapper.queryByRefundCustomerStockGoodsId(refundCustomerStockGoodsId);
    }

    @GetMapping("/queryByCondition")
    public List<RefundStock> queryByCondition(@Param("refundStockCondition")RefundStock refundStockCondition,
                                              @Param("rowIndex")int rowIndex,
                                              @Param("pageSize")int pageSize) {
        return refundStockMapper.queryByCondition(refundStockCondition, rowIndex, pageSize);
    }

    @GetMapping("/queryAll")
    public List<RefundStock> queryAll(@Param("rowIndex")int rowIndex,
                                      @Param("pageSize")int pageSize) {
        return refundStockMapper.queryAll(rowIndex, pageSize);
    }
    
}
