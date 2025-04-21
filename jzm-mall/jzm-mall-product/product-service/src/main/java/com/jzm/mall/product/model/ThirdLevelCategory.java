package com.jzm.mall.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jzm.mall.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 实体类：商品三级分类
 */
@Data
@Schema(description = "商品三级分类")
@TableName("base_category3")
public class ThirdLevelCategory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(title = "三级分类名称")
    @TableField("name")
    private String name;

    @Schema(title = "所属二级分类编号")
    @TableField("category2_id")
    private Long secondLevelCategoryId;
}