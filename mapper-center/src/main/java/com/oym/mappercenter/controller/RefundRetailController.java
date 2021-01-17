package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.RefundRetail;
import com.oym.mappercenter.mapper.RefundRetailMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 14:56
 */
@RestController()
@RequestMapping("/refundRetailMapper")
public class RefundRetailController {
    
    @Resource
    private RefundRetailMapper refundRetailMapper;

    @GetMapping("/insert")
    public int insert(RefundRetail refundRetail) {
        return refundRetailMapper.insert(refundRetail);
    }

    @GetMapping("/update")
    public int update(RefundRetail refundRetail) {
        return refundRetailMapper.update(refundRetail);
    }

    @GetMapping("/queryByRefundRetailId")
    public List<RefundRetail> queryByRefundRetailId(String refundRetailId) {
        return refundRetailMapper.queryByRefundRetailId(refundRetailId);
    }

    @GetMapping("/queryByStockGoodsId")
    public List<RefundRetail> queryByStockGoodsId(Long retailStockGoodsId) {
        return refundRetailMapper.queryByStockGoodsId(retailStockGoodsId);
    }

    @GetMapping("/queryByRefundCustomerId")
    public List<RefundRetail> queryByRefundCustomerId(String refundCustomerId) {
        return refundRetailMapper.queryByRefundCustomerId(refundCustomerId);
    }

    @GetMapping("/queryByTribeId")
    public RefundRetail queryByTribeId(@Param("refundRetailId") String refundRetailId,
                                       @Param("retailStockGoodsId") Long retailStockGoodsId,
                                       @Param("refundCustomerId") String refundCustomerId) {
        return refundRetailMapper.queryByTribeId(refundRetailId, retailStockGoodsId, refundCustomerId);
    }

    @GetMapping("/queryAll")
    public List<RefundRetail> queryAll(@Param("rowIndex") int rowIndex, 
                                       @Param("pageSize") int pageSize) {
        return refundRetailMapper.queryAll(rowIndex, pageSize);
    }
    
    
}
