package com.jzm.mall.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CategoryHierarchyDTO {

    @Schema(title = "id")
    private Long id;

    @Schema(title = "一级分类编号")
    private Long firstLevelCategoryId;

    @Schema(title = "一级分类名称")
    private String firstLevelCategoryName;

    @Schema(title = "二级分类编号")
    private Long secondLevelCategoryId;

    @Schema(title = "二级分类名称")
    private String secondLevelCategoryName;

    @Schema(title = "三级分类编号")
    private Long thirdLevelCategoryId;

    @Schema(title = "三级分类名称")
    private String thirdLevelCategoryName;
}
