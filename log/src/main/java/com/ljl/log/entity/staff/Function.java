package com.ljl.log.entity.staff;

import java.io.Serializable;

/**
 * 三级菜单表
 * 
 * @Author: Mr_OO
 * @Date: 2020/11/9 21:13
 */
public class Function implements Serializable {
    private static final long serialVersionUID = -4584978680006323773L;
    private Integer functionId;
    private Integer functionWeight;
    private Integer secondaryMenuId;
    private String functionName;
    private String functionUrl;

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public Integer getFunctionWeight() {
        return functionWeight;
    }

    public void setFunctionWeight(Integer functionWeight) {
        this.functionWeight = functionWeight;
    }

    public Integer getSecondaryMenuId() {
        return secondaryMenuId;
    }

    public void setSecondaryMenuId(Integer secondaryMenuId) {
        this.secondaryMenuId = secondaryMenuId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionUrl() {
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl;
    }
}
