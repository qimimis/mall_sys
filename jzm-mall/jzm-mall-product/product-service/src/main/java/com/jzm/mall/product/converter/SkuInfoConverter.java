package com.jzm.mall.product.converter;

import com.jzm.mall.product.dto.SkuImageDTO;
import com.jzm.mall.product.dto.SkuInfoDTO;
import com.jzm.mall.product.dto.SkuPlatformAttributeValueDTO;
import com.jzm.mall.product.dto.SkuSaleAttributeValueDTO;
import com.jzm.mall.product.model.SkuImage;
import com.jzm.mall.product.model.SkuInfo;
import com.jzm.mall.product.model.SkuPlatformAttributeValue;
import com.jzm.mall.product.model.SkuSaleAttributeValue;
import org.mapstruct.Mapper;

/**
 * SKU信息对象转换器
 * 用于实体类与DTO之间的转换
 */
@Mapper(componentModel = "spring")
public interface SkuInfoConverter {

    /**
     * 将SKU信息实体类转换为DTO
     * @param skuInfo SKU信息实体类
     * @return SKU信息DTO
     */
    SkuInfoDTO skuInfoPO2DTO(SkuInfo skuInfo);

    /**
     * 将SKU图片实体类转换为DTO
     * @param skuImage SKU图片实体类
     * @return SKU图片DTO
     */
    SkuImageDTO skuImagePO2DTO(SkuImage skuImage);

    /**
     * 将SKU平台属性值实体类转换为DTO
     * @param skuPlatformAttributeValue SKU平台属性值实体类
     * @return SKU平台属性值DTO
     */
    SkuPlatformAttributeValueDTO skuPlatformAttributeValuePO2DTO(
            SkuPlatformAttributeValue skuPlatformAttributeValue);

    /**
     * 将SKU销售属性值实体类转换为DTO
     * @param skuSaleAttributeValue SKU销售属性值实体类
     * @return SKU销售属性值DTO
     */
    SkuSaleAttributeValueDTO skuSaleAttributeValuePOs2DTOs(
            SkuSaleAttributeValue skuSaleAttributeValue);
}
