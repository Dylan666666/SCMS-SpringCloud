package com.ljl.staff.service.impl;

import com.ljl.staff.cache.JedisUtil;
import com.ljl.staff.service.CacheService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/23 14:05
 */
@Service
public class CacheServiceImpl implements CacheService {

    @Resource
    private JedisUtil.Keys jedisKeys;
    
    @Override
    public void removeFromCache(String keyPrefix) {
        Set<String> keySet = jedisKeys.keys(keyPrefix + "*");
        for (String key : keySet) {
            jedisKeys.del(key);
        }
    }
}