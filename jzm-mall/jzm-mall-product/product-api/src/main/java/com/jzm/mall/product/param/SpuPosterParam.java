package com.jzm.mall.product.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SpuPosterParam {

    @Schema(title = "id")
    private Long id;

    @Schema(title = "商品id")
    private Long spuId;

    @Schema(title = "文件名称")
    private String imgName;

    @Schema(title = "文件路径")
    private String imgUrl;
}