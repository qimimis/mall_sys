package com.jzm.mall.product.param;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 分类品牌关联参数类
 * 用于接收前端传来的保存分类与品牌关联的参数
 */
@Data
public class CategoryTrademarkParam {

    /**
     * 三级分类编号
     */
    @Schema(title = "三级分类编号")
    private Long category3Id;

    /**
     * 品牌id列表，用于批量保存关联关系
     */
    @Schema(title = "品牌id")
    private List<Long> trademarkIdList;
}