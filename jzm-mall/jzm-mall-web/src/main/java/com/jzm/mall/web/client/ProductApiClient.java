package com.jzm.mall.web.client;

import com.jzm.mall.common.result.Result;
import com.jzm.mall.product.dto.ProductDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 商品服务Feign客户端
 * 用于调用商品微服务的接口
 */
@FeignClient(value = "service-product")
public interface ProductApiClient {

    /**
     * 根据skuId获取对应商品的详情页数据
     * @param skuId 商品SKU ID
     * @return 商品详情数据包装结果
     */
    @GetMapping("/api/item/{skuId}")
    Result<ProductDetailDTO> getItem(@PathVariable("skuId") Long skuId);
}
