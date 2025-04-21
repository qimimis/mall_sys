package com.jzm.mall.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 平台属性值DTO，用于与前端交互
 */
@Data
public class PlatformAttributeValueDTO {

    @Schema(title = "平台属性值id")
    private Long id;

    @Schema(title = "属性值名称")
    private String valueName;

    @Schema(title = "属性id")
    private Long attrId;
}