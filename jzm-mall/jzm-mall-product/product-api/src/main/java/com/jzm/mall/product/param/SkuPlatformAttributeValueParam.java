package com.jzm.mall.product.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * SKU平台属性值参数类
 * 用于前端传递SKU平台属性值信息
 */
@Data
public class SkuPlatformAttributeValueParam {

    /**
     * 属性值ID，新增时为空
     */
    @Schema(title = "id")
    private Long id;

    /**
     * 属性ID
     */
    @Schema(title = "属性id")
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
