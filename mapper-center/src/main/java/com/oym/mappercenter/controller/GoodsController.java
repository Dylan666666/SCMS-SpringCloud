package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.Goods;
import com.oym.mappercenter.mapper.GoodsMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 14:40
 */
@RestController()
@RequestMapping("/goodsMapper")
public class GoodsController {
    
    @Resource
    private GoodsMapper goodsMapper;

    @GetMapping("/insertGoods")
    public int insertGoods(Goods goods) {
        return goodsMapper.insertGoods(goods);
    }

    @GetMapping("/updateGoods")
    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }

    @GetMapping("/queryAll")
    public List<Goods> queryAll() {
        return goodsMapper.queryAll();
    }

    @GetMapping("/queryByCondition")
    public List<Goods> queryByCondition(@Param("goodsCondition") Goods goodsCondition,
                                        @Param("rowIndex") int rowIndex,
                                        @Param("pageSize") int pageSize) {
        return goodsMapper.queryByCondition(goodsCondition, rowIndex, pageSize);
    }

    @GetMapping("/deleteGoods")
    public int deleteGoods(Long goodsId) {
        return goodsMapper.deleteGoods(goodsId);
    }

    @GetMapping("/queryById")
    public Goods queryById(Long goodsId){
        return goodsMapper.queryById(goodsId);
    }
    
}
