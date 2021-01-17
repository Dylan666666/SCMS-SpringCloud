package com.ljl.log.mapper;

import com.ljl.log.entity.log.LoggingEvent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/12/13 17:59
 */
@FeignClient(name = "mapper-center")
@Service
public interface LoggingEventMapper {

    /**
     * 一键查询日志记录
     * 
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/loggingEventMapper/queryAll")
    List<LoggingEvent> queryAll(@RequestParam("rowIndex") int rowIndex,
                                @RequestParam("pageSize") int pageSize);


    /**
     * 模糊查询日志记录
     * 
     * @param loggingEventCondition
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/loggingEventMapper/queryByCondition")
    List<LoggingEvent> queryByCondition(@RequestParam("loggingEventCondition") LoggingEvent loggingEventCondition,
                                        @RequestParam("rowIndex") int rowIndex,
                                        @RequestParam("pageSize") int pageSize);

    /**
     * 删除日志
     * 
     * @param eventId
     * @return
     */
    @GetMapping("/loggingEventMapper/delete")
    int delete(@RequestParam("eventId") Long eventId);
}
