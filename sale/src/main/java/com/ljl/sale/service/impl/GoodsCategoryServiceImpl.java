package com.ljl.sale.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljl.sale.cache.JedisUtil;
import com.ljl.sale.entity.GoodsCategory;
import com.ljl.sale.exceptions.WareHouseManagerException;
import com.ljl.sale.mapper.GoodsCategoryMapper;
import com.ljl.sale.service.CacheService;
import com.ljl.sale.service.GoodsCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/18 16:27
 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
    
    @Resource
    private GoodsCategoryMapper goodsCategoryMapper;

    @Resource
    private JedisUtil.Keys jedisKeys;
    @Resource
    private JedisUtil.Strings jedisStrings;
    @Resource
    private CacheService cacheService;
    
    @Override
    public List<GoodsCategory> queryAll() throws WareHouseManagerException {
        String key = GOODS_CATEGORY_KEY;
        cacheService.removeFromCache(key);
        ObjectMapper mapper = new ObjectMapper();
        List<GoodsCategory> res = null;
        if (!jedisKeys.exists(key)) {
            res = goodsCategoryMapper.queryAll();
            String jsonString = null;
            try {
                jsonString = mapper.writeValueAsString(res);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                throw new WareHouseManagerException("查询产品类别失败");
            }
            jedisStrings.set(key, jsonString);
        } else {
            String jsonString = jedisStrings.get(key);
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, GoodsCategory.class);
            try {
                res = mapper.readValue(jsonString, javaType);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                throw new WareHouseManagerException("查询产品类别失败");
            }
        }
        return res;
    }

    @Override
    public int insert(GoodsCategory goodsCategory) throws WareHouseManagerException {
        if (goodsCategory == null && goodsCategory.getCategoryId() != null &&
        goodsCategory.getCategoryName() != null) {
            throw new WareHouseManagerException("传入信息不完整");
        } else {
            try {
                int res = goodsCategoryMapper.insert(goodsCategory);
                if (res == 0) {
                    throw new WareHouseManagerException("添加产品类别失败");
                }
                cacheService.removeFromCache(GOODS_CATEGORY_KEY);
                return res;
            } catch (WareHouseManagerException e) {
                throw new WareHouseManagerException("添加产品类别失败");
            }   
        }
    }

    @Override
    public GoodsCategory queryById(int categoryId) throws WareHouseManagerException {
        if (categoryId > 0) {
            try {
                GoodsCategory goodsCategory = goodsCategoryMapper.queryById(categoryId);
                return goodsCategory;
            } catch (WareHouseManagerException e) {
                throw new WareHouseManagerException("查询产品类别失败");
            }
        } else {
            throw new WareHouseManagerException("查询产品类别失败");
        }
    }

    @Override
    public List<GoodsCategory> queryByStaffId(int staffId)  throws WareHouseManagerException {
        if (staffId > 0) {
            try {
                List<GoodsCategory> goodsCategory = goodsCategoryMapper.queryByStaffId(staffId);
                return goodsCategory;
            } catch (WareHouseManagerException e) {
                throw new WareHouseManagerException("查询产品类别失败");
            }
        } else {
            throw new WareHouseManagerException("查询产品类别失败");
        }
    }

    @Override
    public int update(GoodsCategory goodsCategory) throws WareHouseManagerException {
        if (goodsCategory != null) {
            try {
                int res = goodsCategoryMapper.update(goodsCategory);
                return res;
            } catch (WareHouseManagerException e) {
                throw new WareHouseManagerException("更新产品类别失败");
            }
        } else {
            throw new WareHouseManagerException("更新产品类别失败");
        }
    }

    @Override
    public int updateByStaffId(int stocktakingStaffId) throws WareHouseManagerException {
        if (stocktakingStaffId > 0) {
            try {
                int res = goodsCategoryMapper.updateByStaffId(stocktakingStaffId);
                if (res == 0) {
                    throw new WareHouseManagerException("");
                }
                return res;
            } catch (WareHouseManagerException e) {
                throw new WareHouseManagerException("删除员工失败");
            }
        } else {
            throw new WareHouseManagerException("删除员工失败");
        }
    }
}
