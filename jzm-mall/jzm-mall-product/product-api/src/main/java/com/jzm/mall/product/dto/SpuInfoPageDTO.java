package com.jzm.mall.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class SpuInfoPageDTO {

    @Schema(title = "查询到的一页spu数据")
    private List<SpuInfoDTO> records;

    @Schema(title = "满足条件的总的spu数量")
    private Integer total;
}
