package com.ljl.warehouse.bean;

import java.io.Serializable;

/**
 * Goods和Stock连接表GoodsStockNum
 * 
 * @Author: Mr_OO
 * @Date: 2020/11/29 13:58
 */
public class GoodsStockNum implements Serializable {
    private static final long serialVersionUID = -5886009863942089785L;
    private Long goodsId;
    private String goodsName;
    private Integer goodsCategoryId;
    private String goodsBrand;
    private String goodsSpecifications;
    private String goodsPicture;
    private Integer stockInventoryNum;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsCategoryId() {
        return goodsCategoryId;
    }

    public void setGoodsCategoryId(Integer goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }

    public String getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand) {
        this.goodsBrand = goodsBrand;
    }

    public String getGoodsSpecifications() {
        return goodsSpecifications;
    }

    public void setGoodsSpecifications(String goodsSpecifications) {
        this.goodsSpecifications = goodsSpecifications;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public Integer getStockInventoryNum() {
        return stockInventoryNum;
    }

    public void setStockInventoryNum(Integer stockInventoryNum) {
        this.stockInventoryNum = stockInventoryNum;
    }
}
