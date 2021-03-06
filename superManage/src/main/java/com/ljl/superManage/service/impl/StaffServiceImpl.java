package com.ljl.superManage.service.impl;

import com.ljl.superManage.cache.JedisUtil;
import com.ljl.superManage.entity.staff.StaffPositionRelation;
import com.ljl.superManage.exceptions.WareHouseManagerException;
import com.ljl.superManage.mapper.*;
import com.ljl.superManage.entity.SupermarketStaff;
import com.ljl.superManage.enums.StaffStatusStateEnum;
import com.ljl.superManage.exceptions.SupermarketStaffException;
import com.ljl.superManage.service.CacheService;
import com.ljl.superManage.service.StaffService;
import com.ljl.superManage.util.PageCalculator;
import com.ljl.superManage.util.PasswordHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/2 14:18
 */
@Service
@Slf4j
public class StaffServiceImpl implements StaffService {

    @Resource
    private SupermarketStaffMapper staffMapper;

    @Resource
    private StaffPositionRelationMapper staffPositionRelationMapper;

    @Resource
    private JedisUtil.Keys jedisKeys;
    @Resource
    private JedisUtil.Strings jedisStrings;
    @Resource
    private CacheService cacheService;

    @Override
    public SupermarketStaff queryStaffByPhone(String staffPhone) throws SupermarketStaffException {
        if (staffPhone != null) {
            try {
                SupermarketStaff staff = staffMapper.queryStaffByPhone(staffPhone);
                return staff;
            } catch (SupermarketStaffException e) {
                throw new SupermarketStaffException("查询失败");
            }
        } else {
            throw new SupermarketStaffException("信息为空");
        }
    }

    @Override
    public int insertStaff(SupermarketStaff staff) throws SupermarketStaffException {
        if (staff != null && staff.getStaffPhone() != null && staff.getStaffPassword() != null &&
                staff.getStaffName() != null) {
            try {
                if (staffMapper.queryStaffByPhone(staff.getStaffPhone()) != null) {
                    throw new SupermarketStaffException("该手机号已被注册");
                }
                staff.setSalt(ByteSource.Util.bytes(staff.getStaffPhone()).toString());
                staff.setLastEditTime(new Date());
                staff.setCreateTime(new Date());
                staff.setStaffStatus(StaffStatusStateEnum.JUST_REGISTERED.getState());
                new PasswordHelper().encryptPassword(staff);
                int res = staffMapper.insertStaff(staff);
                if (res == 0) {
                    throw new SupermarketStaffException("注册失败");
                }
                log.info("------手机号:" + staff.getStaffPhone() + " 用户已注册 ------");
                cacheService.removeFromCache(STAFF_LIST_KEY);
                return res;
            } catch (SupermarketStaffException e) {
                throw new SupermarketStaffException("注册失败");
            }
        } else {
            throw new SupermarketStaffException("必要信息为空");
        }
    }

    @Override
    public int updateStaff(SupermarketStaff staff) throws SupermarketStaffException {
        if (staff != null && staff.getStaffId() != null) {
            try {
                staff.setLastEditTime(new Date());
                int res = staffMapper.updateStaff(staff);
                if (res == 0) {
                    throw new SupermarketStaffException("信息更改失败");
                }
                cacheService.removeFromCache(STAFF_LIST_KEY);
                return res;
            } catch (SupermarketStaffException e) {
                throw new SupermarketStaffException("信息更改失败");
            }
        } else {
            throw new SupermarketStaffException("信息为空");
        }
    }

