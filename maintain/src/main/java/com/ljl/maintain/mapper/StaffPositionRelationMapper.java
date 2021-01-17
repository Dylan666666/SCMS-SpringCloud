package com.ljl.maintain.mapper;

import com.ljl.maintain.entity.staff.StaffPositionRelation;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/9 21:35
 */
@FeignClient(name = "mapper-center")
@Service
public interface StaffPositionRelationMapper {

    /**
     * 添加职工职位信息
     *
     * @param position
     * @return
     */
    @GetMapping("/staffPositionRelationMapper/insert")
    int insert(@RequestParam("position") StaffPositionRelation position);

    /**
     * 删除职工职位信息
     *
     * @param position
     * @return
     */
    @GetMapping("/staffPositionRelationMapper/delete")
    int delete(@RequestParam("position") StaffPositionRelation position);

    /**
     * 通过职位id查询职工职位行数据
     *
     * @param staffId
     * @return
     */
    @GetMapping("/staffPositionRelationMapper/queryById")
    List<StaffPositionRelation> queryById(@RequestParam("staffId") int staffId);

    /**
     * 更改职位状态
     *
     * @param staffPositionRelation
     * @return
     */
    @GetMapping("/staffPositionRelationMapper/update")
    int update(@RequestParam("staffPositionRelation") StaffPositionRelation staffPositionRelation);

    /**
     * 一键查询
     * 
     * @return
     */
    @GetMapping("/staffPositionRelationMapper/queryAll")
    List<StaffPositionRelation> queryAll();
}
