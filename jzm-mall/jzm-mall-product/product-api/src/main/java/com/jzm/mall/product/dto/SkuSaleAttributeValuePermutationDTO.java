package com.jzm.mall.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * SKU销售属性值组合数据传输对象
 * 用于前端展示销售属性组合与SKU的对应关系
 */
@Schema(description = "详情页中的sku商品的一种销售属性组合")
@Data
public class SkuSaleAttributeValuePermutationDTO {

    /**
     * 销售属性值ID组合字符串
     */
    @Schema(title = "销售属性一种取值组合的拼接字符串")
    String valueIdsPermutationStr;

    /**
     * 对应的SKU ID
     */
    @Schema(title = "sku商品id")
    Long skuId;
}