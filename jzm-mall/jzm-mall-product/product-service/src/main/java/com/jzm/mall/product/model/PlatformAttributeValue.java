package com.jzm.mall.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jzm.mall.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

/**
 * 平台属性值实体类
 */
@Data
@Tag(name = "平台属性值", description = "平台属性值")
@TableName("base_attr_value")
public class PlatformAttributeValue extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(title = "属性值名称")
    @TableField("value_name")
    private String valueName;

    @Schema(title = "属性id")
    @TableField("attr_id")
    private Long attrId;
}