package com.jzm.mall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzm.mall.product.model.CategoryTrademark;
import org.apache.ibatis.annotations.Mapper;

/**
 * 分类品牌关联Mapper接口
 * 继承BaseMapper以获取基本的CRUD操作方法
 */
@Mapper
public interface CategoryTrademarkMapper extends BaseMapper<CategoryTrademark> {
}