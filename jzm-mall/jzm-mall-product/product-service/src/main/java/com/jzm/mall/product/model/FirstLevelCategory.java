package com.jzm.mall.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jzm.mall.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 实体类：商品一级分类
 */
@Data
@Schema(description = "商品一级分类")
@TableName("base_category1")
public class FirstLevelCategory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(title = "分类名称")
    @TableField("name")
    private String name;
}