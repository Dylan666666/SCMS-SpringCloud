package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.staff.SecondaryMenu;
import com.oym.mappercenter.mapper.SecondaryMenuMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 15:16
 */
@RestController()
@RequestMapping("/secondaryMenuMapper")
public class SecondaryMenuController {

    @Resource
    private SecondaryMenuMapper secondaryMenuMapper;

    @GetMapping("/insert")
    public int insert(SecondaryMenu secondaryMenu) {
        return secondaryMenuMapper.insert(secondaryMenu);
    }

    @GetMapping("/queryById")
    public SecondaryMenu queryById(int secondaryMenuId) {
        return secondaryMenuMapper.queryById(secondaryMenuId);
    }

    @GetMapping("/queryByUrl")
    public SecondaryMenu queryByUrl(String secondaryMenuUrl){
        return secondaryMenuMapper.queryByUrl(secondaryMenuUrl);
    }

    @GetMapping("/update")
    public int update(SecondaryMenu secondaryMenu) {
        return secondaryMenuMapper.update(secondaryMenu);
    }

    @GetMapping("/delete")
    public int delete(int secondaryMenuId) {
        return secondaryMenuMapper.delete(secondaryMenuId);
    }

    @GetMapping("/queryAll")
    public List<SecondaryMenu> queryAll() {
        return secondaryMenuMapper.queryAll();
    }

    @GetMapping("/queryByPrimaryMenuId")
    public List<SecondaryMenu> queryByPrimaryMenuId(int primaryMenuId) {
        return secondaryMenuMapper.queryByPrimaryMenuId(primaryMenuId);
    }
    
}
