package com.jzm.mall.product.mapper;

import com.jzm.mall.product.model.CategoryHierarchy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper 接口：自定义查询分类层级信息
 */
@Mapper
public interface CategoryHierarchyMapper {
    /**
     * 根据三级分类ID查询完整的分类层级数据。
     * <p>
     * 若传入 thirdLevelCategoryId 不为 null，则返回该三级分类对应的一、二级数据；
     * 若为 null，则返回所有三级分类的完整层级数据。
     * </p>
     *
     * @param thirdLevelCategoryId 三级分类ID，可为 null
     * @return List&lt;CategoryHierarchy&gt;
     */
    List<CategoryHierarchy> selectCategoryHierarchy(@Param("thirdLevelCategoryId") Long thirdLevelCategoryId);
}