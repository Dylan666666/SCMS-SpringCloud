package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.Delivery;
import com.oym.mappercenter.mapper.DeliveryMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 10:56
 */
@RestController()
@RequestMapping("/deliveryMapper")
public class DeliveryController {
    
    @Resource
    private DeliveryMapper deliveryMapper;

    @GetMapping("/insert")
    public int insert(Delivery delivery) {
        return deliveryMapper.insert(delivery);
    }

    @GetMapping("/update")
    public int update(Delivery delivery) {
        return deliveryMapper.update(delivery);
    }

    @GetMapping("/queryByDeliveryId")
    public List<Delivery> queryByDeliveryId(String deliveryId) {
        return deliveryMapper.queryByDeliveryId(deliveryId);
    }

    @GetMapping("/queryByGoodsId")
    public Delivery queryByGoodsId(@Param("deliveryId") String deliveryId, @Param("goodsId") Long goodsId) {
        return deliveryMapper.queryByGoodsId(deliveryId, goodsId);
    }

    @GetMapping("/queryAll")
    public List<Delivery> queryAll(@Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize) {
        return deliveryMapper.queryAll(rowIndex, pageSize);
    }
}
