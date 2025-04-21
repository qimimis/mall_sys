package com.jzm.mall.product.model;

import com.jzm.mall.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;

@Data
@Tag(name = "Trademark", description = "商标品牌")
@TableName("base_trademark")
public class Trademark extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(title = "属性值")
    @TableField("tm_name")
    private String tmName;

    @Schema(title = "品牌logo的图片路径")
    @TableField("logo_url")
    private String logoUrl;
}