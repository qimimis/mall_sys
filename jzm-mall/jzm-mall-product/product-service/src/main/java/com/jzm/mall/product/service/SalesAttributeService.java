package com.jzm.mall.product.service;

import com.jzm.mall.product.dto.SaleAttributeInfoDTO;

import java.util.List;

public interface SalesAttributeService {
    /**
     * 查询所有的销售属性
     * 获取系统中定义的所有基础销售属性信息
     *
     * @return 销售属性信息DTO列表
     */
    List<SaleAttributeInfoDTO> getSaleAttrInfoList();


}
