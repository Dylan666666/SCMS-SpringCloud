package com.ljl.sale.service;

import com.ljl.sale.entity.Stock;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/18 22:04
 */
public interface StockService {

    public final static String STOCK_LIST_KEY = "stockList";
    
    /**
     * 添加库存
     *
     * @param stock
     * @return
     */
    int insert(Stock stock);

    /**
     * 更新库存
     *
     * @param stock
     * @return
     */
    int update(Stock stock);

    /**
     * 通过产品编号查库存表
     *
     * @param goodsStockId
     * @return
     */
    List<Stock> queryByGoodsId(Long goodsStockId);

    /**
     * 通过产品编号查库存表
     *
     * @param stockGoodsId
     * @return
     */
    Stock queryById(Long stockGoodsId);

    /**
     * 通过入库编号查询
     *
     * @param stockExportBillId
     * @return
     */
    Stock queryByExportBillId(String stockExportBillId);

    /**
     * 模糊查询
     *
     * @param stockCondition
     * @return
     */
    List<Stock> queryByCondition(Stock stockCondition);

    /**
     * 一键查询
     * 
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<Stock> queryAll(int pageIndex, int pageSize);
}
