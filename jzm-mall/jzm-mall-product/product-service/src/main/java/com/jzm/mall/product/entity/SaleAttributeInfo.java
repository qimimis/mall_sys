package com.jzm.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jzm.mall.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "销售属性")
@TableName("base_sale_attr")
public class SaleAttributeInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(title = "销售属性名称")
    @TableField("name")
    private String name;
}