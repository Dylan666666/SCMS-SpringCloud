package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.staff.StaffPositionRelation;
import com.oym.mappercenter.mapper.StaffPositionRelationMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 16:12
 */
@RestController()
@RequestMapping("/staffPositionRelationMapper")
public class StaffPositionRelationController {

    @Resource
    private StaffPositionRelationMapper staffPositionRelationMapper;

    @GetMapping("/insert")
    public int insert(StaffPositionRelation position) {
        return staffPositionRelationMapper.insert(position);
    }
    
    @GetMapping("/delete")
    public int delete(StaffPositionRelation position) {
        return staffPositionRelationMapper.delete(position);
    }

    @GetMapping("/queryById")
    public List<StaffPositionRelation> queryById(int staffId) {
        return staffPositionRelationMapper.queryById(staffId);
    }

    @GetMapping("/update")
    public int update(StaffPositionRelation staffPositionRelation) {
        return staffPositionRelationMapper.update(staffPositionRelation);
    }

    @GetMapping("/queryAll")
    public List<StaffPositionRelation> queryAll() {
        return staffPositionRelationMapper.queryAll();
    }
    
}
