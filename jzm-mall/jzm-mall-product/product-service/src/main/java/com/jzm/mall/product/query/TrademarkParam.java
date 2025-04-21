package com.jzm.mall.product.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TrademarkParam {

    @Schema(title = "品牌id")
    private Long id;

    @Schema(title = "属性值")
    private String tmName;

    @Schema(title = "品牌logo的图片路径")
    private String logoUrl;
}