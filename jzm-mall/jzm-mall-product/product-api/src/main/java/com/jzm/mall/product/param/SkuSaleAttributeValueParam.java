package com.jzm.mall.product.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * SKU销售属性值参数类
 * 用于前端传递SKU销售属性值信息
 */
@Data
public class SkuSaleAttributeValueParam {

    /**
     * 销售属性值ID，新增时为空
     */
    @Schema(title = "id")
    private Long id;

    /**
     * 关联的SKU ID
     */
    @Schema(title = "库存单元id")
    private Long skuId;

    /**
     * SPU ID(冗余)
     */
    @Schema(title = "spu_id(冗余)")
    private Long spuId;

    /**
     * 销售属性值ID
     */
    @Schema(title = "销售属性值id")
    private Long saleAttrValueId;  // 注意与实体类的spuSaleAttrValueId命名不同
}