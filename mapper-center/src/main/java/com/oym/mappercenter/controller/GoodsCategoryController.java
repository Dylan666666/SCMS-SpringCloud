package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.GoodsCategory;
import com.oym.mappercenter.mapper.GoodsCategoryMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 14:37
 */
@RestController()
@RequestMapping("/goodsCategoryMapper")
public class GoodsCategoryController {
    @Resource
    private GoodsCategoryMapper goodsCategoryMapper;

    @GetMapping("/queryAll")
    public List<GoodsCategory> queryAll() {
        return goodsCategoryMapper.queryAll();
    }

    @GetMapping("/insert")
    public int insert(GoodsCategory goodsCategory) {
        return goodsCategoryMapper.insert(goodsCategory);
    }

    @GetMapping("/queryById")
    public GoodsCategory queryById(int categoryId) {
        return goodsCategoryMapper.queryById(categoryId);
    }

    @GetMapping("/update")
    public int update(GoodsCategory goodsCategory) {
        return goodsCategoryMapper.update(goodsCategory);
    }

    @GetMapping("/queryByStaffId")
    public List<GoodsCategory> queryByStaffId(int staffId) {
        return goodsCategoryMapper.queryByStaffId(staffId);
    }

    @GetMapping("/updateByStaffId")
    public int updateByStaffId(int stocktakingStaffId) {
        return goodsCategoryMapper.updateByStaffId(stocktakingStaffId);
    }
    
}
