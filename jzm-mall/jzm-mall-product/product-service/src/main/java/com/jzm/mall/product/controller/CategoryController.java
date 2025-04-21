package com.jzm.mall.product.controller;


import com.jzm.mall.common.result.Result;
import com.jzm.mall.product.dto.*;
import com.jzm.mall.product.param.CategoryTrademarkParam;
import com.jzm.mall.product.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller：管理商品分类相关接口
 */
@Tag(name = "CategoryController", description = "商品分类接口")
@RestController
@RequestMapping("/admin/product")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询所有一级分类数据
     * URL 示例：GET /admin/product/getCategory1
     */
    @GetMapping("/getCategory1")
    public Result<List<FirstLevelCategoryDTO>> getFirstLevelCategory() {
        List<FirstLevelCategoryDTO> list = categoryService.getFirstLevelCategory();
        return Result.ok(list);
    }

    /**
     * 根据一级分类ID查询对应二级分类数据
     * URL 示例：GET /admin/product/getCategory2/1
     *
     * @param firstLevelCategoryId 一级分类ID
     */
    @GetMapping("/getCategory2/{firstLevelCategoryId}")
    public Result<List<SecondLevelCategoryDTO>> getSecondLevelCategory(@PathVariable Long firstLevelCategoryId) {
        List<SecondLevelCategoryDTO> list = categoryService.getSecondLevelCategory(firstLevelCategoryId);
        return Result.ok(list);
    }

    /**
     * 根据二级分类ID查询对应三级分类数据
     * URL 示例：GET /admin/product/getCategory3/10
     *
     * @param secondLevelCategoryId 二级分类ID
     */
    @GetMapping("/getCategory3/{secondLevelCategoryId}")
    public Result<List<ThirdLevelCategoryDTO>> getThirdLevelCategory(@PathVariable Long secondLevelCategoryId) {
        List<ThirdLevelCategoryDTO> list = categoryService.getThirdLevelCategory(secondLevelCategoryId);
        return Result.ok(list);
    }

    /**
     * 根据三级分类ID查询完整分类层级数据（包括一、二、三级）
     * URL 示例：GET /admin/product/getCategoryHierarchy/100
     *
     * @param thirdLevelCategoryId 三级分类ID
     */
    @GetMapping("/getCategoryHierarchy/{thirdLevelCategoryId}")
    public Result<CategoryHierarchyDTO> getCategoryHierarchy(@PathVariable Long thirdLevelCategoryId) {
        CategoryHierarchyDTO dto = categoryService.getCategoryViewByCategoryId(thirdLevelCategoryId);
        return Result.ok(dto);
    }

    /**
     * 保存分类与品牌的关联关系
     *
     * @param categoryTrademarkVo 包含三级分类ID和品牌ID列表的参数对象
     * @return 统一响应结果
     */
    @PostMapping("/baseCategoryTrademark/save")
    public Result save(@RequestBody CategoryTrademarkParam categoryTrademarkVo){
        // 调用服务层保存方法
        categoryService.save(categoryTrademarkVo);
        // 返回成功响应
        return Result.ok();
    }

    /**
     * 删除分类与品牌的关联关系
     *
     * @param thirdLevelCategoryId 三级分类ID
     * @param trademarkId 品牌ID
     * @return 统一响应结果
     */
    @DeleteMapping("/baseCategoryTrademark/remove/{thirdLevelCategoryId}/{trademarkId}")
    public Result remove(@PathVariable Long thirdLevelCategoryId, @PathVariable Long trademarkId){
        // 调用服务层删除方法
        categoryService.remove(thirdLevelCategoryId, trademarkId);
        // 返回成功响应
        return Result.ok();
    }

    /**
     * 查询三级分类关联的品牌列表
     *
     * @param thirdLevelCategoryId 三级分类ID
     * @return 包含品牌DTO列表的统一响应结果
     */
    @GetMapping("/baseCategoryTrademark/findTrademarkList/{thirdLevelCategoryId}")
    public Result findTrademarkList(@PathVariable Long thirdLevelCategoryId){
        // 调用服务层查询方法
        List<TrademarkDTO> list = categoryService.findTrademarkList(thirdLevelCategoryId);
        // 返回数据
        return Result.ok(list);
    }

    /**
     * 查询三级分类未关联的品牌列表
     * 用于前端添加关联时选择
     *
     * @param thirdLevelCategoryId 三级分类ID
     * @return 包含未关联品牌DTO列表的统一响应结果
     */
    @GetMapping("/baseCategoryTrademark/findCurrentTrademarkList/{thirdLevelCategoryId}")
    public Result findCurrentTrademarkList(@PathVariable Long thirdLevelCategoryId){
        // 调用服务层查询方法
        List<TrademarkDTO> list = categoryService.findUnLinkedTrademarkList(thirdLevelCategoryId);
        // 返回数据
        return Result.ok(list);
    }
}