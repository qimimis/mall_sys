package com.jzm.mall.product.service.impl;

import com.jzm.mall.product.converter.SaleAttributeInfoConverter;
import com.jzm.mall.product.dto.SaleAttributeInfoDTO;
import com.jzm.mall.product.entity.SaleAttributeInfo;
import com.jzm.mall.product.mapper.SaleAttrInfoMapper;
import com.jzm.mall.product.service.SalesAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 销售属性服务实现类
 * 提供销售属性相关的业务逻辑实现
 */
@Service
public class SalesAttributeServiceImpl implements SalesAttributeService {

    /**
     * 销售属性数据访问对象
     */
    @Autowired
    SaleAttrInfoMapper saleAttrInfoMapper;

    /**
     * 销售属性信息转换器
     * 用于PO与DTO之间的转换
     */
    @Autowired
    SaleAttributeInfoConverter saleAttributeInfoConverter;

    /**
     * 获取所有销售属性信息列表
     *
     * @return 销售属性信息DTO列表
     */
    @Override
    public List<SaleAttributeInfoDTO> getSaleAttrInfoList() {
        // 查询所有销售属性信息
        List<SaleAttributeInfo> saleAttributeInfos = saleAttrInfoMapper.selectList(null);
        // 将PO对象转换为DTO对象并返回
        return saleAttributeInfoConverter.saleAttributeInfoPOs2DTOs(saleAttributeInfos);
    }
}