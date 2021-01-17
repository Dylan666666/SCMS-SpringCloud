package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.SupermarketStaff;
import com.oym.mappercenter.mapper.SupermarketStaffMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 16:26
 */
@RestController
@RequestMapping("/supermarketStaffMapper")
public class SupermarketStaffController {

    @Resource
    private SupermarketStaffMapper supermarketStaffMapper;

    @GetMapping("/queryStaffByPhone")
    SupermarketStaff queryStaffByPhone(String staffPhone){
        return  supermarketStaffMapper.queryStaffByPhone(staffPhone);
    }

    @GetMapping("/queryById")
    SupermarketStaff queryById(int staffId){
        return supermarketStaffMapper.queryById(staffId);
    }

    @GetMapping("/insertStaff")
    public int insertStaff(SupermarketStaff staff) {
        return supermarketStaffMapper.insertStaff(staff);
    }
    
    @GetMapping("/updateStaff")
    public int updateStaff(SupermarketStaff staff) {
        return supermarketStaffMapper.updateStaff(staff);
    }

    @GetMapping("/updateStaffPosition")
    public int updateStaffPosition(SupermarketStaff staff) {
        return supermarketStaffMapper.updateStaffPosition(staff);
    }

    @GetMapping("/staffLogin")
    public SupermarketStaff staffLogin(@Param("staffPhone") String staffPhone, 
                                       @Param("staffPassword") String staffPassword) {
        return supermarketStaffMapper.staffLogin(staffPhone, staffPassword);
    }

    @GetMapping("/queryStaffByCondition")
    public List<SupermarketStaff> queryStaffByCondition(
            @Param("staffCondition")SupermarketStaff staffCondition,
            @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize) {
        return supermarketStaffMapper.queryStaffByCondition(staffCondition, rowIndex, pageSize);
    }

    @GetMapping("/deleteStaff")
    public int deleteStaff(int staffId) {
        return supermarketStaffMapper.deleteStaff(staffId);
    }

    @GetMapping("/countStaffAll")
    public int countStaffAll() {
        return supermarketStaffMapper.countStaffAll();
    }
    
}
