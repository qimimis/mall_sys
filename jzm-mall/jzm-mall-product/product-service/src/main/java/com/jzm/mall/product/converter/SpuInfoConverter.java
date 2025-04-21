package com.jzm.mall.product.converter;

import com.jzm.mall.product.dto.*;
import com.jzm.mall.product.entity.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpuInfoConverter {
    // SPU基本信息PO转DTO
    SpuInfoDTO spuInfoPO2DTO(SpuInfo spuInfo);

    // 销售属性PO转DTO
    SpuSaleAttributeInfoDTO spuSaleAttributeInfoPO2DTO(SpuSaleAttributeInfo spuSaleAttributeInfo);
    List<SpuSaleAttributeInfoDTO> spuSaleAttributeInfoPOs2DTOs(List<SpuSaleAttributeInfo> spuSaleAttributeInfos);

    // 销售属性值PO转DTO
    SpuSaleAttributeValueDTO spuSaleAttributeValuePO2DTO(SpuSaleAttributeValue spuSaleAttributeValue);
    List<SpuSaleAttributeValueDTO> spuSaleAttributeValuePOs2DTOs(List<SpuSaleAttributeValue> spuSaleAttributeValues);

    // 图片PO转DTO
    SpuImageDTO spuImagePO2spuImageDTO(SpuImage spuImage);
    List<SpuImageDTO> spuImagePOs2DTOs(List<SpuImage> spuImages);

    // 海报PO转DTO
    SpuPosterDTO spuPosterPO2DTO(SpuPoster spuPoster);
    List<SpuPosterDTO> spuPosterPOs2DTOs(List<SpuPoster> spuPosters);
}
