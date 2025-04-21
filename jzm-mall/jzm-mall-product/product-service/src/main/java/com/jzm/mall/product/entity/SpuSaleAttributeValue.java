package com.jzm.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jzm.mall.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "销售属性值")
@TableName("spu_sale_attr_value")
public class SpuSaleAttributeValue extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(title = "商品id")
    @TableField("spu_id")
    private Long spuId;

    @Schema(title = "销售属性id")
    @TableField("base_sale_attr_id")
    private Long spuSaleAttrId;

    @Schema(title = "销售属性值名称")
    @TableField("sale_attr_value_name")
    private String spuSaleAttrValueName;

    // 是否是默认选中状态 - 非数据库字段，用于前端显示
    @TableField(exist = false)
    String isChecked;
}