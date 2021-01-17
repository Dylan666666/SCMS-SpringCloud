package com.ljl.springcloudservicelogin.mapper;

import com.ljl.springcloudservicelogin.entity.staff.StaffJurisdiction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/9 21:34
 */
@FeignClient(name = "mapper-center")
@Service
public interface StaffJurisdictionMapper {

    /**
     * 添加职工功能表
     *
     * @param staffJurisdiction
     * @return
     */
    @GetMapping("/staffJurisdictionMapper/insert")
    int insert(@RequestParam("staffJurisdiction") StaffJurisdiction staffJurisdiction);

    /**
     * 通过职工ID查询功能表集合
     * 
     * @param staffId
     * @return
     */
    @GetMapping("/staffJurisdictionMapper/queryById")
    List<StaffJurisdiction> queryById(@RequestParam("staffId") int staffId);

    /**
     * 更改行数据
     *
     * @param staffJurisdiction
     * @return
     */
    @GetMapping("/staffJurisdictionMapper/update")
    int update(@RequestParam("staffJurisdiction") StaffJurisdiction staffJurisdiction);

    /**
     * 删除功能权限
     *
     * @param staffId
     * @return
     */
    @GetMapping("/staffJurisdictionMapper/delete")
    int delete(@RequestParam("staffId") int staffId);

    /**
     * 一键查询
     * 
     * @return
     */
    @GetMapping("/staffJurisdictionMapper/queryAll")
    List<StaffJurisdiction> queryAll();
    
}
