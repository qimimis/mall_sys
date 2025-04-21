package com.jzm.mall.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 平台属性DTO，用于与前端交互
 */
@Data
public class PlatformAttributeInfoDTO {
    @Schema(title = "平台属性id")
    private Long id;

    @Schema(title = "属性名称")
    private String attrName;

    @Schema(title = "分类id")
    private Long categoryId;

    @Schema(title = "分类层级")
    private Integer categoryLevel;

    /**
     * 平台属性值集合，这里注意一个平台属性，有多个属性取值
     */
    @Schema(title = "平台属性值列表")
    private List<PlatformAttributeValueDTO> attrValueList;
}