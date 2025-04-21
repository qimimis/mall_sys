package com.jzm.mall.product.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 平台属性参数类，用于接收前端请求数据
 */
@Data
@Schema(description = "平台属性参数")
public class PlatformAttributeParam {

    @Schema(title = "平台属性ID")
    private Long id;

    @Schema(title = "属性名称")
    private String attrName;

    @Schema(title = "分类id")
    private Long categoryId;

    @Schema(title = "分类层级")
    private Integer categoryLevel;

    @Schema(title = "平台属性值列表")
    private List<PlatformAttributeValueParam> attrValueList;
}