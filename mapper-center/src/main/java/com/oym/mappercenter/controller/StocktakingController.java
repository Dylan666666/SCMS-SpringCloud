package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.Stocktaking;
import com.oym.mappercenter.mapper.StocktakingMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 16:19
 */
@RestController()
@RequestMapping("/stocktakingMapper")
public class StocktakingController {
    
    @Resource
    private StocktakingMapper stocktakingMapper;

    @GetMapping("/insert")
    public int insert(Stocktaking stocktaking) {
        return stocktakingMapper.insert(stocktaking);
    }

    @GetMapping("/update")
    public int update(Stocktaking stocktaking) {
        return stocktakingMapper.update(stocktaking);
    }

    @GetMapping("/queryById")
    public Stocktaking queryById(@Param("stocktakingId") Long stocktakingId,
                                 @Param("stocktakingStockGoodsId") Long stocktakingStockGoodsId) {
        return stocktakingMapper.queryById(stocktakingId, stocktakingStockGoodsId);
    }

    @GetMapping("/queryAll")
    public List<Stocktaking> queryAll(@Param("rowIndex") int rowIndex, 
                                      @Param("pageSize") int pageSize) {
        return stocktakingMapper.queryAll(rowIndex, pageSize);
    }

    @GetMapping("/queryByCondition")
    public List<Stocktaking> queryByCondition(@Param("stocktakingCondition")Stocktaking stocktakingCondition,
                                              @Param("rowIndex") int rowIndex,
                                              @Param("pageSize") int pageSize) {
        return stocktakingMapper.queryByCondition(stocktakingCondition, rowIndex, pageSize);
    }

    @GetMapping("/queryByStocktakingId")
    public List<Stocktaking> queryByStocktakingId(Long stocktakingId) {
        return stocktakingMapper.queryByStocktakingId(stocktakingId);
    }
    
}
