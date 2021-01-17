package com.ljl.superManage.mapper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.ljl.superManage.entity.staff.SecondaryMenu;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/9 21:34
 */
@FeignClient(name = "mapper-center")
@Service
public interface SecondaryMenuMapper {

    /**
     * 添加二级菜单
     *
     * @param secondaryMenu
     * @return
     */
    @GetMapping("/secondaryMenuMapper/insert")
    int insert(@RequestParam("secondaryMenu") SecondaryMenu secondaryMenu);

    /**
     * 通过二级菜单ID查询二级菜单
     *
     * @param secondaryMenuId
     * @return
     */
    @GetMapping("/secondaryMenuMapper/queryById")
    SecondaryMenu queryById(@RequestParam("secondaryMenuId") int secondaryMenuId);

    /**
     * 通过二级菜单URL查询二级菜单
     *
     * @param secondaryMenuUrl
     * @return
     */
    @GetMapping("/secondaryMenuMapper/queryByUrl")
    SecondaryMenu queryByUrl(@RequestParam("secondaryMenuUrl") String secondaryMenuUrl);

    /**
     * 更改二级菜单
     *
     * @param secondaryMenu
     * @return
     */
    @GetMapping("/secondaryMenuMapper/update")
    int update(@RequestParam("secondaryMenu") SecondaryMenu secondaryMenu);

    /**
     * 删除二级菜单
     *
     * @param secondaryMenuId
     * @return
     */
    @GetMapping("/secondaryMenuMapper/delete")
    int delete(@RequestParam("secondaryMenuId") int secondaryMenuId);

    /**
     * 一键查询
     *
     * @return
     */
    @GetMapping("/secondaryMenuMapper/queryAll")
    List<SecondaryMenu> queryAll();

    /**
     * 通过secondaryMenuId查询功能集合
     *
     * @param primaryMenuId
     * @return
     */
    @GetMapping("/secondaryMenuMapper/queryByPrimaryMenuId")
    List<SecondaryMenu> queryByPrimaryMenuId(@RequestParam("primaryMenuId") int primaryMenuId);
}
