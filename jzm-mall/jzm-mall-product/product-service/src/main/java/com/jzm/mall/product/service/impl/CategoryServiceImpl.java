package com.jzm.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jzm.mall.product.converter.CategoryConverter;
import com.jzm.mall.product.converter.TrademarkConverter;
import com.jzm.mall.product.dto.*;
import com.jzm.mall.product.mapper.*;
import com.jzm.mall.product.model.*;
import com.jzm.mall.product.param.CategoryTrademarkParam;
import com.jzm.mall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service 实现类：商品分类相关业务逻辑
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private FirstLevelCategoryMapper firstLevelCategoryMapper;

    @Autowired
    private SecondLevelCategoryMapper secondLevelCategoryMapper;

    @Autowired
    private ThirdLevelCategoryMapper thirdLevelCategoryMapper;

    @Autowired
    private CategoryHierarchyMapper categoryHierarchyMapper;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public List<FirstLevelCategoryDTO> getFirstLevelCategory() {
        // 调用 MyBatis-Plus 提供的 selectList 方法查询所有一级分类数据
        List<FirstLevelCategory> firstLevelCategories = firstLevelCategoryMapper.selectList(null);
        // 将 PO 列表转换为 DTO 列表并返回
        return categoryConverter.firstLevelCategoryPOs2DTOs(firstLevelCategories);
    }

    @Override
    public List<SecondLevelCategoryDTO> getSecondLevelCategory(Long firstLevelCategoryId) {
        // 构造查询条件，根据一级分类ID筛选二级分类数据
        LambdaQueryWrapper<SecondLevelCategory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SecondLevelCategory::getFirstLevelCategoryId, firstLevelCategoryId);
        List<SecondLevelCategory> secondLevelCategories = secondLevelCategoryMapper.selectList(queryWrapper);
        // 转换 PO 列表为 DTO 列表
        return categoryConverter.secondLevelCategoryPOs2DTOs(secondLevelCategories);
    }

    @Override
    public List<ThirdLevelCategoryDTO> getThirdLevelCategory(Long secondLevelCategoryId) {
        // 根据二级分类ID构造查询条件筛选三级分类数据
        LambdaQueryWrapper<ThirdLevelCategory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ThirdLevelCategory::getSecondLevelCategoryId, secondLevelCategoryId);
        List<ThirdLevelCategory> thirdLevelCategories = thirdLevelCategoryMapper.selectList(queryWrapper);
        // PO -> DTO 转换
        return categoryConverter.thirdLevelCategoryPOs2DTOs(thirdLevelCategories);
    }

    @Override
    public CategoryHierarchyDTO getCategoryViewByCategoryId(Long thirdLevelCategoryId) {
        // 调用自定义 SQL（XML 配置）查询完整的分类层级数据
        List<CategoryHierarchy> categoryHierarchies = categoryHierarchyMapper.selectCategoryHierarchy(thirdLevelCategoryId);
        // 当查询结果为空，返回 null；否则转换首条数据返回
        if (CollectionUtils.isEmpty(categoryHierarchies)) {
            return null;
        }
        return categoryConverter.categoryViewPO2DTO(categoryHierarchies.get(0));
    }

    @Autowired
    private CategoryTrademarkMapper categoryTrademarkMapper;

    @Autowired
    private TrademarkMapper trademarkMapper;

    @Autowired
    private TrademarkConverter trademarkConverter;

    /**
     * 根据三级分类ID查询已关联的品牌列表
     *
     * @param category3Id 三级分类ID
     * @return 已关联的品牌DTO列表
     */
    @Override
    public List<TrademarkDTO> findTrademarkList(Long category3Id) {
        // 构建查询条件，根据三级分类ID查询关联表
        LambdaQueryWrapper<CategoryTrademark> categoryTrademarkQueryWrapper = new LambdaQueryWrapper<>();
        categoryTrademarkQueryWrapper.eq(CategoryTrademark::getThirdLevelCategoryId, category3Id);

        // 执行查询，获取分类品牌关联列表
        List<CategoryTrademark> categoryTrademarks = categoryTrademarkMapper.selectList(categoryTrademarkQueryWrapper);

        // 判断查询结果是否为空
        if(!CollectionUtils.isEmpty(categoryTrademarks)){
            // 使用Stream API提取所有关联的品牌ID
            List<Long> tradeMarkIdList = categoryTrademarks.stream()
                    .map(CategoryTrademark::getTrademarkId)
                    .collect(Collectors.toList());

            // 根据品牌ID列表批量查询品牌信息
            List<Trademark> trademarks = trademarkMapper.selectBatchIds(tradeMarkIdList);

            // 将实体对象转换为DTO对象并返回
            List<TrademarkDTO> trademarkDTOs = trademarkConverter.trademarkPOs2DTOs(trademarks);
            return trademarkDTOs;
        }
        // 如果没有关联的品牌，返回null
        return null;
    }

    /**
     * 保存分类与品牌的关联关系
     * 批量创建三级分类与多个品牌的关联
     *
     * @param categoryTrademarkParam 包含三级分类ID和品牌ID列表的参数
     */
    @Override
    public void save(CategoryTrademarkParam categoryTrademarkParam) {
        // 获取品牌ID列表
        List<Long> trademarkIdList = categoryTrademarkParam.getTrademarkIdList();

        // 判断品牌ID列表是否为空
        if (!CollectionUtils.isEmpty(trademarkIdList)){
            // 使用Stream API处理每个品牌ID，创建关联关系并保存
            trademarkIdList.stream()
                    .map((trademarkId) -> {
                        // 创建一个分类与品牌的关联对象
                        CategoryTrademark categoryTrademark = new CategoryTrademark();
                        categoryTrademark.setThirdLevelCategoryId(categoryTrademarkParam.getCategory3Id());
                        categoryTrademark.setTrademarkId(trademarkId);
                        return categoryTrademark;
                    })
                    .forEach(categoryTrademark -> categoryTrademarkMapper.insert(categoryTrademark));
        }
    }

    /**
     * 查询未被指定三级分类关联的品牌列表
     *
     * @param category3Id 三级分类ID
     * @return 未关联的品牌DTO列表
     */
    @Override
    public List<TrademarkDTO> findUnLinkedTrademarkList(Long category3Id) {
        // 查询哪些品牌已经与该三级分类关联
        LambdaQueryWrapper<CategoryTrademark> baseCategoryTrademarkQueryWrapper = new LambdaQueryWrapper<>();
        baseCategoryTrademarkQueryWrapper.eq(CategoryTrademark::getThirdLevelCategoryId, category3Id);
        List<CategoryTrademark> baseCategoryTrademarkList = categoryTrademarkMapper.selectList(baseCategoryTrademarkQueryWrapper);

        // 如果有已关联的品牌
        if (!CollectionUtils.isEmpty(baseCategoryTrademarkList)){
            // 提取已关联的品牌ID列表
            List<Long> tradeMarkIdList = baseCategoryTrademarkList.stream()
                    .map(CategoryTrademark::getTrademarkId)
                    .collect(Collectors.toList());

            // 查询所有品牌，过滤掉已关联的品牌
            List<Trademark> trademarkList = trademarkMapper.selectList(null).stream()
                    .filter(baseTrademark -> !tradeMarkIdList.contains(baseTrademark.getId()))
                    .collect(Collectors.toList());

            // 转换为DTO并返回
            List<TrademarkDTO> trademarkDTOs = trademarkConverter.trademarkPOs2DTOs(trademarkList);
            return trademarkDTOs;
        }

        // 如果没有任何已关联品牌，则返回所有品牌
        List<Trademark> trademarks = trademarkMapper.selectList(null);
        return trademarkConverter.trademarkPOs2DTOs(trademarks);
    }

    /**
     * 删除三级分类与品牌的关联关系
     *
     * @param category3Id 三级分类ID
     * @param trademarkId 品牌ID
     */
    @Override
    public void remove(Long category3Id, Long trademarkId) {
        // 构建删除条件，同时匹配三级分类ID和品牌ID
        LambdaQueryWrapper<CategoryTrademark> categoryTrademarkQueryWrapper = new LambdaQueryWrapper<>();
        categoryTrademarkQueryWrapper.eq(CategoryTrademark::getThirdLevelCategoryId, category3Id);
        categoryTrademarkQueryWrapper.eq(CategoryTrademark::getTrademarkId, trademarkId);

        // 执行删除操作（如果是逻辑删除，会更新is_deleted字段为1）
        categoryTrademarkMapper.delete(categoryTrademarkQueryWrapper);
    }
}