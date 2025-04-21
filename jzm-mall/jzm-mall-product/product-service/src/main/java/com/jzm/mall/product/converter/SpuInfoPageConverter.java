package com.jzm.mall.product.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jzm.mall.product.dto.SpuInfoPageDTO;
import com.jzm.mall.product.entity.SpuInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = SpuInfoConverter.class)
public interface SpuInfoPageConverter {
    // 分页对象转换
    SpuInfoPageDTO spuInfoPage2PageDTO(Page<SpuInfo> SpuInfoPage);
}