package com.ljl.warehouse.mapper;

import com.ljl.warehouse.entity.DeliveryRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/23 22:10
 */
@FeignClient(name = "mapper-center")
@Service
public interface DeliveryRecordMapper {
    /**
     * 添加出库详情单
     *
     * @param deliveryRecord
     * @return
     */
    @GetMapping("/deliveryRecordMapper/insert")
    int insert(@RequestParam("deliveryRecord") DeliveryRecord deliveryRecord);

    /**
     * 更新出库详情单
     *
     * @param deliveryRecord
     * @return
     */
    @GetMapping("/deliveryRecordMapper/update")
    int update(@RequestParam("deliveryRecord") DeliveryRecord deliveryRecord);

    /**
     * 通过ID查询出库详情单
     *
     * @param deliveryId
     * @return
     */
    @GetMapping("/deliveryRecordMapper/queryByDeliveryId")
    DeliveryRecord queryByDeliveryId(@RequestParam("deliveryId") String deliveryId);

    /**
     * 一键查询出库详情单
     *
     * @param rowIndex
     * @param pageSize 
     * @return
     */
    @GetMapping("/deliveryRecordMapper/queryAll")
    List<DeliveryRecord> queryAll(@RequestParam("rowIndex") int rowIndex,
                                  @RequestParam("pageSize") int pageSize);

    /**
     * 模糊查询出库详情单
     * 
     * @param deliveryRecordCondition
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/deliveryRecordMapper/queryByCondition")
    List<DeliveryRecord> queryByCondition(@RequestParam("deliveryRecordCondition") DeliveryRecord deliveryRecordCondition,
                                          @RequestParam("rowIndex") int rowIndex,
                                          @RequestParam("pageSize") int pageSize);
}
