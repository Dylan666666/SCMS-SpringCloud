package com.oym.mappercenter.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单记录表
 * 
 * @Author: Mr_OO
 * @Date: 2020/11/22 10:01
 */
public class RetailRecord implements Serializable {
    private static final long serialVersionUID = -6956324011649114076L;
    private String retailId;
    private Date retailTime;
    private Integer retailCollectionStaffId;
    private Double retailTotalPrice;
    private Integer retailRefundStatus;

    public String getRetailId() {
        return retailId;
    }

    public void setRetailId(String retailId) {
        this.retailId = retailId;
    }

    public Date getRetailTime() {
        return retailTime;
    }

    public void setRetailTime(Date retailTime) {
        this.retailTime = retailTime;
    }

    public Integer getRetailCollectionStaffId() {
        return retailCollectionStaffId;
    }

    public void setRetailCollectionStaffId(Integer retailCollectionStaffId) {
        this.retailCollectionStaffId = retailCollectionStaffId;
    }

    public Double getRetailTotalPrice() {
        return retailTotalPrice;
    }

    public void setRetailTotalPrice(Double retailTotalPrice) {
        this.retailTotalPrice = retailTotalPrice;
    }

    public Integer getRetailRefundStatus() {
        return retailRefundStatus;
    }

    public void setRetailRefundStatus(Integer retailRefundStatus) {
        this.retailRefundStatus = retailRefundStatus;
    }
}
