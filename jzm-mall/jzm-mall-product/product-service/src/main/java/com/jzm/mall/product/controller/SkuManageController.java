package com.jzm.mall.product.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jzm.mall.common.result.Result;
import com.jzm.mall.product.dto.SkuInfoPageDTO;
import com.jzm.mall.product.model.SkuInfo;
import com.jzm.mall.product.param.SkuInfoParam;
import com.jzm.mall.product.service.SkuService;
import com.jzm.mall.product.service.SpuService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * SKU管理控制器
 * 提供SKU相关的HTTP接口，包括保存、查询、上架、下架等操作
 */
@Tag(name = "商品SKU接口", description = "商品SKU接口")
@RestController
@RequestMapping("admin/product")
public class SkuManageController {

    @Autowired
    private SpuService spuService; // SPU服务

    @Autowired
    private SkuService skuService; // SKU服务

    /**
     * 保存SKU信息
     * HTTP POST请求
     *
     * @param skuInfo SKU信息参数对象
     * @return 操作结果
     */
    @PostMapping("saveSkuInfo")
    public Result saveSkuInfo(@RequestBody SkuInfoParam skuInfo) {
        // 调用服务层保存SKU信息
        skuService.saveSkuInfo(skuInfo);
        return Result.ok();
    }

    /**
     * 分页查询SKU列表
     * HTTP GET请求
     *
     * @param page 页码
     * @param limit 每页记录数
     * @return 包含分页数据的结果对象
     */
    @GetMapping("/list/{page}/{limit}")
    public Result index(
            @PathVariable Long page,
            @PathVariable Long limit) {
        // 创建分页参数对象
        Page<SkuInfo> pageParam = new Page<>(page, limit);
        // 调用服务层获取分页数据
        SkuInfoPageDTO skuInfoPageDTO = skuService.getPage(pageParam);
        // 返回结果
        return Result.ok(skuInfoPageDTO);
    }

    /**
     * 商品上架
     * HTTP GET请求
     *
     * @param skuId SKU的ID
     * @return 操作结果
     */
    @GetMapping("onSale/{skuId}")
    public Result onSale(@PathVariable("skuId") Long skuId) {
        // 调用服务层上架商品
        skuService.onSale(skuId);
        return Result.ok();
    }

    /**
     * 商品下架
     * HTTP GET请求
     *
     * @param skuId SKU的ID
     * @return 操作结果
     */
    @GetMapping("cancelSale/{skuId}")
    public Result cancelSale(@PathVariable("skuId") Long skuId) {
        // 调用服务层下架商品
        skuService.offSale(skuId);
        return Result.ok();
    }
}