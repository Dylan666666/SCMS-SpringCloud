package com.ljl.warehouse.service.impl;

import com.ljl.warehouse.entity.staff.SecondaryMenu;
import com.ljl.warehouse.exceptions.SupermarketStaffException;
import com.ljl.warehouse.mapper.SecondaryMenuMapper;
import com.ljl.warehouse.service.SecondaryMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/10 16:08
 */
@Service
public class SecondaryMenuServiceImpl implements SecondaryMenuService {

    @Resource
    private SecondaryMenuMapper secondaryMenuMapper;
    
    @Override
    public int insert(SecondaryMenu secondaryMenu) throws SupermarketStaffException {
        isNull(secondaryMenu);
        try {
            int res = secondaryMenuMapper.insert(secondaryMenu);
            if (res == 0) {
                throw new SupermarketStaffException("添加失败");
            }
            return res;
        } catch (SupermarketStaffException e) {
            throw new SupermarketStaffException("添加失败");
        }
    }

    @Override
    public SecondaryMenu queryById(int secondaryMenuId) throws SupermarketStaffException {
        try {
            SecondaryMenu secondaryMenu = secondaryMenuMapper.queryById(secondaryMenuId);
            return secondaryMenu;
        } catch (SupermarketStaffException e) {
            throw new SupermarketStaffException("查询失败");
        }
    }

    @Override
    public SecondaryMenu queryByUrl(String secondaryMenuUrl) {
        try {
            SecondaryMenu secondaryMenu = secondaryMenuMapper.queryByUrl(secondaryMenuUrl);
            return secondaryMenu;
        } catch (SupermarketStaffException e) {
            throw new SupermarketStaffException("查询失败");
        }
    }

    @Override
    public int update(SecondaryMenu secondaryMenu) throws SupermarketStaffException {
        isNull(secondaryMenu);
        try {
            int res = secondaryMenuMapper.update(secondaryMenu);
            if (res == 0) {
                throw new SupermarketStaffException("更改信息失败");
            }
            return res;
        } catch (SupermarketStaffException e) {
            throw new SupermarketStaffException("更改信息失败");
        }
    }

    @Override
    public int delete(int secondaryMenuId) throws SupermarketStaffException {
        try {
            int res = secondaryMenuMapper.delete(secondaryMenuId);
            if (res == 0) {
                throw new SupermarketStaffException("删除失败");
            }
            return res;
        } catch (SupermarketStaffException e) {
            throw new SupermarketStaffException("删除失败");
        }
    }

    @Override
    public List<SecondaryMenu> queryAll() throws SupermarketStaffException {
        try {
            List<SecondaryMenu> secondaryMenuList = secondaryMenuMapper.queryAll();
            return secondaryMenuList;
        } catch (SupermarketStaffException e) {
            throw new SupermarketStaffException("查询失败");
        }
    }

    @Override
    public List<SecondaryMenu> queryByPrimaryMenuId(int primaryMenuId) {
        try {
            List<SecondaryMenu> secondaryMenuList = secondaryMenuMapper.queryByPrimaryMenuId(primaryMenuId);
            return secondaryMenuList;
        } catch (SupermarketStaffException e) {
            throw new SupermarketStaffException("查询失败");
        }
    }

    private void isNull(SecondaryMenu secondaryMenu) {
        if (secondaryMenu == null) {
            throw new SupermarketStaffException("传入信息为空");
        }
    }
    
}
