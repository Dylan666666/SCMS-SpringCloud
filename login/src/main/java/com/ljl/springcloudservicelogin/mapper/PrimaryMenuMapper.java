package com.ljl.springcloudservicelogin.mapper;

import com.ljl.springcloudservicelogin.entity.staff.PrimaryMenu;
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
public interface PrimaryMenuMapper {

    /**
     * 添加一级菜单
     * 
     * @param primaryMenu
     * @return
     */
    @GetMapping("/primaryMenuMapper/insert")
    int insert(@RequestParam("primaryMenu") PrimaryMenu primaryMenu);

    /**
     * 通过一级菜单ID查询一级菜单
     * 
     * @param primaryMenuId
     * @return
     */
    @GetMapping("/primaryMenuMapper/queryById")
    PrimaryMenu queryById(@RequestParam("primaryMenuId") int primaryMenuId);

    /**
     * 更改一级菜单
     * 
     * @param primaryMenu
     * @return
     */
    @GetMapping("/primaryMenuMapper/update")
    int update(@RequestParam("primaryMenu") PrimaryMenu primaryMenu);

    /**
     * 删除一级菜单
     * 
     * @param primaryMenuId
     * @return
     */
    @GetMapping("/primaryMenuMapper/delete")
    int delete(@RequestParam("primaryMenuId") int primaryMenuId);

    /**
     * 一键查询
     * 
     * @return
     */
    @GetMapping("/primaryMenuMapper/queryAll")
    List<PrimaryMenu> queryAll();
}
