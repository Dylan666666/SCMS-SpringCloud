package com.ljl.log.service.impl;

import com.ljl.log.entity.staff.StaffPositionRelation;
import com.ljl.log.exceptions.SupermarketStaffException;
import com.ljl.log.mapper.StaffPositionRelationMapper;
import com.ljl.log.service.StaffPositionRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/10 23:26
 */
@Service
public class StaffPositionRelationServiceImpl implements StaffPositionRelationService {
    
    @Resource
    private StaffPositionRelationMapper mapper;
    
    @Override
    public int insert(StaffPositionRelation position) throws SupermarketStaffException {
        isNull(position);
        try {
            int res = mapper.insert(position);
            if (res == 0) {
                throw new SupermarketStaffException("添加失败");
            }
            return res;
        } catch (SupermarketStaffException e) {
            throw new SupermarketStaffException("添加失败");
        }
    }

    @Override
    public int delete(StaffPositionRelation position) throws SupermarketStaffException {
        isNull(position);
        try {
            int res = mapper.delete(position);
            if (res == 0) {
                throw new SupermarketStaffException("删除失败");
            }
            return res;
        } catch (SupermarketStaffException e) {
            throw new SupermarketStaffException("删除失败");
        }
    }

    @Override
    public List<StaffPositionRelation> queryById(int staffId) throws SupermarketStaffException {
        try {
            List<StaffPositionRelation> res = mapper.queryById(staffId);
            return res;
        } catch (SupermarketStaffException e) {
            throw new SupermarketStaffException("查询失败");
        }
    }

    @Override
    public int update(StaffPositionRelation staffPositionRelation) throws SupermarketStaffException {
        isNull(staffPositionRelation);
        try {
            int res = mapper.update(staffPositionRelation);
            if (res == 0) {
                throw new SupermarketStaffException("更改状态失败");
            }
            return res;
        } catch (SupermarketStaffException e) {
            throw new SupermarketStaffException("更改状态失败");
        }
    }

    @Override
    public List<StaffPositionRelation> queryAll() throws SupermarketStaffException {
        try {
            List<StaffPositionRelation> res = mapper.queryAll();
            return res;
        } catch (SupermarketStaffException e) {
            throw new SupermarketStaffException("查询职工职位失败");
        }
    }

    private void isNull(StaffPositionRelation relation) {
        if (relation == null) {
            throw new SupermarketStaffException("传入信息为空");
        }
    }
}
