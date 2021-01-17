package com.ljl.superManage.mapper;

import com.ljl.superManage.entity.staff.Function;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/9 21:33
 */
@FeignClient(name = "mapper-center")
@Service
public interface FunctionMapper {

    /**
     * 添加三级菜单
     * 
     * @param function
     * @return
     */
    @GetMapping("/functionMapper/insert")
    int insert(@RequestParam("function") Function function);

    /**
     * 删除三级菜单
     * 
     * @param functionId
     * @return
     */
    @GetMapping("/functionMapper/delete")
    int delete(@RequestParam("functionId") int functionId);

    /**
     * 通过功能id查询功能表
     * 
     * @param functionId
     * @return
     */
    @GetMapping("/functionMapper/queryById")
    Function queryById(@RequestParam("functionId") int functionId);

    /**
     * 通过secondaryMenuId查询功能集合
     * 
     * @param id
     * @return
     */
    @GetMapping("/functionMapper/queryBySecondaryMenuId")
    List<Function> queryBySecondaryMenuId(@RequestParam("id") int id);

    /**
     * 更改三级菜单信息
     * 
     * @param function
     * @return
     */
    @GetMapping("/functionMapper/update")
    int update(@RequestParam("function") Function function);

    /**
     * 一键查询
     * 
     * @return
     */
    @GetMapping("/functionMapper/queryAll")
    List<Function> queryAll();

    /**
     * 通过功能Url查询功能表
     *
     * @param functionUrl
     * @return
     */
    @GetMapping("/functionMapper/queryByUrl")
    Function queryByUrl(@RequestParam("functionUrl") String functionUrl);
}
