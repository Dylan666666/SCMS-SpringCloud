package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.Unit;
import com.oym.mappercenter.mapper.UnitMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 16:30
 */
@RestController()
@RequestMapping("/unitMapper")
public class UnitController {

    @Resource
    private UnitMapper unitMapper;

    @GetMapping("/insert")
    public int insert(Unit unit) {
        return unitMapper.insert(unit);
    }

    @GetMapping("/queryAll")
    public List<Unit> queryAll() {
        return unitMapper.queryAll();
    }

    @GetMapping("/queryById")
    public Unit queryById(int unitId) {
        return unitMapper.queryById(unitId);
    }

    @GetMapping("/update")
    public int update(Unit unit) {
        return unitMapper.update(unit);
    }
    
}
