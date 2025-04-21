package com.jzm.mall.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SpuImageDTO {
    @Schema(title = "id")
    private Long id;

    @Schema(title = "商品id")
    private Long skuId;

    @Schema(title = "图片名称（冗余）")
    private String imgName;

    @Schema(title = "图片路径(冗余)")
    private String imgUrl;

    @Schema(title = "商品图片id")
    private Long spuImgId;

    @Schema(title = "是否默认")
    private String isDefault;
}
