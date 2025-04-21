package com.jzm.mall.product.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品详情页数据传输对象
 * 用于封装商品详情页所需的所有信息
 */
@Data
public class ProductDetailDTO {

    // 商品sku信息
    private SkuInfoDTO skuInfo;

    // 获取指定的sku完整的销售属性值
    private List<SpuSaleAttributeInfoDTO> spuSaleAttrList;

    // 获取spu中包含的所有的不同销售属性取值的组合，JSON格式
    private String valuesSkuJson;

    // 获取sku商品的价格
    private BigDecimal price;

    // 获取三级类目的完整类目视图
    private CategoryHierarchyDTO categoryHierarchy;

    // 获取sku商品的海报列表
    private List<SpuPosterDTO> spuPosterList;

    // 获取sku商品对应的平台属性集合(规格参数)
    private List<SkuSpecificationDTO> skuAttrList;
}
