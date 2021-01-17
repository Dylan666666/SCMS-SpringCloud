package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.Stock;
import com.oym.mappercenter.mapper.StockMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 16:16
 */
@RequestMapping("/stockMapper")
@RestController()
public class StockController {
    
    @Resource
    private StockMapper stockMapper;

    @GetMapping("/insert")
    public int insert(Stock stock) {
        return stockMapper.insert(stock);
    }

    @GetMapping("/update")
    public int update(Stock stock) {
        return stockMapper.update(stock);
    }

    @GetMapping("/queryByGoodsId")
    public List<Stock> queryByGoodsId(Long goodsStockId) {
        return stockMapper.queryByGoodsId(goodsStockId);
    }

    @GetMapping("/queryById")
    public Stock queryById(Long stockGoodsId) {
        return stockMapper.queryById(stockGoodsId);
    }

    @GetMapping("/queryByExportBillId")
    public Stock queryByExportBillId(String stockExportBillId) {
        return stockMapper.queryByExportBillId(stockExportBillId);
    }

    @GetMapping("/queryByCondition")
    public List<Stock> queryByCondition(Stock stockCondition){
        return stockMapper.queryByCondition(stockCondition);
    }

    @GetMapping("/queryAll")
    public List<Stock> queryAll(@Param("rowIndex")int rowIndex,
                                @Param("pageSize")int pageSize) { 
        return stockMapper.queryAll(rowIndex, pageSize);
    }
    
}
