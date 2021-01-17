package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.Retail;
import com.oym.mappercenter.mapper.RetailMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 15:10
 */
@RestController()
@RequestMapping("/retailMapper")
public class RetailController {
    
    @Resource
    private RetailMapper retailMapper;

    @GetMapping("/insert")
    public int insert(Retail retail) {
        return retailMapper.insert(retail);
    }

    @GetMapping("/update")
    public int update(Retail retail) {
        return retailMapper.update(retail);
    }

    @GetMapping("/queryByRetailId")
    public List<Retail> queryByRetailId(String retailId) {
        return retailMapper.queryByRetailId(retailId);
    }

    @GetMapping("/queryByGoodsId")
    public Retail queryByGoodsId(@Param("retailId") String retailId, 
                                 @Param("retailStockGoodsId") Long retailStockGoodsId) {
        return retailMapper.queryByGoodsId(retailId, retailStockGoodsId);
    }

    @GetMapping("/queryAll")
    public List<Retail> queryAll(@Param("rowIndex") int rowIndex, 
                                 @Param("pageSize") int pageSize) {
        return retailMapper.queryAll(rowIndex, pageSize);
    }
    
}
