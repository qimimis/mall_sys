package com.jzm.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jzm.mall.product.converter.PlatformAttributeInfoConverter;
import com.jzm.mall.product.converter.param.PlatformAttributeInfoParamConverter;
import com.jzm.mall.product.dto.PlatformAttributeInfoDTO;
import com.jzm.mall.product.mapper.PlatformAttrInfoMapper;
import com.jzm.mall.product.mapper.PlatformAttrValueMapper;
import com.jzm.mall.product.model.PlatformAttributeInfo;
import com.jzm.mall.product.model.PlatformAttributeValue;
import com.jzm.mall.product.param.PlatformAttributeParam;
import com.jzm.mall.product.service.PlatformAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 平台属性服务实现类
 */
@Service
public class PlatformAttributeServiceImpl implements PlatformAttributeService {

    @Autowired
    private PlatformAttrInfoMapper platformAttrInfoMapper;

    @Autowired
    private PlatformAttrValueMapper platformAttrValueMapper;

    @Autowired
    private PlatformAttributeInfoConverter platformAttributeInfoConverter;

    @Autowired
    private PlatformAttributeInfoParamConverter platformAttributeInfoParamConverter;

    @Override
    //@RedisCache(prefix = "platformAttrInfoList:") // 可选的缓存注解
    public List<PlatformAttributeInfoDTO> getPlatformAttrInfoList(Long firstLevelCategoryId
            , Long secondLevelCategoryId, Long thirdLevelCategoryId) {
        // 调用Mapper查询平台属性列表
        List<PlatformAttributeInfo> platformAttributeInfos = platformAttrInfoMapper.selectPlatFormAttrInfoList(
                firstLevelCategoryId, secondLevelCategoryId, thirdLevelCategoryId);
        // 将PO对象转换为DTO对象
        return platformAttributeInfoConverter.platformAttributeInfoPOs2DTOs(platformAttributeInfos);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void savePlatformAttrInfo(PlatformAttributeParam platformAttributeParam) {
        // 将前端参数转化为PO对象
        PlatformAttributeInfo platformAttributeInfo
                = platformAttributeInfoParamConverter.attributeInfoParam2Info(platformAttributeParam);

        // 判断是新增还是修改
        if (platformAttributeInfo.getId() != null) {
            // 修改数据
            platformAttrInfoMapper.updateById(platformAttributeInfo);
        } else {
            // 新增数据
            platformAttrInfoMapper.insert(platformAttributeInfo);
        }

        // 平台属性值处理，采用先删除后新增的方式
        LambdaQueryWrapper<PlatformAttributeValue> platformAttributeValueQueryWrapper = new LambdaQueryWrapper<>();
        // 删除平台属性原本在数据库中对应的属性值
        platformAttributeValueQueryWrapper.eq(PlatformAttributeValue::getAttrId, platformAttributeInfo.getId());
        platformAttrValueMapper.delete(platformAttributeValueQueryWrapper);

        // 获取页面传递过来的所有平台属性值数据
        List<PlatformAttributeValue> attrValueList = platformAttributeInfo.getAttrValueList();
        // 判断属性值列表是否为空
        if (!CollectionUtils.isEmpty(attrValueList)) {
            // 使用Stream和lambda表达式处理属性值列表
            attrValueList.stream()
                    .peek(platformAttributeValue -> platformAttributeValue.setAttrId(platformAttributeInfo.getId()))
                    .forEach(platformAttributeValue -> platformAttrValueMapper.insert(platformAttributeValue));
        }
    }

    @Override
    public PlatformAttributeInfoDTO getPlatformAttrInfo(Long attrId) {
        // 根据id查询平台属性
        PlatformAttributeInfo platformAttributeInfo = platformAttrInfoMapper.selectById(attrId);
        // 根据平台属性ID查询对应的属性值
        LambdaQueryWrapper<PlatformAttributeValue> platformAttributeValueQueryWrapper = new LambdaQueryWrapper<>();
        platformAttributeValueQueryWrapper.eq(PlatformAttributeValue::getAttrId, attrId);
        List<PlatformAttributeValue> platformAttributeValues = platformAttrValueMapper.selectList(platformAttributeValueQueryWrapper);
        // 将属性值列表设置到平台属性对象中
        platformAttributeInfo.setAttrValueList(platformAttributeValues);
        // 转换并返回DTO对象
        return platformAttributeInfoConverter.platformAttributeInfoPO2DTO(platformAttributeInfo);
    }
}