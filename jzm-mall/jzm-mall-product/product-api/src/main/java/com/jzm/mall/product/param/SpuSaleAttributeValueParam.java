package com.jzm.mall.product.param;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SpuSaleAttributeValueParam {
    @Schema(title = "id")
    private Long id;

    @Schema(title = "spu销售属性id")
    private Long baseSaleAttrId;

    @Schema(title = "spu_id(冗余)")
    private Long spuId;

    @Schema(title = "spu销售属性值名称")
    private String saleAttrValueName;
}