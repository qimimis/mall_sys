package com.jzm.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jzm.mall.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "销售属性")
@TableName("spu_sale_attr")
public class SpuSaleAttributeInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(title = "商品id")
    @TableField("spu_id")
    private Long spuId;

    @Schema(title = "销售属性id")
    @TableField("base_sale_attr_id")
    private Long saleAttrId;

    @Schema(title = "销售属性名称(冗余)")
    @TableField("sale_attr_name")
    private String saleAttrName;

    // 销售属性值对象集合 - 非数据库字段，用于关联销售属性值
    @TableField(exist = false)
    List<SpuSaleAttributeValue> spuSaleAttrValueList;
}