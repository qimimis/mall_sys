package com.jzm.mall.product.controller;

import com.jzm.mall.common.result.Result;
import com.jzm.mall.product.dto.PlatformAttributeInfoDTO;
import com.jzm.mall.product.param.PlatformAttributeParam;
import com.jzm.mall.product.service.PlatformAttributeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "平台属性管理接口", description = "用于管理平台属性的相关接口")
@RestController
@RequestMapping("admin/product")
public class PlatformAttributeController {

    @Autowired
    private PlatformAttributeService platformAttributeService;

    /**
     * 根据分类ID获取平台属性列表
     */
    @Operation(summary = "根据分类ID获取平台属性", description = "通过一级、二级、三级分类ID获取对应的平台属性列表")
    @GetMapping("/attrInfoList/{firstLevelCategoryId}/{secondLevelCategoryId}/{thirdLevelCategoryId}")
    public Result<List<PlatformAttributeInfoDTO>> getPlatformAttrInfoList(
            @Parameter(description = "一级分类ID", required = true)
            @PathVariable("firstLevelCategoryId") Long firstLevelCategoryId,
            @Parameter(description = "二级分类ID", required = true)
            @PathVariable("secondLevelCategoryId") Long secondLevelCategoryId,
            @Parameter(description = "三级分类ID", required = true)
            @PathVariable("thirdLevelCategoryId") Long thirdLevelCategoryId) {

        List<PlatformAttributeInfoDTO> platformAttributeInfoDTOS = platformAttributeService
                .getPlatformAttrInfoList(firstLevelCategoryId, secondLevelCategoryId, thirdLevelCategoryId);

        return Result.ok(platformAttributeInfoDTOS);
    }

    /**
     * 保存或修改平台属性
     */
    @Operation(summary = "保存或修改平台属性", description = "添加新的平台属性或更新已有的平台属性信息")
    @PostMapping("/saveAttrInfo")
    public Result savePlatformAttrInfo(@RequestBody PlatformAttributeParam platformAttributeParam) {
        platformAttributeService.savePlatformAttrInfo(platformAttributeParam);
        return Result.ok();
    }

    /**
     * 根据属性ID获取平台属性详情
     */
    @Operation(summary = "根据属性ID获取平台属性详情", description = "获取指定ID的平台属性的详细信息")
    @GetMapping("/getAttrValueList/{attrId}")
    public Result<PlatformAttributeInfoDTO> getPlatformAttrInfo(
            @Parameter(description = "属性ID", required = true)
            @PathVariable Long attrId) {

        PlatformAttributeInfoDTO platformAttributeInfoDTO = platformAttributeService.getPlatformAttrInfo(attrId);
        return Result.ok(platformAttributeInfoDTO);
    }
}