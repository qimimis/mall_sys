package com.jzm.mall.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * DTO：商品三级分类数据传输对象
 */
@Data
@Schema(description = "商品三级分类DTO")
public class ThirdLevelCategoryDTO {

    @Schema(title = "分类编号")
    private Long id;

    @Schema(title = "分类名称")
    private String name;

    @Schema(title = "所属二级分类编号")
    private Long secondLevelCategoryId;
}