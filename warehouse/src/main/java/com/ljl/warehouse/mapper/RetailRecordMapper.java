package com.ljl.warehouse.mapper;

import com.ljl.warehouse.entity.RetailRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/25 12:26
 */
@FeignClient(name = "mapper-center")
@Service
public interface RetailRecordMapper {
    /**
     * 添加订货详情单
     *
     * @param retailRecord
     * @return
     */
    @GetMapping("/retailRecordMapper/insert")
    int insert(@RequestParam("retailRecord") RetailRecord retailRecord);

    /**
     * 更新订货详情单
     *
     * @param retailRecord
     * @return
     */
    @GetMapping("/retailRecordMapper/update")
    int update(@RequestParam("retailRecord") RetailRecord retailRecord);

    /**
     * 通过ID查询订货详情单
     *
     * @param retailId
     * @return
     */
    @GetMapping("/retailRecordMapper/queryByRetailId")
    RetailRecord queryByRetailId(@RequestParam("retailId") String retailId);

    /**
     * 一键查询订货详情单
     *
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/retailRecordMapper/queryAll")
    List<RetailRecord> queryAll(@RequestParam("rowIndex") int rowIndex,
                                @RequestParam("pageSize") int pageSize);

    /**
     * 模糊查询订货详情单
     *
     * @param retailRecordCondition
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/retailRecordMapper/queryByCondition")
    List<RetailRecord> queryByCondition(@RequestParam("retailRecordCondition") RetailRecord retailRecordCondition,
                                        @RequestParam("rowIndex") int rowIndex,
                                        @RequestParam("pageSize") int pageSize);
}
