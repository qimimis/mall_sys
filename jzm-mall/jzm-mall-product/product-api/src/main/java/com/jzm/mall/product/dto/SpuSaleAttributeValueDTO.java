package com.jzm.mall.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class SpuSaleAttributeValueDTO {

    @Schema(title = "id")
    private Long id;

    @Schema(title = "商品id")
    private Long spuId;

    @Schema(title = "销售属性id")
    private Long spuSaleAttrId;

    @Schema(title = "销售属性值名称")
    private String spuSaleAttrValueName;

    @Schema(title = "是否关联到了sku的属性值")
    String isChecked;
}