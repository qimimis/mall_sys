package com.jzm.mall.product.service;

import com.jzm.mall.product.dto.ProductDetailDTO;

/**
 * 商品详情服务接口
 * 提供获取商品详情的核心业务逻辑
 */
public interface ProductDetailService {

    /**
     * 获取sku详情信息
     * @param skuId 商品SKU ID
     * @return 商品详情DTO对象
     */
    ProductDetailDTO getItemBySkuId(Long skuId);
}