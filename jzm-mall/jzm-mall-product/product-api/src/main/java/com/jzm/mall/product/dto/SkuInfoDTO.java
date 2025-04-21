package com.jzm.mall.product.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * SKU信息数据传输对象
 * 用于前后端交互，传输SKU完整信息
 */
@Data
public class SkuInfoDTO {
    /**
     * SKU ID
     */
    @Schema(title = "id")
    private Long id;

    /**
     * 所属SPU ID
     */
    @Schema(title = "商品id")
    private Long spuId;

    /**
     * SKU价格
     */
    @Schema(title = "价格")
    private BigDecimal price;

    /**
     * SKU名称
     */
    @Schema(title = "sku名称")
    private String skuName;

    /**
     * SKU描述信息
     */
    @Schema(title = "商品规格描述")
    private String skuDesc;

    /**
     * 商品重量
     */
    @Schema(title = "重量")
    private String weight;

    /**
     * 品牌ID
     */
    @Schema(title = "品牌(冗余)")
    private Long tmId;

    /**
     * 三级分类ID
     */
    @Schema(title = "三级分类id（冗余)")
    private Long thirdLevelCategoryId;

    /**
     * 默认显示图片
     */
    @Schema(title = "默认显示图片(冗余)")
    private String skuDefaultImg;

    /**
     * 是否上架销售
     */
    @Schema(title = "是否销售（1：是 0：否）")
    private Integer isSale;

    /**
     * SKU图片列表
     */
    @Schema(title = "sku商品图片列表")
    List<SkuImageDTO> skuImageList;

    /**
     * SKU平台属性值列表
     */
    @Schema(title = "sku商品平台属性值集合")
    List<SkuPlatformAttributeValueDTO> skuPlatformAttributeValueList;

    /**
     * SKU销售属性值列表
     */
    @Schema(title = "sku商品销售属性值集合")
    List<SkuSaleAttributeValueDTO> skuSaleAttributeValueList;
}