package com.jzm.mall.product.converter;

import com.jzm.mall.product.model.SkuImage;
import com.jzm.mall.product.model.SkuInfo;
import com.jzm.mall.product.model.SkuPlatformAttributeValue;
import com.jzm.mall.product.model.SkuSaleAttributeValue;
import com.jzm.mall.product.param.SkuImageParam;
import com.jzm.mall.product.param.SkuInfoParam;
import com.jzm.mall.product.param.SkuPlatformAttributeValueParam;
import com.jzm.mall.product.param.SkuSaleAttributeValueParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SkuInfoParamConverter {

    /**
     * 将SKU信息参数对象转换为PO对象
     * @param skuInfoParam SKU信息参数对象
     * @return SKU信息PO对象
     */
    @Mapping(source = "category3Id", target = "thirdLevelCategoryId")
    @Mapping(source = "skuAttrValueList", target = "skuPlatformAttributeValueList")
    @Mapping(source = "skuSaleAttrValueList", target = "skuSaleAttributeValueList")
    SkuInfo SkuInfoParam2Info(SkuInfoParam skuInfoParam);

    /**
     * 将SKU图片参数对象转换为PO对象
     * @param skuImageParam SKU图片参数对象
     * @return SKU图片PO对象
     */
    SkuImage skuImageParam2Image(SkuImageParam skuImageParam);

    /**
     * 将SKU平台属性值参数对象转换为PO对象
     * @param param SKU平台属性值参数对象
     * @return SKU平台属性值PO对象
     */
    SkuPlatformAttributeValue skuPlatformAttributeValueParam2Value(SkuPlatformAttributeValueParam param);

    /**
     * 将SKU销售属性值参数对象转换为PO对象
     * @param param SKU销售属性值参数对象
     * @return SKU销售属性值PO对象
     */
    @Mapping(source = "saleAttrValueId", target = "spuSaleAttrValueId")
    SkuSaleAttributeValue skuSaleAttributeValueParam2Value(SkuSaleAttributeValueParam param);
}