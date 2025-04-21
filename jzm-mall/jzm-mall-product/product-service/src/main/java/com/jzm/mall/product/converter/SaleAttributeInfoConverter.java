package com.jzm.mall.product.converter;

import com.jzm.mall.product.dto.SaleAttributeInfoDTO;
import com.jzm.mall.product.entity.SaleAttributeInfo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleAttributeInfoConverter {
    // 销售属性PO转DTO
    SaleAttributeInfoDTO saleAttributeInfoPO2DTO(SaleAttributeInfo saleAttributeInfo);
    List<SaleAttributeInfoDTO> saleAttributeInfoPOs2DTOs(List<SaleAttributeInfo> saleAttributeInfos);
}