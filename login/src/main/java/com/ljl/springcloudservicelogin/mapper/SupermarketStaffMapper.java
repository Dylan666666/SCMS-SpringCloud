package com.ljl.springcloudservicelogin.mapper;

import com.ljl.springcloudservicelogin.entity.SupermarketStaff;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/10/8 9:40
 */
@FeignClient(name = "mapper-center")
@Service
public interface SupermarketStaffMapper {

    /**
     * 通过电话号码查询职工信息
     * 
     * @param staffPhone
     * @return
     */
    //无
    @GetMapping("/supermarketStaffMapper/queryStaffByPhone")
    SupermarketStaff queryStaffByPhone(@RequestParam("staffPhone") String staffPhone);

    /**
     * 注册职工信息
     * 
     * @param staff
     * @return
     */
    @GetMapping("/supermarketStaffMapper/insertStaff")
    int insertStaff(@RequestParam("staff") SupermarketStaff staff);

    /**
     * 更新职工信息
     * 
     * @param staff
     * @return
     */
    @GetMapping("/supermarketStaffMapper/updateStaff")
    int updateStaff(@RequestParam("staff") SupermarketStaff staff);

    /**
     * 更改职工职位 (高权限)
     * 
     * @param staff
     * @return
     */
    @GetMapping("/supermarketStaffMapper/updateStaffPosition")
    int updateStaffPosition(@RequestParam("staff") SupermarketStaff staff);

    /**
     * 职工登录
     * 
     * @param staffPhone
     * @param staffPassword
     * @return
     */
    @GetMapping("/supermarketStaffMapper/staffLogin")
    SupermarketStaff staffLogin(@RequestParam("staffPhone") String staffPhone, @RequestParam("staffPassword") String staffPassword);

    /**
     * 职工信息模糊查询
     * 
     * @param staffCondition
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/supermarketStaffMapper/queryStaffByCondition")
    List<SupermarketStaff> queryStaffByCondition(@RequestParam("staffCondition") SupermarketStaff staffCondition,
                                                 @RequestParam("rowIndex") int rowIndex,@RequestParam("pageSize") int pageSize);

    /**
     * 通过ID查询
     * 
     * @param staffId
     * @return
     */
    //无
    @GetMapping("/supermarketStaffMapper/queryById")
    SupermarketStaff queryById(@RequestParam("staffId") int staffId);

    /**
     * 1.4超级管理员 用户列表 删除
     * 
     * @param staffId
     * @return
     */
    @GetMapping("/supermarketStaffMapper/deleteStaff")
    int deleteStaff(@RequestParam("staffId") int staffId);

    /**
     * 查的用户总数
     * 
     * @return
     */
    @GetMapping("/supermarketStaffMapper/countStaffAll")
    int countStaffAll();
}
