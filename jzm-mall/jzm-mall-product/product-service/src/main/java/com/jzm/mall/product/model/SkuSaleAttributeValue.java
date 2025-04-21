package com.jzm.mall.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jzm.mall.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * SKU销售属性值实体类
 * 用于存储SKU的销售属性值信息
 */
@Data
@Schema(description = "Sku销售属性值")
@TableName("sku_sale_attr_value")
public class SkuSaleAttributeValue extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 关联的SKU ID
     */
    @Schema(title = "库存单元id")
    @TableField("sku_id")
    private Long skuId;

    /**
     * SPU ID（冗余字段）
     */
    @Schema(title = "spu_id(冗余)")
    @TableField("spu_id")
    private Long spuId;

    /**
     * 销售属性值ID
     */
    @Schema(title = "销售属性值id")
    @TableField("sale_attr_value_id")
    private Long spuSaleAttrValueId;
}
