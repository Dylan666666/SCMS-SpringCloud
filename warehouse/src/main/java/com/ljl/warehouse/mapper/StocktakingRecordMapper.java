package com.ljl.warehouse.mapper;

import com.ljl.warehouse.entity.StocktakingRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/26 21:15
 */
@FeignClient(name = "mapper-center")
@Service
public interface StocktakingRecordMapper {
    /**
     * 添加盘点详情单
     *
     * @param stocktakingRecord
     * @return
     */
    @GetMapping("/stocktakingRecordMapper/insert")
    int insert(@RequestParam("stocktakingRecord") StocktakingRecord stocktakingRecord);

    /**
     * 更新盘点详情单信息
     *
     * @param stocktakingRecord
     * @return
     */
    @GetMapping("/stocktakingRecordMapper/update")
    int update(@RequestParam("stocktakingRecord") StocktakingRecord stocktakingRecord);

    /**
     * 通过ID查询盘点详情单
     *
     * @param stocktakingId
     * @return
     */
    @GetMapping("/stocktakingRecordMapper/queryById")
    StocktakingRecord queryById(@RequestParam("stocktakingId") Long stocktakingId);

    /**
     * 一键查询盘点详情单 
     *
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/stocktakingRecordMapper/queryAll")
    List<StocktakingRecord> queryAll(@RequestParam("rowIndex") int rowIndex,
                                     @RequestParam("pageSize") int pageSize);

    /**
     * 模糊查询盘点详情单
     *
     * @param condition
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/stocktakingRecordMapper/queryByCondition")
    List<StocktakingRecord> queryByCondition(@RequestParam("condition") StocktakingRecord condition,
                                             @RequestParam("rowIndex") int rowIndex,
                                             @RequestParam("pageSize") int pageSize);

    /**
     * 查询是否有正在盘点的订单
     * 
     * @param state
     * @return
     */
    @GetMapping("/stocktakingRecordMapper/queryStocktakingCount")
    int queryStocktakingCount(@RequestParam("state") int state);

    /**
     * 获取今日盘点次数
     *
     * @param dateFormat
     * @return
     */
    @GetMapping("/stocktakingRecordMapper/getCount")
    int getCount(@RequestParam("dateFormat") String dateFormat);
}
