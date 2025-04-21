package com.jzm.mall.product.converter.param;

import com.jzm.mall.product.model.PlatformAttributeInfo;
import com.jzm.mall.product.model.PlatformAttributeValue;
import com.jzm.mall.product.param.PlatformAttributeParam;
import com.jzm.mall.product.param.PlatformAttributeValueParam;
import org.mapstruct.Mapper;

/**
 * 平台属性参数转换器
 */
@Mapper(componentModel = "spring")
public interface PlatformAttributeInfoParamConverter {

    /**
     * 将平台属性参数对象转换为平台属性PO对象
     * @param platformAttributeParam 平台属性参数对象
     * @return 平台属性PO对象
     */
    PlatformAttributeInfo attributeInfoParam2Info(PlatformAttributeParam platformAttributeParam);

    /**
     * 将平台属性值参数对象转换为平台属性值PO对象
     * @param platformAttributeValueParam 平台属性值参数对象
     * @return 平台属性值PO对象
     */
    PlatformAttributeValue attributeValueParam2AttributeValue(PlatformAttributeValueParam platformAttributeValueParam);
}