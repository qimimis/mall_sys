package com.jzm.mall.product.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * SKU信息参数类
 * 用于前端传递SKU保存或更新的相关信息
 */
@Data
public class SkuInfoParam {

    /**
     * SKU ID，新增时为空
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
     * SKU描述
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
    private Long category3Id;  // 注意这里与实体类的thirdLevelCategoryId命名不同

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
    @Schema(title = "sku商品的图片列表")
    List<SkuImageParam> skuImageList;

    /**
     * SKU平台属性值列表
     */
    @Schema(title = "sku商品平台属性集合")
    List<SkuPlatformAttributeValueParam> skuAttrValueList;  // 注意命名差异

    /**
     * SKU销售属性值列表
     */
    @Schema(title = "sku商品销售属性集合")
    List<SkuSaleAttributeValueParam> skuSaleAttrValueList;  // 注意命名差异
}