package com.ljl.superManage.mapper;

import com.ljl.superManage.entity.staff.StaffPosition;
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
public interface StaffPositionMapper {

    /**
     * 添加职位信息
     *
     * @param position
     * @return
     */
    @GetMapping("/staffPositionMapper/insert")
    int insert(@RequestParam("position") StaffPosition position);

    /**
     * 删除职位信息
     *
     * @param staffPositionId
     * @return
     */
    @GetMapping("/staffPositionMapper/delete")
    int delete(@RequestParam("staffPositionId") int staffPositionId);

    /**
     * 通过职位id查询职位名
     *
     * @param staffPositionId
     * @return
     */
    @GetMapping("/staffPositionMapper/queryById")
    StaffPosition queryById(@RequestParam("staffPositionId") int staffPositionId);

    /**
     * 更改职位名
     *
     * @param position
     * @return
     */
    @GetMapping("/staffPositionMapper/update")
    int update(@RequestParam("position") StaffPosition position);

    /**
     * 一键查询
     * 
     * @return
     */
    @GetMapping("/staffPositionMapper/queryAll")
    List<StaffPosition> queryAll();
}
