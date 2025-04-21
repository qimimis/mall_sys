package com.jzm.mall.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * SKU信息分页数据传输对象
 * 用于分页查询时返回数据
 */
@Data
public class SkuInfoPageDTO {

    /**
     * 当前页的SKU记录列表
     */
    @Schema(title = "查询到的一页spu数据")
    private List<SkuInfoDTO> records;

    /**
     * 满足条件的总记录数
     */
    @Schema(title = "满足条件的总的spu数量")
    private Integer total;
}