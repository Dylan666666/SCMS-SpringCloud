package com.ljl.sale.mapper;

import com.ljl.sale.entity.RefundCustomer;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/27 22:05
 */
@FeignClient(name = "mapper-center")
@Service
public interface RefundCustomerMapper {

    /**
     * 添加退货联系表
     * 
     * @param refundCustomer
     * @return
     */
    @GetMapping("/refundCustomerMapper/insert")
    int insert(@RequestParam("refundCustomer") RefundCustomer refundCustomer);

    /**
     * 更新退货联系表
     *
     * @param refundCustomer
     * @return
     */
    @GetMapping("/refundCustomerMapper/update")
    int update(@RequestParam("refundCustomer") RefundCustomer refundCustomer);

    /**
     * 通过ID查询退货联系表
     *
     * @param refundCustomerId
     * @return
     */
    @GetMapping("/refundCustomerMapper/queryByRefundId")
    List<RefundCustomer> queryByRefundId(@RequestParam("refundCustomerId") String refundCustomerId);

    /**
     * 通过商品ID退货联系表
     *
     * @param refundCustomerId
     * @param refundCustomerStockGoodsId
     * @return
     */
    @GetMapping("/refundCustomerMapper/queryByDoubleId")
    RefundCustomer queryByDoubleId(@RequestParam("refundCustomerId") String refundCustomerId,
                                   @RequestParam("refundCustomerStockGoodsId") Long refundCustomerStockGoodsId);

    /**
     * 一键查询退货联系表
     *
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/refundCustomerMapper/queryAll")
    List<RefundCustomer> queryAll(@RequestParam("rowIndex") int rowIndex,
                                  @RequestParam("pageSize") int pageSize);
    
}
