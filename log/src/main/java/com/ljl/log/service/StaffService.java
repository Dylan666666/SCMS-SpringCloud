package com.ljl.log.service;

import com.ljl.log.entity.SupermarketStaff;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/2 14:15
 */
public interface StaffService {

    public final static String STAFF_LIST_KEY = "staffList";
    
    /**
     * 通过电话号码查询职工信息
     *
     * @param staffPhone
     * @return
     */
    SupermarketStaff queryStaffByPhone(String staffPhone);

    /**
     * 注册职工信息
     *
     * @param staff
     * @return
     */
    int insertStaff(SupermarketStaff staff);

    /**
     * 更新职工信息
     *
     * @param staff
     * @return
     */
    int updateStaff(SupermarketStaff staff);

    /**
     * 更改职工职位 (高权限)
     *
     * @param staff
     * @return
     */
    int updateStaffPosition(SupermarketStaff staff);

    /**
     * 职工登录
     *
     * @param staffPhone
     * @param staffPassword
     * @return
     */
    SupermarketStaff staffLogin(String staffPhone, String staffPassword);

    /**
     * 职工信息模糊查询
     *
     * @param staffCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<SupermarketStaff> queryStaffByCondition(SupermarketStaff staffCondition,
                                                 int pageIndex,
                                                 int pageSize);

    /**
     * 退出登录
     * 
     * @param staffToken
     */
    void staffLogout(String staffToken);

    /**
     * 通过ID查询
     *
     * @param staffId
     * @return
     */
    SupermarketStaff queryById(int staffId);

    /**
     * 1.4超级管理员 用户列表 删除
     *
     * @param staffId
     * @return
     */
    int deleteStaff(int staffId);

    /**
     * 查的用户总数
     *
     * @return
     */
    int countStaffAll();
    
}