    @Override
    public int updateStaffPosition(SupermarketStaff staff) throws SupermarketStaffException {
        if (staff != null && staff.getStaffId() != null && staff.getStaffPhone() != null
                && staff.getStaffPosition() != null) {
            try {
                SupermarketStaff curStaff = staffMapper.queryStaffByPhone(staff.getStaffPhone());
                if (curStaff.getStaffPosition() == null) {
                    //插入职工职位表
                    StaffPositionRelation relation = new StaffPositionRelation();
                    relation.setStaffPositionStatus(1);
                    relation.setStaffPositionId(staff.getStaffPosition());
                    relation.setStaffId(staff.getStaffId());
                    int res1 = staffPositionRelationMapper.insert(relation);
                    if (res1 == 0) {
                        throw new SupermarketStaffException("更改职位失败");
                    }
                } else {
                    StaffPositionRelation relation = new StaffPositionRelation();
                    //删除职工职位行数据
                    relation.setStaffId(staff.getStaffId());
                    relation.setStaffPositionId(curStaff.getStaffPosition());
                    staffPositionRelationMapper.delete(relation);
                    //添加职工职位行数据
                    relation.setStaffPositionStatus(1);
                    relation.setStaffPositionId(staff.getStaffPosition());
                    int res1 = staffPositionRelationMapper.insert(relation);
                    if (res1 == 0) {
                        throw new SupermarketStaffException("更改职位失败");
                    }
                }
            } catch (SupermarketStaffException e) {
                throw new SupermarketStaffException("更改职位失败");
            }
        } else {
            throw new SupermarketStaffException("信息为空");
        }
        return 1;
    }

    @Override
    public SupermarketStaff staffLogin(String staffPhone, String staffPassword) throws SupermarketStaffException {
        // 获取Subject实例对象，用户实例
        Subject currentUser = SecurityUtils.getSubject();
        // 将用户名和密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(staffPhone, staffPassword);

        SupermarketStaff staff;

        //认证
        try {
            // 传到 MyShiroRealm 类中的方法进行认证
            currentUser.login(token);
            // 构建缓存用户信息返回给前端
            staff = (SupermarketStaff) currentUser.getPrincipals().getPrimaryPrincipal();
            //设置TOKEN返回给前端
            staff.setToken(currentUser.getSession().getId().toString());

        } catch (UnknownAccountException e) {
            throw new SupermarketStaffException("账号不存在!");
        } catch (IncorrectCredentialsException e) {
            throw new SupermarketStaffException("密码不正确!");
        } catch (AuthenticationException e) {
            throw new SupermarketStaffException("用户验证失败!");
        }
        return staff;
    }

    @Override
    public List<SupermarketStaff> queryStaffByCondition(SupermarketStaff staffCondition, int pageIndex, int pageSize)
            throws SupermarketStaffException{
        if (staffCondition == null) {
            throw new WareHouseManagerException("传入信息为空，查询失败");
        }
        int rowIndex = PageCalculator.calculatorRowIndex(pageIndex, pageSize);
        try {
            List<SupermarketStaff> res = staffMapper.queryStaffByCondition(staffCondition, rowIndex, pageSize);
            return res;
        } catch (WareHouseManagerException e) {
            throw new WareHouseManagerException("查询失败");
        }
    }

    @Override
    public void staffLogout(String staffToken) throws SupermarketStaffException {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

    @Override
    public SupermarketStaff queryById(int staffId) throws SupermarketStaffException {
        if (staffId > 0) {
            try {
                SupermarketStaff staff = staffMapper.queryById(staffId);
                return staff;
            } catch (SupermarketStaffException e) {
                throw new SupermarketStaffException("查询职工信息失败");
            }
        } else {
            throw new SupermarketStaffException("查询职工信息失败");
        }
    }

    @Override
    public int deleteStaff(int staffId) throws SupermarketStaffException {
        if (staffId > 0) {
            try {
                int res = staffMapper.deleteStaff(staffId);
                if (res == 0) {
                    throw new SupermarketStaffException("删除职工失败");
                }
                cacheService.removeFromCache(STAFF_LIST_KEY);
                return res;
            } catch (SupermarketStaffException e) {
                throw new SupermarketStaffException("删除职工失败");
            }
        } else {
            throw new SupermarketStaffException("删除职工失败");
        }
    }

    @Override
    public int countStaffAll() throws SupermarketStaffException {
        try {
            int res = staffMapper.countStaffAll();
            return res;
        } catch (SupermarketStaffException e) {
            throw new SupermarketStaffException("查询职工数量失败");
        }
    }
}
