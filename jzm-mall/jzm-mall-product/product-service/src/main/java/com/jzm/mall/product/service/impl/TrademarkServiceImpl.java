package com.jzm.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jzm.mall.product.converter.TrademarkConverter;
import com.jzm.mall.product.converter.TrademarkPageConverter;
import com.jzm.mall.product.dto.TrademarkDTO;
import com.jzm.mall.product.dto.TrademarkPageDTO;
import com.jzm.mall.product.mapper.TrademarkMapper;
import com.jzm.mall.product.model.Trademark;
import com.jzm.mall.product.query.TrademarkParam;
import com.jzm.mall.product.service.TrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrademarkServiceImpl implements TrademarkService {

    @Autowired
    private TrademarkMapper trademarkMapper;

    @Autowired
    private TrademarkPageConverter pageConverter;

    @Autowired
    private TrademarkConverter trademarkConverter;

    @Override
    public TrademarkDTO getTrademarkByTmId(Long tmId) {
        // 根据ID查询商标实体
        Trademark trademark = trademarkMapper.selectById(tmId);
        // 实体转DTO
        TrademarkDTO trademarkDTO = trademarkConverter.trademarkPO2DTO(trademark);
        return trademarkDTO;
    }

    @Override
    public TrademarkPageDTO getPage(Page<Trademark> pageParam) {
        // 创建查询条件，按ID升序排序
        LambdaQueryWrapper<Trademark> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Trademark::getId);
        // 执行分页查询
        IPage<Trademark> page = trademarkMapper.selectPage(pageParam, queryWrapper);

        // 将分页结果转换为DTO
        TrademarkPageDTO trademarkPageDTO = pageConverter.tradeMarkPagePO2PageDTO(page);

        return trademarkPageDTO;
    }

    @Override
    public void save(TrademarkParam trademarkParam) {
        // 参数对象转实体
        Trademark trademark = trademarkConverter.trademarkParam2Trademark(trademarkParam);
        // 插入数据库
        trademarkMapper.insert(trademark);
    }

    @Override
    public void updateById(TrademarkParam trademarkParam) {
        // 参数对象转实体
        Trademark trademark = trademarkConverter.trademarkParam2Trademark(trademarkParam);
        // 更新数据库
        trademarkMapper.updateById(trademark);
    }

    @Override
    public void removeById(Long id) {
        // 删除指定ID的记录
        trademarkMapper.deleteById(id);
    }
}