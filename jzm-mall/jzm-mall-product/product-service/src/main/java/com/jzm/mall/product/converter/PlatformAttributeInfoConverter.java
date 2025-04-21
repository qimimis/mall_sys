package com.jzm.mall.product.converter;

import com.jzm.mall.product.dto.PlatformAttributeInfoDTO;
import com.jzm.mall.product.dto.PlatformAttributeValueDTO;
import com.jzm.mall.product.model.PlatformAttributeInfo;
import com.jzm.mall.product.model.PlatformAttributeValue;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 平台属性DTO转换器
 */
@Mapper(componentModel = "spring")
public interface PlatformAttributeInfoConverter {

    /**
     * 将平台属性PO对象转换为DTO对象
     * @param platformAttributeInfo 平台属性PO对象
     * @return 平台属性DTO对象
     */
    PlatformAttributeInfoDTO platformAttributeInfoPO2DTO(PlatformAttributeInfo platformAttributeInfo);

    /**
     * 将平台属性PO对象列表转换为DTO对象列表
     * @param platformAttributeInfos 平台属性PO对象列表
     * @return 平台属性DTO对象列表
     */
    List<PlatformAttributeInfoDTO> platformAttributeInfoPOs2DTOs(List<PlatformAttributeInfo> platformAttributeInfos);

    /**
     * 将平台属性值PO对象转换为DTO对象
     * @param platformAttributeValue 平台属性值PO对象
     * @return 平台属性值DTO对象
     */
    PlatformAttributeValueDTO platformAttributeValuePO2DTO(PlatformAttributeValue platformAttributeValue);
}