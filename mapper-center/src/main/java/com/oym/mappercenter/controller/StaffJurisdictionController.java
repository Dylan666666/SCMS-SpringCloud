package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.staff.StaffJurisdiction;
import com.oym.mappercenter.mapper.StaffJurisdictionMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 15:22
 */
@RestController()
@RequestMapping("/staffJurisdictionMapper")
public class StaffJurisdictionController {

    @Resource
    private StaffJurisdictionMapper staffJurisdictionMapper;

    @GetMapping("/insert")
    public int insert(StaffJurisdiction staffJurisdiction) {
        return staffJurisdictionMapper.insert(staffJurisdiction);
    }

    @GetMapping("/queryById")
    public List<StaffJurisdiction> queryById(int staffId) {
        return staffJurisdictionMapper.queryById(staffId);
    }

    @GetMapping("/update")
    public int update(StaffJurisdiction staffJurisdiction) {
        return staffJurisdictionMapper.update(staffJurisdiction);
    }

    @GetMapping("/delete")
    public int delete(int staffId) {
        return staffJurisdictionMapper.delete(staffId);
    }

    @GetMapping("/queryAll")
    public List<StaffJurisdiction> queryAll() {
        return staffJurisdictionMapper.queryAll();
    }
    
}
