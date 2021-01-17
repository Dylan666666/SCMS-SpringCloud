package com.ljl.staff.mapper;

import com.ljl.staff.entity.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/18 11:50
 */
@FeignClient(name = "mapper-center")
@Service
public interface GoodsMapper {
    /**
     * 添加商品
     * 
     * @param goods
     * @return
     */
    @GetMapping("/goodsMapper/insertGoods")
    int insertGoods(@RequestParam("goods") Goods goods);

    /**
     * 更改商品信息
     * 
     * @param goods
     * @return
     */
    @GetMapping("/goodsMapper/updateGoods")
    int updateGoods(@RequestParam("goods") Goods goods);

    /**
     * 查询所有商品列表
     * 
     * @return
     */
    @GetMapping("/goodsMapper/queryAll")
    List<Goods> queryAll();

    /**
     * 条件查询产品
     * 
     * @param goodsCondition
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/goodsMapper/queryByCondition")
    List<Goods> queryByCondition(@RequestParam("goodsCondition") Goods goodsCondition,
                                 @RequestParam("rowIndex") int rowIndex,
                                 @RequestParam("pageSize") int pageSize);

    /**
     * 删除商品
     * 
     * @param goodsId
     * @return
     */
    @GetMapping("/goodsMapper/deleteGoods")
    int deleteGoods(@RequestParam("goodsId") Long goodsId);

    /**
     * 通过Id查询
     *
     * @param goodsId
     * @return
     */
    @GetMapping("/goodsMapper/queryById")
    Goods queryById(@RequestParam("goodsId") Long goodsId);
}
