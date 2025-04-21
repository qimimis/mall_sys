package com.jzm.mall.product.service;

import com.jzm.mall.product.dto.*;
import com.jzm.mall.product.param.CategoryTrademarkParam;

import java.util.List;

/**
 * Service 接口：商品分类相关业务接口
 */
public interface CategoryService {

    /**
     * 查询所有一级分类
     *
     * @return List of FirstLevelCategoryDTO
     */
    List<FirstLevelCategoryDTO> getFirstLevelCategory();

    /**
     * 根据一级分类ID查询对应的二级分类数据
     *
     * @param firstLevelCategoryId 一级分类ID
     * @return List of SecondLevelCategoryDTO
     */
    List<SecondLevelCategoryDTO> getSecondLevelCategory(Long firstLevelCategoryId);

    /**
     * 根据二级分类ID查询对应的三级分类数据
     *
     * @param secondLevelCategoryId 二级分类ID
     * @return List of ThirdLevelCategoryDTO
     */
    List<ThirdLevelCategoryDTO> getThirdLevelCategory(Long secondLevelCategoryId);

    /**
     * 根据三级分类ID获取完整分类层级数据（一二三级）
     *
     * @param thirdLevelCategoryId 三级分类ID
     * @return CategoryHierarchyDTO
     */
    CategoryHierarchyDTO getCategoryViewByCategoryId(Long thirdLevelCategoryId);

    /**
     * 根据三级分类获取品牌
     *
     * @param category3Id 三级分类ID
     * @return 该三级分类关联的品牌DTO列表
     */
    List<TrademarkDTO> findTrademarkList(Long category3Id);

    /**
     * 保存分类与品牌关联
     * 为指定的三级分类批量添加品牌关联
     *
     * @param categoryTrademarkParam 包含三级分类ID和品牌ID列表的参数对象
     */
    void save(CategoryTrademarkParam categoryTrademarkParam);

    /**
     * 获取当前未被三级分类关联的所有品牌
     * 用于前端添加关联时选择可用品牌
     *
     * @param thirdLevelCategoryId 三级分类ID
     * @return 未关联的品牌DTO列表
     */
    List<TrademarkDTO> findUnLinkedTrademarkList(Long thirdLevelCategoryId);

    /**
     * 删除关联
     * 解除特定三级分类与特定品牌的关联关系
     *
     * @param thirdLevelCategoryId 三级分类ID
     * @param trademarkId 品牌ID
     */
    void remove(Long thirdLevelCategoryId, Long trademarkId);
}