package com.jzm.mall.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jzm.mall.product.dto.SpuImageDTO;
import com.jzm.mall.product.dto.SpuInfoPageDTO;
import com.jzm.mall.product.dto.SpuPosterDTO;
import com.jzm.mall.product.dto.SpuSaleAttributeInfoDTO;
import com.jzm.mall.product.entity.SpuInfo;
import com.jzm.mall.product.param.SpuInfoParam;

import java.util.List;
import java.util.Map;

public interface SpuService {
    /**
     * 获取SPU信息分页结果
     *
     * @param pageParam 分页参数
     * @param spuInfo SPU信息查询条件
     * @return SPU信息分页DTO
     */
    SpuInfoPageDTO getSpuInfoPage(Page<SpuInfo> pageParam, SpuInfoParam spuInfo);

    /**
     * 保存SPU信息
     * 包括基本信息、图片、销售属性、海报等相关数据
     *
     * @param spuInfoParam SPU信息参数
     */
    void saveSpuInfo(SpuInfoParam spuInfoParam);

    /**
     * 根据SPU ID获取图片列表
     *
     * @param spuId SPU ID
     * @return SPU图片DTO列表
     */
    List<SpuImageDTO> getSpuImageList(Long spuId);

    /**
     * 根据SPU ID获取销售属性列表
     *
     * @param spuId SPU ID
     * @return SPU销售属性信息DTO列表
     */
    List<SpuSaleAttributeInfoDTO> getSpuSaleAttrList(Long spuId);

    /**
     * 根据SPU ID查询海报列表
     *
     * @param spuId SPU ID
     * @return SPU海报DTO列表
     */
    List<SpuPosterDTO> findSpuPosterBySpuId(Long spuId);

    /**
     * 获取SKU销售属性值组合与SKU ID的映射
     *
     * @param spuId SPU ID
     * @return 销售属性值组合字符串到SKU ID的映射
     */
//    Map<String, Long> getSkuValueIdsMap(Long spuId);
}