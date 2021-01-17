package com.ljl.warehouse.mapper;

import com.ljl.warehouse.entity.Retail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/25 10:45
 */
@FeignClient(name = "mapper-center")
@Service
public interface RetailMapper {
    /**
     * 添加订货单
     *
     * @param retail
     * @return
     */
    @GetMapping("/retailMapper/insert")
    int insert(@RequestParam("retail") Retail retail);

    /**
     * 更新订货单
     *
     * @param retail
     * @return
     */
    @GetMapping("/retailMapper/update")
    int update(@RequestParam("retail") Retail retail);

    /**
     * 通过ID查询订货单
     *
     * @param retailId
     * @return
     */
    @GetMapping("/retailMapper/queryByRetailId")
    List<Retail> queryByRetailId(@RequestParam("retailId") String retailId);

    /**
     * 通过两个主键查询订货单
     *
     * @param retailId
     * @param retailStockGoodsId
     * @return
     */
    @GetMapping("/retailMapper/queryByGoodsId")
    Retail queryByGoodsId(@RequestParam("retailId") String retailId,
                          @RequestParam("retailStockGoodsId") Long retailStockGoodsId);

    /**
     * 一键查询订货单
     *
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/retailMapper/queryAll")
    List<Retail> queryAll(@RequestParam("rowIndex") int rowIndex,
                          @RequestParam("pageSize") int pageSize);
}
