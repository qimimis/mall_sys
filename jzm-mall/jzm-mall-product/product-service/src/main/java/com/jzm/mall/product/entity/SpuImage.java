package com.jzm.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jzm.mall.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Spu图片")
@TableName("spu_image")
public class SpuImage extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(title = "商品id")
    @TableField("spu_id")
    private Long spuId;

    @Schema(title = "图片名称")
    @TableField("img_name")
    private String imgName;

    @Schema(title = "图片路径")
    @TableField("img_url")
    private String imgUrl;
}