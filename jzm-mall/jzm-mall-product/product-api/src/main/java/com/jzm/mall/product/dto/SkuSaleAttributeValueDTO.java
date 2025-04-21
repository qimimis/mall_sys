package com.jzm.mall.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * SKU销售属性值数据传输对象
 */
@Data
public class SkuSaleAttributeValueDTO {

    /**
     * 销售属性值ID
     */
    @Schema(title = "id")
    private Long id;

    /**
     * 关联的SKU ID
     */
    @Schema(title = "库存单元id")
    private Long skuId;

    /**
     * SPU ID(冗余)
     */
    @Schema(title = "spu_id(冗余)")
    private Long spuId;

    /**
     * 销售属性值ID
     */
    @Schema(title = "销售属性值id")
    private Long saleAttrValueId;
}