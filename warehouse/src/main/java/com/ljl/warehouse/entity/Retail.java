package com.ljl.warehouse.entity;

import java.io.Serializable;

/**
 * 订单
 * 
 * @Author: Mr_OO
 * @Date: 2020/11/22 10:04
 */
public class Retail implements Serializable {
    private static final long serialVersionUID = -3419756381406921762L;
    private String retailId;
    private Long retailStockGoodsId;
    private Integer retailNum;
    private Double retailPrice;

    public String getRetailId() {
        return retailId;
    }

    public void setRetailId(String retailId) {
        this.retailId = retailId;
    }

    public Long getRetailStockGoodsId() {
        return retailStockGoodsId;
    }

    public void setRetailStockGoodsId(Long retailStockGoodsId) {
        this.retailStockGoodsId = retailStockGoodsId;
    }

    public Integer getRetailNum() {
        return retailNum;
    }

    public void setRetailNum(Integer retailNum) {
        this.retailNum = retailNum;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }
}
