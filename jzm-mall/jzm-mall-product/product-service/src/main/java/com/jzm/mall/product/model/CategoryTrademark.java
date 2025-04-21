package com.jzm.mall.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jzm.mall.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 分类品牌关联实体类
 * 用于映射category_trademark表中的数据
 * 定义了三级分类与品牌之间的关联关系
 */
@Data
@Schema(description = "CategoryTrademark")
@TableName("category_trademark")
public class CategoryTrademark extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 三级分类编号，对应数据库表中的third_level_category_id字段
     */
    @Schema(title = "三级分类编号")
    @TableField("third_level_category_id")
    private Long thirdLevelCategoryId;

    /**
     * 品牌id，对应数据库表中的trademark_id字段
     */
    @Schema(title = "品牌id")
    @TableField("trademark_id")
    private Long trademarkId;

    /**
     * 品牌对象，不在数据库表中存储，用于数据传输
     * exist=false表示该字段不是数据库表中的字段
     */
    @TableField(exist = false)
    private Trademark trademark;
}