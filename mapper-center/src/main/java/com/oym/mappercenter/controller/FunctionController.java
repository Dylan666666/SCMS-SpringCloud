package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.staff.Function;
import com.oym.mappercenter.mapper.FunctionMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 11:10
 */
@RequestMapping("/functionMapper")
@RestController()
public class FunctionController {
    
    @Resource
    private FunctionMapper functionMapper;

    @GetMapping("/insert")
    public int insert(@Param("function") Function function) {
        return functionMapper.insert(function);
    }

    @GetMapping("/delete")
    public int delete(@Param("functionId") int functionId) {
        return functionMapper.delete(functionId);
    }

    @GetMapping("/queryById")
    public Function queryById(@Param("functionId") int functionId) {
        return functionMapper.queryById(functionId);
    }

    @GetMapping("/queryBySecondaryMenuId")
    public List<Function> queryBySecondaryMenuId(int id) {
        return functionMapper.queryBySecondaryMenuId(id);
    }

    @GetMapping("/update")
    public int update(Function function) {
        return functionMapper.update(function);
    }

    @GetMapping("/queryAll")
    public List<Function> queryAll() {
        return functionMapper.queryAll();
    }

    @GetMapping("/queryByUrl")
    public Function queryByUrl(String functionUrl) {
        return functionMapper.queryByUrl(functionUrl);
    }

}
