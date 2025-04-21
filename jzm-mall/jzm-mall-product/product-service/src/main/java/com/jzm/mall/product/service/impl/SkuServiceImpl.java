package com.jzm.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jzm.mall.product.converter.*;
import com.jzm.mall.product.dto.PlatformAttributeInfoDTO;
import com.jzm.mall.product.dto.SkuInfoDTO;
import com.jzm.mall.product.dto.SkuInfoPageDTO;
import com.jzm.mall.product.dto.SpuSaleAttributeInfoDTO;
import com.jzm.mall.product.entity.SpuSaleAttributeInfo;
import com.jzm.mall.product.mapper.*;
import com.jzm.mall.product.model.PlatformAttributeInfo;
import com.jzm.mall.product.model.SkuImage;
import com.jzm.mall.product.model.SkuInfo;
import com.jzm.mall.product.param.SkuInfoParam;
import com.jzm.mall.product.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * SKU服务接口实现类
 * 实现SKU的增删改查等核心业务逻辑
 */
@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    SkuInfoMapper skuInfoMapper; // SKU基本信息Mapper

    @Autowired
    SkuImageMapper skuImageMapper; // SKU图片Mapper

    @Autowired
    SkuSaleAttrValueMapper skuSaleAttrValueMapper; // SKU销售属性值Mapper

    @Autowired
    SkuPlatformAttrValueMapper skuPlatformAttrValueMapper; // SKU平台属性值Mapper

    @Autowired
    SpuSaleAttrInfoMapper spuSaleAttrInfoMapper; // SPU销售属性信息Mapper

    @Autowired
    PlatformAttrInfoMapper platformAttrInfoMapper; // 平台属性信息Mapper

    // 各种数据转换器
    @Autowired
    SkuInfoPageConverter skuInfoPageConverter; // SKU分页数据转换器

    @Autowired
    SkuInfoConverter skuInfoConverter; // SKU信息转换器

    @Autowired
    SpuInfoConverter spuInfoConverter; // SPU信息转换器

    @Autowired
    PlatformAttributeInfoConverter platformAttributeInfoConverter; // 平台属性信息转换器

    @Autowired
    SkuInfoParamConverter skuInfoParamConverter; // SKU信息参数转换器

    /**
     * 保存SKU信息
     * 逻辑包括：保存SKU基本信息、SKU图片、SKU销售属性值和SKU平台属性值
     *
     * @param skuInfoParam SKU信息参数对象
     */
    /**
     * 保存SKU信息
     * 使用Lambda表达式和Stream API实现
     * 逻辑包括：保存SKU基本信息、SKU图片、SKU销售属性值和SKU平台属性值
     *
     * @param skuInfoParam SKU信息参数对象
     */
    @Override
    public void saveSkuInfo(SkuInfoParam skuInfoParam) {
        System.out.println("saveSkuInfo");
        // 将参数对象转换为实体对象
        SkuInfo skuInfo = skuInfoParamConverter.SkuInfoParam2Info(skuInfoParam);

        // 1. 保存sku基本信息
        skuInfoMapper.insert(skuInfo);

        // 2. 保存sku图片信息
        Optional.ofNullable(skuInfo.getSkuImageList())
                .ifPresent(imageList -> imageList.stream()
                        .peek(skuImage -> skuImage.setSkuId(skuInfo.getId()))
                        .forEach(skuImageMapper::insert));

        // 3. 保存sku销售属性值
        Optional.ofNullable(skuInfo.getSkuSaleAttributeValueList())
                .ifPresent(saleAttrList -> saleAttrList.stream()
                        .peek(saleAttr -> {
                            saleAttr.setSkuId(skuInfo.getId());
                            saleAttr.setSpuId(skuInfo.getSpuId());
                        })
                        .forEach(skuSaleAttrValueMapper::insert));

        // 4. 保存sku平台属性值
        Optional.ofNullable(skuInfo.getSkuPlatformAttributeValueList())
                .ifPresent(platformAttrList -> platformAttrList.stream()
                        .peek(platformAttr -> platformAttr.setSkuId(skuInfo.getId()))
                        .forEach(skuPlatformAttrValueMapper::insert));
    }

    /**
     * 分页查询SKU列表
     * 按ID降序排列
     *
     * @param pageParam 分页参数
     * @return SKU信息分页数据传输对象
     */
    @Override
    public SkuInfoPageDTO getPage(Page<SkuInfo> pageParam) {
        // 创建查询条件包装器
        LambdaQueryWrapper<SkuInfo> skuInfoQueryWrapper = new LambdaQueryWrapper<>();
        // 按ID降序排序
        skuInfoQueryWrapper.orderByDesc(SkuInfo::getId);
        // 执行分页查询
        Page<SkuInfo> skuInfoPage = skuInfoMapper.selectPage(pageParam, skuInfoQueryWrapper);
        // 转换为DTO对象并返回
        return skuInfoPageConverter.skuInfoPagePO2PageDTO(skuInfoPage);
    }

    /**
     * 商品上架
     * 将商品状态设置为上架(1)
     *
     * @param skuId SKU的ID
     */
    @Override
    public void onSale(Long skuId) {
        // 创建更新对象
        SkuInfo skuInfoUp = new SkuInfo();
        skuInfoUp.setId(skuId);
        // 设置销售状态为1(上架)
        skuInfoUp.setIsSale(1);
        // 更新数据库
        skuInfoMapper.updateById(skuInfoUp);
    }

    /**
     * 商品下架
     * 将商品状态设置为下架(0)
     *
     * @param skuId SKU的ID
     */
    @Override
    public void offSale(Long skuId) {
        // 创建更新对象
        SkuInfo skuInfoUp = new SkuInfo();
        skuInfoUp.setId(skuId);
        // 设置销售状态为0(下架)
        skuInfoUp.setIsSale(0);
        // 更新数据库
        skuInfoMapper.updateById(skuInfoUp);
    }

    @Override
    public SkuInfoDTO getSkuInfo(Long skuId) {
        SkuInfo skuInfo = skuInfoMapper.selectById(skuId);
        // 根据skuId 查询图片列表集合
        List<SkuImage> skuImageList = skuImageMapper.getSkuImages(skuId);
        skuInfo.setSkuImageList(skuImageList);
        return skuInfoConverter.skuInfoPO2DTO(skuInfo);
    }



    @Override
    public BigDecimal getSkuPrice(Long skuId) {
        SkuInfo skuInfo = skuInfoMapper.selectById(skuId);
        if (null != skuInfo) {
            return skuInfo.getPrice();
        }
        return new BigDecimal("0");
    }

    @Override
    public List<SpuSaleAttributeInfoDTO> getSpuSaleAttrListCheckBySku(Long skuId, Long spuId) {
        List<SpuSaleAttributeInfo> spuSaleAttributeInfos = spuSaleAttrInfoMapper.selectSpuSaleAttrListCheckedBySku(skuId, spuId);
        return spuInfoConverter.spuSaleAttributeInfoPOs2DTOs(spuSaleAttributeInfos);
    }

    @Override
    public List<PlatformAttributeInfoDTO> getPlatformAttrInfoBySku(Long skuId) {
        List<PlatformAttributeInfo> platformAttributeInfos = platformAttrInfoMapper.selectPlatformAttrInfoListBySkuId(skuId);
        List<PlatformAttributeInfoDTO> platformAttributeInfoDTOs = platformAttributeInfoConverter.platformAttributeInfoPOs2DTOs(platformAttributeInfos);
        return platformAttributeInfoDTOs;
    }
}