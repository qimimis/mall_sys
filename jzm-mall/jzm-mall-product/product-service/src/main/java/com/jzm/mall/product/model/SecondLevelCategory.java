package com.jzm.mall.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jzm.mall.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 实体类：商品二级分类
 */
@Data
@Schema(description = "商品二级分类")
@TableName("base_category2")
public class SecondLevelCategory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(title = "二级分类名称")
    @TableField("name")
    private String name;

    @Schema(title = "所属一级分类编号")
    @TableField("category1_id")
    private Long firstLevelCategoryId;
}