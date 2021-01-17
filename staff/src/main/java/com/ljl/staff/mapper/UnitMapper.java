package com.ljl.staff.mapper;

import com.ljl.staff.entity.Unit;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/18 13:41
 */
@FeignClient(name = "mapper-center")
@Service
public interface UnitMapper {
    /**
     * 查询销售单位列表
     *
     * @return
     */
    @GetMapping("/unitMapper/queryAll")
    List<Unit> queryAll();

    /**
     * 添加销售单位
     * 
     * @param unit
     * @return
     */
    @GetMapping("/unitMapper/insert")
    int insert(@RequestParam("unit") Unit unit);

    /**
     * ID查询单位
     * 
     * @param unitId
     * @return
     */
    @GetMapping("/unitMapper/queryById")
    Unit queryById(@RequestParam("unitId") int unitId);

    /**
     * 更新销售单位
     *
     * @param unit
     * @return
     */
    @GetMapping("/unitMapper/update")
    int update(@RequestParam("unit") Unit unit);
}
