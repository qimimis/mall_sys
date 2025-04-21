package com.jzm.mall.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 实体类：商品分类层级查询结果
 * 用于封装一二三级分类联合查询的数据
 */
@Data
@Schema(description = "商品分类层级查询结果")
public class CategoryHierarchy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(title = "一级分类编号")
    @TableField("first_level_category_id")
    private Long firstLevelCategoryId;

    @Schema(title = "一级分类名称")
    @TableField("first_level_category_name")
    private String firstLevelCategoryName;

    @Schema(title = "二级分类编号")
    @TableField("second_level_category_id")
    private Long secondLevelCategoryId;

    @Schema(title = "二级分类名称")
    @TableField("second_level_category_name")
    private String secondLevelCategoryName;

    @Schema(title = "三级分类编号")
    @TableField("third_level_category_id")
    private Long thirdLevelCategoryId;

    @Schema(title = "三级分类名称")
    @TableField("third_level_category_name")
    private String thirdLevelCategoryName;
}