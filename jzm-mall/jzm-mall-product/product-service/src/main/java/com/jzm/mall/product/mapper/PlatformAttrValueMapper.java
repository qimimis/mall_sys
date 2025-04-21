package com.jzm.mall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzm.mall.product.model.PlatformAttributeValue;
import org.apache.ibatis.annotations.Mapper;

/**
 * 平台属性值Mapper接口
 */
@Mapper
public interface PlatformAttrValueMapper extends BaseMapper<PlatformAttributeValue> {
    // 使用MyBatis-Plus提供的基础方法，无需自定义方法
}