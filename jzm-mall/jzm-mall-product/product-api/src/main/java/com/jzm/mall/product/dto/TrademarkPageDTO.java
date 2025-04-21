package com.jzm.mall.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;

@Data
public class TrademarkPageDTO {

    @Schema(title = "查询到的一页品牌数据")
    private List<TrademarkDTO> records;

    @Schema(title = "满足条件的总的品牌数量")
    private Integer total;
}