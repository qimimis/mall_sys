package com.jzm.mall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzm.mall.product.model.SkuImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SkuImageMapper extends BaseMapper<SkuImage> {

    public List<SkuImage> getSkuImages(@Param("skuId") Long skuId);

}
