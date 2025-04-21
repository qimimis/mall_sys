package com.jzm.mall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzm.mall.product.model.Trademark;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TrademarkMapper extends BaseMapper<Trademark> {
    // 继承BaseMapper后自动拥有基本的CRUD方法
    // 如需自定义SQL方法可在此添加
}