package com.jzm.mall.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.jzm.mall.product.dto.*;
import com.jzm.mall.product.service.CategoryService;
import com.jzm.mall.product.service.ProductDetailService;
import com.jzm.mall.product.service.SkuService;
import com.jzm.mall.product.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    private SpuService spuService;

    @Autowired
    private SkuService skuService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public ProductDetailDTO getItemBySkuId(Long skuId) {
        // 创建返回对象
        ProductDetailDTO productDetailDTO = new ProductDetailDTO();

        // 1. 获取SKU基本信息
        SkuInfoDTO skuInfo = skuService.getSkuInfo(skuId);
        productDetailDTO.setSkuInfo(skuInfo);

        // 2. 获取销售属性列表及选中状态
        List<SpuSaleAttributeInfoDTO> spuSaleAttrListCheckBySku =
                skuService.getSpuSaleAttrListCheckBySku(skuInfo.getId(), skuInfo.getSpuId());
        productDetailDTO.setSpuSaleAttrList(spuSaleAttrListCheckBySku);

        // 3. 获取SKU销售属性值的映射，用于页面属性切换
        Map<String, Long> skuValueIdsMap = spuService.getSkuValueIdsMap(skuInfo.getSpuId());
        String valuesSkuJson = JSON.toJSONString(skuValueIdsMap);
        productDetailDTO.setValuesSkuJson(valuesSkuJson);

        // 4. 获取商品最新价格
        BigDecimal skuPrice = skuService.getSkuPrice(skuId);
        productDetailDTO.setPrice(skuPrice);

        // 5. 获取商品分类信息
        CategoryHierarchyDTO categoryViewByCategory =
                categoryService.getCategoryViewByCategoryId(skuInfo.getThirdLevelCategoryId());
        productDetailDTO.setCategoryHierarchy(categoryViewByCategory);

        // 6. 获取商品海报列表
        List<SpuPosterDTO> spuPosterBySpuId = spuService.findSpuPosterBySpuId(skuInfo.getSpuId());
        productDetailDTO.setSpuPosterList(spuPosterBySpuId);

        // 7. 获取sku平台属性（规格参数）
        List<PlatformAttributeInfoDTO> platformAttrInfoBySku = skuService.getPlatformAttrInfoBySku(skuId);
        List<SkuSpecificationDTO> skuAttrList = platformAttrInfoBySku.stream().map((baseAttrInfo) -> {
            // 转换为规格DTO
            SkuSpecificationDTO skuSpecification = new SkuSpecificationDTO();
            skuSpecification.setAttrName(baseAttrInfo.getAttrName());
            skuSpecification.setAttrValue(baseAttrInfo.getAttrValueList().get(0).getValueName());
            return skuSpecification;
        }).collect(Collectors.toList());
        productDetailDTO.setSkuAttrList(skuAttrList);

        return productDetailDTO;
    }
}
