package com.jzm.mall.product.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jzm.mall.common.result.Result;
import com.jzm.mall.product.dto.SpuImageDTO;
import com.jzm.mall.product.dto.SpuInfoPageDTO;
import com.jzm.mall.product.dto.SpuPosterDTO;
import com.jzm.mall.product.dto.SpuSaleAttributeInfoDTO;
import com.jzm.mall.product.entity.SpuInfo;
import com.jzm.mall.product.param.SpuInfoParam;
import com.jzm.mall.product.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * SPU管理控制器
 * 处理SPU相关的HTTP请求，提供SPU信息的增删改查功能
 */
@RestController
@RequestMapping("admin/product")
public class SpuManageController {

    /**
     * SPU服务
     */
    @Autowired
    private SpuService spuService;

    /**
     * 分页获取SPU信息列表
     *
     * @param page 当前页码
     * @param size 每页大小
     * @param spuInfoParam SPU信息查询参数
     * @return 包含SPU分页信息的结果对象
     */
    @GetMapping("{page}/{size}")
    public Result getSpuInfoPage(@PathVariable Long page,
                                 @PathVariable Long size,
                                 SpuInfoParam spuInfoParam) {
        // 构建分页对象
        Page<SpuInfo> spuInfoPage = new Page<>(page, size);
        // 调用服务获取分页数据
        SpuInfoPageDTO spuInfoPageDTO = spuService.getSpuInfoPage(spuInfoPage, spuInfoParam);
        // 返回成功结果及数据
        return Result.ok(spuInfoPageDTO);
    }

    /**
     * 保存SPU信息
     * 包括基本信息、图片、销售属性、海报等
     *
     * @param spuInfoParam SPU信息参数
     * @return 操作结果
     */
    @PostMapping("saveSpuInfo")
    public Result saveSpuInfo(@RequestBody SpuInfoParam spuInfoParam) {
        // 调用服务保存SPU信息
        spuService.saveSpuInfo(spuInfoParam);
        // 返回成功结果
        return Result.ok();
    }

    /**
     * 根据SPU ID获取图片列表
     *
     * @param spuId SPU ID
     * @return 包含SPU图片列表的结果对象
     */
    @GetMapping("spuImageList/{spuId}")
    public Result<List<SpuImageDTO>> getSpuImageList(@PathVariable("spuId") Long spuId) {
        // 调用服务获取SPU图片列表
        List<SpuImageDTO> spuImageList = spuService.getSpuImageList(spuId);
        // 返回成功结果及数据
        return Result.ok(spuImageList);
    }

    /**
     * 根据SPU ID获取销售属性列表
     *
     * @param spuId SPU ID
     * @return 包含SPU销售属性列表的结果对象
     */
    @GetMapping("spuSaleAttrList/{spuId}")
    public Result<List<SpuSaleAttributeInfoDTO>> getSpuSaleAttrList(@PathVariable("spuId") Long spuId) {
        // 调用服务获取SPU销售属性列表
        List<SpuSaleAttributeInfoDTO> spuSaleAttrList = spuService.getSpuSaleAttrList(spuId);
        // 返回成功结果及数据
        return Result.ok(spuSaleAttrList);
    }

    /**
     * 根据SPU ID获取海报列表
     *
     * @param spuId SPU ID
     * @return 包含SPU海报列表的结果对象
     */
    @GetMapping("spuPosterList/{spuId}")
    public Result<List<SpuPosterDTO>> getSpuPosterList(@PathVariable("spuId") Long spuId) {
        // 调用服务获取SPU海报列表
        List<SpuPosterDTO> spuPosterList = spuService.findSpuPosterBySpuId(spuId);
        // 返回成功结果及数据
        return Result.ok(spuPosterList);
    }

    /**
     * 获取SKU销售属性值组合映射
     * 用于前端快速切换SKU
     *
     * @param spuId SPU ID
     * @return 包含销售属性值组合映射的结果对象
     */
//    @GetMapping("skuValueIdsMap/{spuId}")
//    public Result<Map<String, Long>> getSkuValueIdsMap(@PathVariable("spuId") Long spuId) {
//        // 调用服务获取SKU销售属性值组合映射
//        Map<String, Long> skuValueIdsMap = spuService.getSkuValueIdsMap(spuId);
//        // 返回成功结果及数据
//        return Result.ok(skuValueIdsMap);
//    }
}
