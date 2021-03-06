package com.ljl.warehouse.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljl.warehouse.cache.JedisUtil;
import com.ljl.warehouse.entity.StocktakingRecord;
import com.ljl.warehouse.exceptions.WareHouseManagerException;
import com.ljl.warehouse.mapper.StocktakingRecordMapper;
import com.ljl.warehouse.service.CacheService;
import com.ljl.warehouse.service.StocktakingRecordService;
import com.ljl.warehouse.util.PageCalculator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/26 21:52
 */
@Service
public class StocktakingRecordServiceImpl implements StocktakingRecordService {
    
    @Resource
    private StocktakingRecordMapper stocktakingRecordMapper;

    @Resource
    private JedisUtil.Keys jedisKeys;
    @Resource
    private JedisUtil.Strings jedisStrings;
    @Resource
    private CacheService cacheService;
    
    @Override
    public int insert(StocktakingRecord stocktakingRecord) throws WareHouseManagerException {
        if (stocktakingRecord != null && stocktakingRecord.getStocktakingId() != null &&
        stocktakingRecord.getStocktakingLaunchedDate() != null) {
            try {
                int res = stocktakingRecordMapper.insert(stocktakingRecord);
                if (res == 0) {
                    throw new WareHouseManagerException("添加失败");
                }
                cacheService.removeFromCache(STOCKTAKING_RECORD_LIST_KEY);
                return res;
            } catch (WareHouseManagerException e ) {
                throw new WareHouseManagerException("添加失败");
            }
        } else {
            throw new WareHouseManagerException("添加失败");
        }
    }

    @Override
    public int update(StocktakingRecord stocktakingRecord) throws WareHouseManagerException {
        if (stocktakingRecord != null && stocktakingRecord.getStocktakingId() != null) {
            try {
                int res = stocktakingRecordMapper.update(stocktakingRecord);
                if (res == 0) {
                    throw new WareHouseManagerException("更改失败");
                }
                cacheService.removeFromCache(STOCKTAKING_RECORD_LIST_KEY);
                return res;
            } catch (WareHouseManagerException e ) {
                throw new WareHouseManagerException("更改失败");
            }
        } else {
            throw new WareHouseManagerException("信息不足，更改失败");
        }
    }

    @Override
    public StocktakingRecord queryById(Long stocktakingId) throws WareHouseManagerException {
        if (stocktakingId != null) {
            try {
                StocktakingRecord stocktakingRecord = stocktakingRecordMapper.queryById(stocktakingId);
                return stocktakingRecord;
            } catch (WareHouseManagerException e) {
                throw new WareHouseManagerException("查询失败");
            }
        } else {
            throw new WareHouseManagerException("信息不足，查询失败");
        }
    }

    @Override
    public List<StocktakingRecord> queryAll(int pageIndex, int pageSize) throws WareHouseManagerException {
        String key = STOCKTAKING_RECORD_LIST_KEY + pageIndex + pageSize;
        pageIndex = pageIndex >= 0 ? pageIndex : 0;
        pageSize = pageSize > 0 ? pageSize : 10000;
        int rowIndex = PageCalculator.calculatorRowIndex(pageIndex, pageSize);
        List<StocktakingRecord> res = null;
        ObjectMapper mapper = new ObjectMapper();
        if (pageIndex == 0) {
            if (!jedisKeys.exists(key)) {
                res = stocktakingRecordMapper.queryAll(rowIndex, pageSize);
                String jsonString = null;
                try {
                    jsonString = mapper.writeValueAsString(res);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    throw new WareHouseManagerException("查询失败");
                }
                jedisStrings.set(key, jsonString);
            } else {
                String jsonString = jedisStrings.get(key);
                JavaType javaType = mapper.getTypeFactory()
                        .constructParametricType(ArrayList.class, StocktakingRecord.class);
                try {
                    res = mapper.readValue(jsonString, javaType);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    throw new WareHouseManagerException("查询失败");
                }
            }
        } else {
            try {
                res = stocktakingRecordMapper.queryAll(rowIndex,  pageSize);
                return res;
            } catch (WareHouseManagerException e) {
                throw new WareHouseManagerException("查询失败");
            }
        }
        return res;
    }

    @Override
    public List<StocktakingRecord> queryByCondition(StocktakingRecord condition, int pageIndex, int pageSize) 
            throws WareHouseManagerException {
        if (condition != null) {
            int rowIndex = PageCalculator.calculatorRowIndex(pageIndex, pageSize);
            List<StocktakingRecord> stocktakingRecordList = stocktakingRecordMapper
                    .queryByCondition(condition, rowIndex, pageSize);
            return stocktakingRecordList;
        } else {
            throw new WareHouseManagerException("信息不足，查询失败");
        }
    }

    @Override
    public int queryStocktakingCount(int state) throws WareHouseManagerException {
        try {
            int res = stocktakingRecordMapper.queryStocktakingCount(state);
            return res;
        } catch (WareHouseManagerException e) {
            throw new WareHouseManagerException("查询失败");
        }
    }

    @Override
    public int getCount(String dateFormat) throws WareHouseManagerException {
        try {
            return stocktakingRecordMapper.getCount(dateFormat);
        } catch (WareHouseManagerException e) {
            throw new WareHouseManagerException("不具备获取Id条件，注册失败");
        }
    }
}
