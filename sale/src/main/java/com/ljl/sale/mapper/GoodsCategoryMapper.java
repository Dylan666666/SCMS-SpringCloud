package com.ljl.sale.mapper;

import com.ljl.sale.entity.GoodsCategory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/11/18 13:54
 */
@FeignClient(name = "mapper-center")
@Service
public interface GoodsCategoryMapper {
    /**
     * 查询销售单位列表
     *
     * @return
     */
    @GetMapping("/goodsCategoryMapper/queryAll")
    List<GoodsCategory> queryAll();

    /**
     * 添加销售单位
     *
     * @param goodsCategory
     * @return
     */
    @GetMapping("/goodsCategoryMapper/insert")
    int insert(@RequestParam("goodsCategory") GoodsCategory goodsCategory);

    /**
     * 通过id查询
     * 
     * @param categoryId
     * @return
     */
    @GetMapping("/goodsCategoryMapper/queryById")
    GoodsCategory queryById(@RequestParam("categoryId") int categoryId);

    /**
     * 更新类别信息
     * 
     * @param goodsCategory
     * @return
     */
    @GetMapping("/goodsCategoryMapper/update")
    int update(@RequestParam("goodsCategory") GoodsCategory goodsCategory);

    /**
     * 通过id查询
     *
     * @param staffId
     * @return
     */
    @GetMapping("/goodsCategoryMapper/queryByStaffId")
    List<GoodsCategory> queryByStaffId(@RequestParam("staffId") int staffId);

    /**
     * 删除员工时调用，置空staffId
     *
     * @param stocktakingStaffId
     * @return
     */
    @GetMapping("/goodsCategoryMapper/updateByStaffId")
    int updateByStaffId(@RequestParam("stocktakingStaffId") int stocktakingStaffId);
}
