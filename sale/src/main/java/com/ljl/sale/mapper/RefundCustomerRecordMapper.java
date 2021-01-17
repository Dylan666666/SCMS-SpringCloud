package com.ljl.sale.mapper;

import com.ljl.sale.entity.RefundCustomerRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/28 13:17
 */
@FeignClient(name = "mapper-center")
@Service
public interface RefundCustomerRecordMapper {
    /**
     * 添加退货记录表
     *
     * @param refundCustomerRecord
     * @return
     */
    @GetMapping("/refundCustomerRecordMapper/insert")
    int insert(@RequestParam("refundCustomerRecord") RefundCustomerRecord refundCustomerRecord);

    /**
     * 更新退货记录表
     *
     * @param refundCustomerRecord
     * @return
     */
    @GetMapping("/refundCustomerRecordMapper/update")
    int update(@RequestParam("refundCustomerRecord") RefundCustomerRecord refundCustomerRecord);

    /**
     * 通过ID查询退货记录表
     *
     * @param refundCustomerId
     * @return
     */
    @GetMapping("/refundCustomerRecordMapper/queryByRefundCustomerId")
    RefundCustomerRecord queryByRefundCustomerId(@RequestParam("refundCustomerId") String refundCustomerId);

    /**
     * 通过ID查询退货记录表
     *
     * @param refundCustomerOrderId
     * @return
     */
    @GetMapping("/refundCustomerRecordMapper/queryByOrderId")
    RefundCustomerRecord queryByOrderId(@RequestParam("refundCustomerOrderId") String refundCustomerOrderId);

    /**
     * 一键查询退货记录表
     *
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/refundCustomerRecordMapper/queryAll")
    List<RefundCustomerRecord> queryAll(@RequestParam("rowIndex") int rowIndex,
                                        @RequestParam("pageSize") int pageSize);

    /**
     * 模糊查询退货记录表
     *
     * @param refundCustomerRecordCondition
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/refundCustomerRecordMapper/queryByCondition")
    List<RefundCustomerRecord> queryByCondition(
            @RequestParam("refundCustomerRecordCondition") RefundCustomerRecord refundCustomerRecordCondition,
            @RequestParam("rowIndex") int rowIndex,
            @RequestParam("pageSize") int pageSize);
}
