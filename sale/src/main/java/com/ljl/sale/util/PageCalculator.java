package com.ljl.sale.util;

/**
 * 计算行索引工具
 * 
 * @Author: Mr_OO
 * @Date: 2020/3/2 18:54
 */
public class PageCalculator {
    public static int calculatorRowIndex(int pageIndex, int pageSize) {
        return (pageIndex >= 0) ? pageIndex * pageSize : 0;
    } 
}
