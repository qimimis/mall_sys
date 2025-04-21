package com.jzm.mall.product.converter;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jzm.mall.product.dto.SkuInfoPageDTO;
import com.jzm.mall.product.model.SkuInfo;
import org.mapstruct.Mapper;

/**
 * SKU信息分页对象转换器
 * 用于分页PO对象与分页DTO对象之间的转换
 */
@Mapper(componentModel = "spring", uses = SkuInfoConverter.class)
public interface SkuInfoPageConverter {

    /**
     * 将SKU信息分页PO对象转换为分页DTO对象
     * @param skuInfoPage SKU信息分页PO对象
     * @return SKU信息分页DTO对象
     */
    SkuInfoPageDTO skuInfoPagePO2PageDTO(Page<SkuInfo> skuInfoPage);
}
