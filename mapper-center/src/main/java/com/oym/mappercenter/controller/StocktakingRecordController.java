package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.StocktakingRecord;
import com.oym.mappercenter.mapper.StocktakingRecordMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 16:22
 */
@RestController()
@RequestMapping("/stocktakingRecordMapper")
public class StocktakingRecordController {
    
    @Resource
    private StocktakingRecordMapper stocktakingRecordMapper;

    @GetMapping("/insert")
    public int insert(StocktakingRecord stocktakingRecord) {
        return stocktakingRecordMapper.insert(stocktakingRecord);
    }

    @GetMapping("/update")
    public int update(StocktakingRecord stocktakingRecord) {
        return stocktakingRecordMapper.update(stocktakingRecord);
    }

    @GetMapping("/queryById")
    public StocktakingRecord queryById(Long stocktakingId) {
        return stocktakingRecordMapper.queryById(stocktakingId);
    }

    @GetMapping("/queryAll")
    public List<StocktakingRecord> queryAll(@Param("rowIndex") int rowIndex, 
                                            @Param("pageSize") int pageSize) {
        return stocktakingRecordMapper.queryAll(rowIndex, pageSize);
    }

    @GetMapping("/queryByCondition")
    public List<StocktakingRecord> queryByCondition(@Param("condition")StocktakingRecord condition,
                                                    @Param("rowIndex") int rowIndex,
                                                    @Param("pageSize") int pageSize) {
        return stocktakingRecordMapper.queryByCondition(condition, rowIndex, pageSize);
    }

    @GetMapping("/queryStocktakingCount")
    public int queryStocktakingCount(int state) {
        return stocktakingRecordMapper.queryStocktakingCount(state);
    }

    @GetMapping("/getCount")
    public int getCount(String dateFormat) {
        return stocktakingRecordMapper.getCount(dateFormat);
    }
    
}
