package com.oym.mappercenter.controller;

import com.oym.mappercenter.entity.log.LoggingEvent;
import com.oym.mappercenter.mapper.LoggingEventMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2021/1/16 14:44
 */
@RestController()
@RequestMapping("/loggingEventMapper")
public class LoggingEventController {

    @Resource
    private LoggingEventMapper loggingEventMapper;

    @GetMapping("/queryAll")
    public List<LoggingEvent> queryAll(@Param("rowIndex") int rowIndex,
                                       @Param("pageSize") int pageSize) {
        return loggingEventMapper.queryAll(rowIndex, pageSize);
    }

    @GetMapping("/queryByCondition")
    public List<LoggingEvent> queryByCondition(@Param("loggingEventCondition") LoggingEvent loggingEventCondition,
                                               @Param("rowIndex") int rowIndex,
                                               @Param("pageSize") int pageSize) {
        return loggingEventMapper.queryByCondition(loggingEventCondition, rowIndex, pageSize);
    }

    @GetMapping("/delete")
    public int delete(Long eventId) {
        return loggingEventMapper.delete(eventId);
    }
    
}
