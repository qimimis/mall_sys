package com.jzm.mall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzm.mall.product.model.PlatformAttributeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 平台属性Mapper接口
 */
@Mapper
public interface PlatformAttrInfoMapper extends BaseMapper<PlatformAttributeInfo> {

    /**
     * 根据分类Id 查询平台属性集合对象
     * @param firstLevelCategoryId 一级分类ID
     * @param secondLevelCategoryId 二级分类ID
     * @param thirdLevelCategoryId 三级分类ID
     * @return 平台属性集合
     */
    List<PlatformAttributeInfo> selectPlatFormAttrInfoList(
            @Param("firstLevelCategoryId") Long firstLevelCategoryId,
            @Param("secondLevelCategoryId") Long secondLevelCategoryId,
            @Param("thirdLevelCategoryId") Long thirdLevelCategoryId);

    /**
     * 根据skuId查询平台属性和属性值
     * @param skuId SKU ID
     * @return 平台属性集合
     */
    List<PlatformAttributeInfo> selectPlatformAttrInfoListBySkuId(Long skuId);
}