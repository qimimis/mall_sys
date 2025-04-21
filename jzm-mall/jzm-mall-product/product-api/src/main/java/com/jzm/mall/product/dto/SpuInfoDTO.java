package com.jzm.mall.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class SpuInfoDTO {

    @Schema(title = "spu商品id")
    private Long id;

    @Schema(title = "商品名")
    private String spuName;

    @Schema(title = "商品描述(后台简述）")
    private String description;

    @Schema(title = "三级分类id")
    private Long thirdLevelCategoryId;

    @Schema(title = "品牌id")
    private Long tmId;

    @Schema(title = "销售属性集合")
    private List<SpuSaleAttributeInfoDTO> spuSaleAttributeInfoList;

    @Schema(title = "商品的图片集合")
    private List<SpuImageDTO> SpuImageList;

    @Schema(title = "商品的海报图片集合")
    private List<SpuPosterDTO> SpuPosterList;
}
