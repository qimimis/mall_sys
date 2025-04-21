package com.jzm.mall.product.converter;

import com.jzm.mall.product.dto.SpuPosterDTO;
import com.jzm.mall.product.entity.*;
import com.jzm.mall.product.param.SpuImageParam;
import com.jzm.mall.product.param.SpuInfoParam;
import com.jzm.mall.product.param.SpuSaleAttributeInfoParam;
import com.jzm.mall.product.param.SpuSaleAttributeValueParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpuInfoParamConverter {
    // 前端参数转PO对象，需要特别处理字段名不一致的情况
    @Mapping(source = "category3Id", target = "thirdLevelCategoryId")
    @Mapping(source = "spuSaleAttrList", target = "spuSaleAttributeInfoList")
    SpuInfo spuInfoParam2Info(SpuInfoParam spuInfo);

    // 其他辅助转换方法
    SpuPosterDTO spuPosterPO2DTO(SpuPoster spuPoster);
    List<SpuPosterDTO> spuPosterPOs2DTOs(List<SpuPoster> spuPosters);

    SpuImage spuImageParam2Image(SpuImageParam spuImage);
    List<SpuImage> spuImageParams2Images(List<SpuImageParam> spuImages);

    @Mapping(source = "baseSaleAttrId", target = "saleAttrId")
    SpuSaleAttributeInfo spuSaleAttributeParam2Info(SpuSaleAttributeInfoParam spuSaleAttributeInfo);
    List<SpuSaleAttributeInfo> spuSaleAttributeParams2Infos(List<SpuSaleAttributeInfoParam> spuSaleAttributeInfos);

    @Mapping(source = "saleAttrValueName", target = "spuSaleAttrValueName")
    @Mapping(source = "baseSaleAttrId", target = "spuSaleAttrId")
    SpuSaleAttributeValue spuSaleAttributeValueParam2Value(SpuSaleAttributeValueParam spuSaleAttributeValue);
    List<SpuSaleAttributeValue> spuSaleAttributeValueParams2Values(List<SpuSaleAttributeValueParam> spuSaleAttributeValues);
}