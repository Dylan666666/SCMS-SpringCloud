package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.staff.DefaultPositionMenu;
import com.oym.mappercenter.mapper.DefaultPositionMenuMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 10:53
 */
@RestController()
@RequestMapping("/defaultPositionMenuMapper")
public class DefaultPositionMenuController {
    
    @Resource
    private DefaultPositionMenuMapper defaultPositionMenuMapper;

    @GetMapping("/queryAll")
    public List<DefaultPositionMenu> queryAll() {
        return defaultPositionMenuMapper.queryAll();
    }

    @GetMapping("/queryByPositionId")
    public List<DefaultPositionMenu> queryByPositionId(@Param("positionId") Integer positionId) {
        return defaultPositionMenuMapper.queryByPositionId(positionId);
    }

    @GetMapping("/insert")
    public int insert(@Param("menu")DefaultPositionMenu menu) {
        return defaultPositionMenuMapper.insert(menu);
    }

    @GetMapping("/delete")
    public int delete(@Param("menu")DefaultPositionMenu menu) {
        return defaultPositionMenuMapper.delete(menu);
    }
    
}
