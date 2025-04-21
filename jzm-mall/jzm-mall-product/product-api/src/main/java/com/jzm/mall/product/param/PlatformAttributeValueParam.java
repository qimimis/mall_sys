package com.jzm.mall.product.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 平台属性值参数类，用于接收前端请求数据
 */
@Data
@Schema(description = "平台属性值参数")
public class PlatformAttributeValueParam {

    @Schema(title = "平台属性值ID")
    private Long id;

    @Schema(title = "属性值名称")
    private String valueName;

    @Schema(title = "属性ID")
    private Long attrId;
}