package com.jzm.mall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzm.mall.product.model.FirstLevelCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * Mapper 接口：操作一级分类表
 */
@Mapper
public interface FirstLevelCategoryMapper extends BaseMapper<FirstLevelCategory> {
    // 继承 BaseMapper 后自动提供常用 CRUD 方法
}