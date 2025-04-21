package com.jzm.mall.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jzm.mall.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import java.util.List;

/**
 * 平台属性实体类
 */
@Data
@Tag(name = "平台属性", description = "平台属性")
@TableName("base_attr_info")
public class PlatformAttributeInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(title = "属性名称")
    @TableField("attr_name")
    private String attrName;

    @Schema(title = "分类id")
    @TableField("category_id")
    private Long categoryId;

    @Schema(title = "分类层级")
    @TableField("category_level")
    private Integer categoryLevel;

    /**
     * 平台属性值集合，这里注意一个平台属性，有多个属性取值
     * exist=false表示该字段在数据库表中不存在
     */
    @TableField(exist = false)
    private List<PlatformAttributeValue> attrValueList;
}