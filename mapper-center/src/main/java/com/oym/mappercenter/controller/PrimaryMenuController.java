package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.staff.PrimaryMenu;
import com.oym.mappercenter.mapper.PrimaryMenuMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 14:46
 */
@RestController()
@RequestMapping("/primaryMenuMapper")
public class PrimaryMenuController {
    
    @Resource
    private PrimaryMenuMapper primaryMenuMapper;

    @GetMapping("/insert")
    public int insert(PrimaryMenu primaryMenu) {
        return primaryMenuMapper.insert(primaryMenu);
    }

    @GetMapping("/queryById")
    public PrimaryMenu queryById(int primaryMenuId) {
        return primaryMenuMapper.queryById(primaryMenuId);
    }

    @GetMapping("/update")
    public int update(PrimaryMenu primaryMenu) {
        return primaryMenuMapper.update(primaryMenu);
    }

    @GetMapping("/delete")
    public int delete(int primaryMenuId) {
        return primaryMenuMapper.delete(primaryMenuId);
    }

    @GetMapping("/queryAll")
    public List<PrimaryMenu> queryAll() {
        return primaryMenuMapper.queryAll();
    }
    
}
