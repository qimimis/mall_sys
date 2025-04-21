package com.jzm.mall.product.entity;



import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jzm.mall.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "SpuInfo")
@TableName("spu_info")
public class SpuInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(title = "商品名称")
    @TableField("spu_name")
    private String spuName;

    @Schema(title = "商品描述(后台简述）")
    @TableField("description")
    private String description;

    @Schema(title = "三级分类id")
    @TableField("category3_id")
    private Long thirdLevelCategoryId;

    @Schema(title = "品牌id")
    @TableField("tm_id")
    private Long tmId;

    // 销售属性集合 - 非数据库字段，用于数据传输
    @TableField(exist = false)
    private List<SpuSaleAttributeInfo> spuSaleAttributeInfoList;

    // 商品的图片集合 - 非数据库字段，用于数据传输
    @TableField(exist = false)
    private List<SpuImage> SpuImageList;

    // 商品的海报图片集合 - 非数据库字段，用于数据传输
    @TableField(exist = false)
    private List<SpuPoster> SpuPosterList;
}