package com.ljl.log.service;

import com.ljl.log.entity.staff.StaffPosition;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/10 20:42
 */
public interface StaffPositionService {

    /**
     * 添加职位信息
     *
     * @param position
     * @return
     */
    int insert(StaffPosition position);

    /**
     * 删除职位信息
     *
     * @param staffPositionId
     * @return
     */
    int delete(int staffPositionId);

    /**
     * 通过职位id查询职位名
     *
     * @param staffPositionId
     * @return
     */
    StaffPosition queryById(int staffPositionId);

    /**
     * 更改职位名
     *
     * @param position
     * @return
     */
    int update(StaffPosition position);

    /**
     * 一键查询
     *
     * @return
     */
    List<StaffPosition> queryAll();
}
