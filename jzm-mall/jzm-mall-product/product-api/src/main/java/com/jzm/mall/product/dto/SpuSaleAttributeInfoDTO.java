package com.jzm.mall.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class SpuSaleAttributeInfoDTO {

    private Long id;

    @Schema(title = "商品id")
    private Long spuId;

    @Schema(title = "销售属性id")
    private Long saleAttrId;

    @Schema(title = "销售属性名称(冗余)")
    private String saleAttrName;

    // 销售属性值对象集合
    List<SpuSaleAttributeValueDTO> spuSaleAttrValueList;
}
