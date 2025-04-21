package com.jzm.mall.product.model;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jzm.mall.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * SKU图片实体类
 * 用于存储SKU商品的图片信息
 */
@Data
@Schema(description = "Sku图片")
@TableName("sku_image")
public class SkuImage extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 关联的SKU ID
     */
    @Schema(title = "商品id")
    @TableField("sku_id")
    private Long skuId;

    /**
     * 图片名称（冗余字段，不存在于数据库表中）
     */
    @Schema(title = "图片名称（冗余）")
    @TableField(exist = false)
    private String imgName;

    /**
     * 图片路径（冗余字段，不存在于数据库表中）
     */
    @Schema(title = "图片路径(冗余)")
    @TableField(exist = false)
    private String imgUrl;

    /**
     * 关联的SPU图片ID
     */
    @Schema(title = "商品图片id")
    @TableField("spu_img_id")
    private Long spuImgId;

    /**
     * 是否为默认图片
     */
    @Schema(title = "是否默认")
    @TableField("is_default")
    private String isDefault;
}