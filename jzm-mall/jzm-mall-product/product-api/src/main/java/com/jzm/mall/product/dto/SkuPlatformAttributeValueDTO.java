package com.jzm.mall.product.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * SKU平台属性值数据传输对象
 */
@Data
public class SkuPlatformAttributeValueDTO {

    /**
     * 属性值ID
     */
    @Schema(title = "id")
    private Long id;

    /**
     * 属性ID
     */
    @Schema(title = "属性id（冗余)")
    private Long attrId;

    /**
     * 属性值ID
     */
    @Schema(title = "属性值id")
    private Long valueId;

    /**
     * 关联的SKU ID
     */
    @Schema(title = "skuid")
    private Long skuId;
}