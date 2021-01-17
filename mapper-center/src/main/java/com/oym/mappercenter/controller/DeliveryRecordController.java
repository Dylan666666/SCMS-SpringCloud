package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.DeliveryRecord;
import com.oym.mappercenter.mapper.DeliveryRecordMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 10:59
 */
@RestController()
@RequestMapping("/deliveryRecordMapper")
public class DeliveryRecordController {
    
    @Resource
    private DeliveryRecordMapper deliveryRecordMapper;

    @GetMapping("/insert")
    public int insert(DeliveryRecord deliveryRecord) {
        return deliveryRecordMapper.insert(deliveryRecord);
    }

    @GetMapping("/update")
    public int update(DeliveryRecord deliveryRecord) {
        return deliveryRecordMapper.update(deliveryRecord);
    }

    @GetMapping("/queryByDeliveryId")
    public DeliveryRecord queryByDeliveryId(String deliveryId) {
        return deliveryRecordMapper.queryByDeliveryId(deliveryId);
    }

    @GetMapping("/queryAll")
    public List<DeliveryRecord> queryAll(@Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize) {
        return deliveryRecordMapper.queryAll(rowIndex, pageSize);
    }

    @GetMapping("/queryByCondition")
    public List<DeliveryRecord> queryByCondition(@Param("deliveryRecordCondition") DeliveryRecord deliveryRecordCondition,
                                                 @Param("rowIndex") int rowIndex,
                                                 @Param("pageSize") int pageSize) {
        return deliveryRecordMapper.queryByCondition(deliveryRecordCondition, rowIndex, pageSize);
    }
    
}
