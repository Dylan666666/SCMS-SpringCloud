package com.ljl.warehouse.mapper;

import com.ljl.warehouse.entity.Stocktaking;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/26 15:31
 */
@FeignClient(name = "mapper-center")
@Service
public interface StocktakingMapper {
    /**
     * 添加盘点单
     *
     * @param stocktaking
     * @return
     */
    @GetMapping("/stocktakingMapper/insert")
    int insert(@RequestParam("stocktaking") Stocktaking stocktaking);

    /**
     * 更新盘点单信息
     *
     * @param stocktaking
     * @return
     */
    @GetMapping("/stocktakingMapper/update")
    int update(@RequestParam("stocktaking") Stocktaking stocktaking);

    /**
     * 通过ID查询盘点单
     * 
     * @param stocktakingId
     * @param stocktakingStockGoodsId
     * @return
     */
    @GetMapping("/stocktakingMapper/queryById")
    Stocktaking queryById(@RequestParam("stocktakingId") Long stocktakingId,
                          @RequestParam("stocktakingStockGoodsId") Long stocktakingStockGoodsId);

    /**
     * 一键查询盘点单 
     *
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/stocktakingMapper/queryAll")
    List<Stocktaking> queryAll(@RequestParam("rowIndex") int rowIndex,
                               @RequestParam("pageSize") int pageSize);

    /**
     * 模糊查询
     * 
     * @param stocktakingCondition
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/stocktakingMapper/queryByCondition")
    List<Stocktaking> queryByCondition(@RequestParam("stocktakingCondition") Stocktaking stocktakingCondition,
                                       @RequestParam("rowIndex") int rowIndex,
                                       @RequestParam("pageSize") int pageSize);

    /**
     * ID查询
     * 
     * @param stocktakingId
     * @return
     */
    @GetMapping("/stocktakingMapper/queryByStocktakingId")
    List<Stocktaking> queryByStocktakingId(@RequestParam("stocktakingId") Long stocktakingId);
}
