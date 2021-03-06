package com.ljl.warehouse.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 盘点单
 * 
 * @Author: Mr_OO
 * @Date: 2020/11/22 10:08
 */
public class Stocktaking implements Serializable {
    private static final long serialVersionUID = -6450830220467034868L;
    private Long stocktakingId;
    private Long stocktakingStockGoodsId;
    private Integer stockNum;
    private Integer stocktakingNum;
    private Integer stocktakingStaffId;
    private Integer stocktakingStatus;
    private String stocktakingRemarks;
    private Date stocktakingTime;
    private Integer stocktakingProfitLossStatus;
    private Double stocktakingPrice;

    public Long getStocktakingId() {
        return stocktakingId;
    }

    public void setStocktakingId(Long stocktakingId) {
        this.stocktakingId = stocktakingId;
    }

    public Long getStocktakingStockGoodsId() {
        return stocktakingStockGoodsId;
    }

    public void setStocktakingStockGoodsId(Long stocktakingStockGoodsId) {
        this.stocktakingStockGoodsId = stocktakingStockGoodsId;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public Integer getStocktakingNum() {
        return stocktakingNum;
    }

    public void setStocktakingNum(Integer stocktakingNum) {
        this.stocktakingNum = stocktakingNum;
    }

    public Integer getStocktakingStaffId() {
        return stocktakingStaffId;
    }

    public void setStocktakingStaffId(Integer stocktakingStaffId) {
        this.stocktakingStaffId = stocktakingStaffId;
    }

    public Integer getStocktakingStatus() {
        return stocktakingStatus;
    }

    public void setStocktakingStatus(Integer stocktakingStatus) {
        this.stocktakingStatus = stocktakingStatus;
    }

    public String getStocktakingRemarks() {
        return stocktakingRemarks;
    }

    public void setStocktakingRemarks(String stocktakingRemarks) {
        this.stocktakingRemarks = stocktakingRemarks;
    }

    public Date getStocktakingTime() {
        return stocktakingTime;
    }

    public void setStocktakingTime(Date stocktakingTime) {
        this.stocktakingTime = stocktakingTime;
    }

    public Integer getStocktakingProfitLossStatus() {
        return stocktakingProfitLossStatus;
    }

    public void setStocktakingProfitLossStatus(Integer stocktakingProfitLossStatus) {
        this.stocktakingProfitLossStatus = stocktakingProfitLossStatus;
    }

    public Double getStocktakingPrice() {
        return stocktakingPrice;
    }

    public void setStocktakingPrice(Double stocktakingPrice) {
        this.stocktakingPrice = stocktakingPrice;
    }
}
