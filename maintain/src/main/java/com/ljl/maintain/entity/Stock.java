package com.ljl.maintain.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 库存类
 * 
 * @Author: Mr_OO
 * @Date: 2020/11/18 10:15
 */
public class Stock implements Serializable {
    private static final long serialVersionUID = -6356179063790611000L;
    private Long stockGoodsId;
    private Integer stockId;
    private Long goodsStockId;
    private Integer stockUnitId;
    private Long stockGoodsBatchNumber;
    private Date stockGoodsProductionDate;
    private Integer stockGoodsShelfLife;
    private Double stockGoodsPrice;
    private Integer stockInventory;
    private String stockExportBillId;

    public Long getStockGoodsId() {
        return stockGoodsId;
    }

    public void setStockGoodsId(Long stockGoodsId) {
        this.stockGoodsId = stockGoodsId;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Long getGoodsStockId() {
        return goodsStockId;
    }

    public void setGoodsStockId(Long goodsStockId) {
        this.goodsStockId = goodsStockId;
    }

    public Integer getStockUnitId() {
        return stockUnitId;
    }

    public void setStockUnitId(Integer stockUnitId) {
        this.stockUnitId = stockUnitId;
    }

    public Long getStockGoodsBatchNumber() {
        return stockGoodsBatchNumber;
    }

    public void setStockGoodsBatchNumber(Long stockGoodsBatchNumber) {
        this.stockGoodsBatchNumber = stockGoodsBatchNumber;
    }

    public Date getStockGoodsProductionDate() {
        return stockGoodsProductionDate;
    }

    public void setStockGoodsProductionDate(Date stockGoodsProductionDate) {
        this.stockGoodsProductionDate = stockGoodsProductionDate;
    }

    public Integer getStockGoodsShelfLife() {
        return stockGoodsShelfLife;
    }

    public void setStockGoodsShelfLife(Integer stockGoodsShelfLife) {
        this.stockGoodsShelfLife = stockGoodsShelfLife;
    }

    public Double getStockGoodsPrice() {
        return stockGoodsPrice;
    }

    public void setStockGoodsPrice(Double stockGoodsPrice) {
        this.stockGoodsPrice = stockGoodsPrice;
    }

    public Integer getStockInventory() {
        return stockInventory;
    }

    public void setStockInventory(Integer stockInventory) {
        this.stockInventory = stockInventory;
    }

    public String getStockExportBillId() {
        return stockExportBillId;
    }

    public void setStockExportBillId(String stockExportBillId) {
        this.stockExportBillId = stockExportBillId;
    }
}
