package com.jzm.mall.product.converter;

import com.jzm.mall.product.dto.CategoryHierarchyDTO;
import com.jzm.mall.product.dto.FirstLevelCategoryDTO;
import com.jzm.mall.product.dto.SecondLevelCategoryDTO;
import com.jzm.mall.product.dto.ThirdLevelCategoryDTO;
import com.jzm.mall.product.model.*;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * MapStruct 转换接口，用于将 PO 转换为 DTO
 */
@Mapper(componentModel = "spring")
public interface CategoryConverter {

    // 转换一级分类
    FirstLevelCategoryDTO firstLevelCategoryPO2DTO(FirstLevelCategory firstLevelCategory);
    List<FirstLevelCategoryDTO> firstLevelCategoryPOs2DTOs(List<FirstLevelCategory> firstLevelCategories);

    // 转换二级分类
    SecondLevelCategoryDTO secondLevelCategoryPO2DTO(SecondLevelCategory secondLevelCategory);
    List<SecondLevelCategoryDTO> secondLevelCategoryPOs2DTOs(List<SecondLevelCategory> secondLevelCategories);

    // 转换三级分类
    ThirdLevelCategoryDTO thirdLevelCategoryPO2DTO(ThirdLevelCategory thirdLevelCategory);
    List<ThirdLevelCategoryDTO> thirdLevelCategoryPOs2DTOs(List<ThirdLevelCategory> thirdLevelCategories);

    // 转换分类层级数据
    CategoryHierarchyDTO categoryViewPO2DTO(CategoryHierarchy categoryHierarchy);
}