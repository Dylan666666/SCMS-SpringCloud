package com.ljl.sale.mapper;

import com.ljl.sale.entity.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/18 21:14
 */
@FeignClient(name = "mapper-center")
@Service
public interface StockMapper {

    /**
     * 添加库存
     * 
     * @param stock
     * @return
     */
    @GetMapping("/stockMapper/insert")
    int insert(@RequestParam("stock") Stock stock);

    /**
     * 更新库存
     * 
     * @param stock
     * @return
     */
    @GetMapping("/stockMapper/update")
    int update(@RequestParam("stock") Stock stock);

    /**
     * 通过产品编号查库存表
     * 
     * @param goodsStockId
     * @return
     */
    @GetMapping("/stockMapper/queryByGoodsId")
    List<Stock> queryByGoodsId(@RequestParam("goodsStockId") Long goodsStockId);

    /**
     * 通过产品编号查库存表
     *
     * @param stockGoodsId
     * @return
     */
    @GetMapping("/stockMapper/queryById")
    Stock queryById(@RequestParam("stockGoodsId") Long stockGoodsId);

    /**
     * 通过入库编号查询
     * 
     * @param stockExportBillId
     * @return
     */
    @GetMapping("/stockMapper/queryByExportBillId")
    Stock queryByExportBillId(@RequestParam("stockExportBillId") String stockExportBillId);

    /**
     * 模糊查询
     * 
     * @param stockCondition
     * @return
     */
    @GetMapping("/stockMapper/queryByCondition")
    List<Stock> queryByCondition(@RequestParam("stockCondition") Stock stockCondition);

    /**
     * 一键查询
     * 
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/stockMapper/queryAll")
    List<Stock> queryAll(@RequestParam("rowIndex") int rowIndex,
                         @RequestParam("pageSize") int pageSize);
}
