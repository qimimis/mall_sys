package com.jzm.mall.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * SKU图片数据传输对象
 */
@Data
public class SkuImageDTO {

    /**
     * 图片ID
     */
    @Schema(title = "id")
    private Long id;

    /**
     * 关联的SKU ID
     */
    @Schema(title = "商品id")
    private Long skuId;

    /**
     * 图片名称
     */
    @Schema(title = "图片名称（冗余）")
    private String imgName;

    /**
     * 图片URL路径
     */
    @Schema(title = "图片路径(冗余)")
    private String imgUrl;

    /**
     * 关联的SPU图片ID
     */
    @Schema(title = "商品图片id")
    private Long spuImgId;

    /**
     * 是否为默认图片
     */
    @Schema(title = "是否默认")
    private String isDefault;
}