package com.jzm.mall.product.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jzm.mall.product.dto.TrademarkPageDTO;
import com.jzm.mall.product.model.Trademark;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = TrademarkConverter.class)
public interface TrademarkPageConverter {

    TrademarkPageDTO tradeMarkPagePO2PageDTO(IPage<Trademark> trademarkPage);
}