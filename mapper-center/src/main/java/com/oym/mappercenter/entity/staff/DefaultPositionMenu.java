package com.oym.mappercenter.entity.staff;

import java.io.Serializable;

/**
 * 职位二级菜单表
 * 
 * @Author: Mr_OO
 * @Date: 2020/11/9 21:13
 */
public class DefaultPositionMenu implements Serializable {

    private static final long serialVersionUID = -2575794056318445203L;
    private Integer secondaryMenuId;
    private Integer staffPositionId;

    public Integer getSecondaryMenuId() {
        return secondaryMenuId;
    }

    public void setSecondaryMenuId(Integer secondaryMenuId) {
        this.secondaryMenuId = secondaryMenuId;
    }

    public Integer getStaffPositionId() {
        return staffPositionId;
    }

    public void setStaffPositionId(Integer staffPositionId) {
        this.staffPositionId = staffPositionId;
    }
}
