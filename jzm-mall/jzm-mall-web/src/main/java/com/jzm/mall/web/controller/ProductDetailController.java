package com.jzm.mall.web.controller;

import com.jzm.mall.common.result.Result;
import com.jzm.mall.product.dto.ProductDetailDTO;
import com.jzm.mall.web.client.ProductApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品详情页控制器
 * 负责处理商品详情页的请求并准备视图数据
 */
@Controller
@Slf4j
public class ProductDetailController {

    @Autowired
    private ProductApiClient productApiClient;

    /**
     * 处理sku详情页请求
     * @param skuId 商品SKU ID
     * @param model 视图模型
     * @return 页面模板路径
     */
    @RequestMapping("{skuId}.html")
    public String getItem(@PathVariable Long skuId, Model model){
        log.info("enter {} for {}", ProductDetailController.class.getSimpleName(), "getItem");

        // 调用商品服务，通过skuId查询商品详情
        Result<ProductDetailDTO> result = productApiClient.getItem(skuId);

        // 获取服务调用结果
        ProductDetailDTO data = result.getData();

        // 以map的形式准备渲染所需数据
        Map<String, Object> renderData = new HashMap<>();
        renderData.put("skuInfo", data.getSkuInfo());
        renderData.put("spuSaleAttrList", data.getSpuSaleAttrList());
        renderData.put("valuesSkuJson", data.getValuesSkuJson());
        renderData.put("price", data.getPrice());
        renderData.put("categoryHierarchy", data.getCategoryHierarchy());
        renderData.put("spuPosterList", data.getSpuPosterList());
        renderData.put("skuAttrList", data.getSkuAttrList());

        // 将所有数据添加到模型中
        model.addAllAttributes(renderData);

        log.info("before render template {} for {}", "item/item", "getItem");

        // 返回模板路径
        return "item/item";
    }
}
