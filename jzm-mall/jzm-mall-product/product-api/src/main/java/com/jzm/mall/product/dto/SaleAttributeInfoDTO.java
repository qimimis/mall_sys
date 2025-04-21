package com.jzm.mall.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SaleAttributeInfoDTO {

    @Schema(title = "销售属性id")
    private Long id;

    @Schema(title = "销售属性名称")
    private String name;
}