package com.jzm.mall.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jzm.mall.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * SKU平台属性值实体类
 * 用于存储SKU的平台属性值信息
 */
@Data
@Schema(description = "Sku平台属性值")
@TableName("sku_attr_value")
public class SkuPlatformAttributeValue extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 平台属性ID（冗余）
     */
    @Schema(title = "属性id（冗余)")
    @TableField("attr_id")
    private Long attrId;

    /**
     * 平台属性值ID
     */
    @Schema(title = "属性值id")
    @TableField("value_id")
    private Long valueId;

    /**
     * 关联的SKU ID
     */
    @Schema(title = "skuid")
    @TableField("sku_id")
    private Long skuId;
}