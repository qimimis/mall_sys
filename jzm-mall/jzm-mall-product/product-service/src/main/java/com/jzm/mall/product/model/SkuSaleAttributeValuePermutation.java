package com.jzm.mall.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * SKU销售属性值组合实体类
 * 用于详情页中显示不同销售属性组合对应的SKU
 */
@Schema(description = "详情页中的sku商品的一种销售属性组合")
@Data
public class SkuSaleAttributeValuePermutation {

    /**
     * 销售属性值ID组合字符串，通常是多个销售属性值ID拼接而成
     */
    @Schema(title = "销售属性一种取值组合的拼接字符串")
    String SkuSaleAttrValuePermutation;

    /**
     * 对应的SKU ID
     */
    @Schema(title = "sku商品id")
    Long skuId;
}