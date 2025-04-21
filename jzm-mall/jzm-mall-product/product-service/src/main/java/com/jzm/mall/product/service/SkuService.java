package com.jzm.mall.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jzm.mall.product.dto.PlatformAttributeInfoDTO;
import com.jzm.mall.product.dto.SkuInfoDTO;
import com.jzm.mall.product.dto.SkuInfoPageDTO;
import com.jzm.mall.product.dto.SpuSaleAttributeInfoDTO;
import com.jzm.mall.product.model.SkuInfo;
import com.jzm.mall.product.param.SkuInfoParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * SKU服务接口
 * 提供SKU相关的业务操作方法
 */
public interface SkuService {

    /**
     * 保存SKU信息
     * 包括SKU基本信息、图片信息、销售属性值和平台属性值
     *
     * @param skuInfo SKU信息参数对象
     */
    void saveSkuInfo(SkuInfoParam skuInfo);

    /**
     * 根据分页参数查询SKU分页数据
     *
     * @param pageParam 分页参数
     * @return SKU信息分页数据传输对象
     */
    SkuInfoPageDTO getPage(Page<SkuInfo> pageParam);

    /**
     * 商品上架
     * 将指定SKU的销售状态修改为上架
     *
     * @param skuId SKU的ID
     */
    void onSale(Long skuId);

    /**
     * 商品下架
     * 将指定SKU的销售状态修改为下架
     *
     * @param skuId SKU的ID
     */
    void offSale(Long skuId);

    public List<SpuSaleAttributeInfoDTO> getSpuSaleAttrListCheckBySku(Long skuId, Long spuId);


    public SkuInfoDTO getSkuInfo(Long skuId);

    public BigDecimal getSkuPrice(Long skuId);

    public List<PlatformAttributeInfoDTO> getPlatformAttrInfoBySku(Long skuId);
}
