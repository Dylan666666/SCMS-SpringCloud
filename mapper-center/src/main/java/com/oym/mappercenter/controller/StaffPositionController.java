package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.staff.StaffPosition;
import com.oym.mappercenter.mapper.StaffPositionMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 16:07
 */
@RestController()
@RequestMapping("/staffPositionMapper")
public class StaffPositionController {
    
    @Resource
    private StaffPositionMapper staffPositionMapper;

    @GetMapping("/insert")
    public int insert(StaffPosition position) {
        return staffPositionMapper.insert(position);
    }

    @GetMapping("/delete")
    public int delete(int staffPositionId) {
        return staffPositionMapper.delete(staffPositionId);
    }

    @GetMapping("/queryById")
    public StaffPosition queryById(int staffPositionId) {
        return staffPositionMapper.queryById(staffPositionId);
    }

    @GetMapping("/update")
    public int update(StaffPosition position) {
        return staffPositionMapper.update(position);
    }

    @GetMapping("/queryAll")
    public List<StaffPosition> queryAll()    {
        return staffPositionMapper.queryAll();
    }
    
}
