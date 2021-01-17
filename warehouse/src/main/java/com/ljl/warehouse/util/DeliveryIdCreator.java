package com.ljl.warehouse.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 出库单批发单ID生成器
 * 
 * @Author: Mr_OO
 * @Date: 2020/11/23 21:25
 */
public class DeliveryIdCreator {
    public static String get(int staffId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        String str = sdf.format(new Date());
        return str + staffId;
    }
}
