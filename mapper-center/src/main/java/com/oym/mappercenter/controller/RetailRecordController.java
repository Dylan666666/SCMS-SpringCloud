package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.RetailRecord;
import com.oym.mappercenter.mapper.RetailRecordMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 15:13
 */
@RestController()
@RequestMapping("/retailRecordMapper")
public class RetailRecordController {

    @Resource
    private RetailRecordMapper retailRecordMapper;

    @GetMapping("/insert")
    public int insert(RetailRecord retailRecord) {
        return retailRecordMapper.insert(retailRecord);
    }

    @GetMapping("/update")
    public int update(RetailRecord retailRecord) {
        return retailRecordMapper.update(retailRecord);
    }

    @GetMapping("/queryByRetailId")
    public RetailRecord queryByRetailId(String retailId) {
        return retailRecordMapper.queryByRetailId(retailId);
    }

    @GetMapping("/queryAll")
    public List<RetailRecord> queryAll(@Param("rowIndex") int rowIndex, 
                                       @Param("pageSize") int pageSize) {
        return retailRecordMapper.queryAll(rowIndex, pageSize);
    }

    @GetMapping("/queryByCondition")
    public List<RetailRecord> queryByCondition(@Param("retailRecordCondition") RetailRecord retailRecordCondition,
                                               @Param("rowIndex") int rowIndex,
                                               @Param("pageSize") int pageSize) {
        return retailRecordMapper
                .queryByCondition(retailRecordCondition, rowIndex, pageSize);
    }
    
}
