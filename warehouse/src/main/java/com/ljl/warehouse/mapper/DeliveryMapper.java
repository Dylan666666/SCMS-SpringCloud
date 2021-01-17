package com.ljl.warehouse.mapper;

import com.ljl.warehouse.entity.Delivery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/23 21:07
 */
@FeignClient(name = "mapper-center")
@Service
public interface DeliveryMapper {
    /**
     * 添加出库单
     *
     * @param delivery
     * @return
     */
    @GetMapping("/deliveryMapper/insert")
    int insert(@RequestParam("delivery") Delivery delivery);

    /**
     * 更新出库单信息
     *
     * @param delivery
     * @return
     */
    @GetMapping("/deliveryMapper/update")
    int update(@RequestParam("delivery") Delivery delivery);

    /**
     * 通过ID查询出库单
     *
     * @param deliveryId
     * @return
     */
    @GetMapping("/deliveryMapper/queryByDeliveryId")
    List<Delivery> queryByDeliveryId(@RequestParam("deliveryId") String deliveryId);

    /**
     * 通过商品ID查询出库单
     * 
     * @param deliveryId
     * @param goodsId
     * @return
     */
    @GetMapping("/deliveryMapper/queryByGoodsId")
    Delivery queryByGoodsId(@RequestParam("deliveryId") String deliveryId,
                            @RequestParam("goodsId") Long goodsId);
    
    /**
     * 一键查询出库单
     *
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/deliveryMapper/queryAll")
    List<Delivery> queryAll(@RequestParam("rowIndex") int rowIndex,
                            @RequestParam("pageSize") int pageSize);
}
