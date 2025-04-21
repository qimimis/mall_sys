package com.jzm.mall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzm.mall.product.entity.SpuSaleAttributeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface SpuSaleAttrInfoMapper extends BaseMapper<SpuSaleAttributeInfo> {
    // 根据spuId 查询销售属性集合
    List<SpuSaleAttributeInfo> selectSpuSaleAttrList(@Param("spuId") Long spuId);

    // 根据skuId和spuId查询销售属性集合，并标记选中状态
    List<SpuSaleAttributeInfo> selectSpuSaleAttrListCheckedBySku(@Param("skuId") Long skuId, @Param("spuId") Long spuId);



}