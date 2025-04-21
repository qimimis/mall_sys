package com.jzm.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jzm.mall.product.converter.SpuInfoConverter;
import com.jzm.mall.product.converter.SpuInfoPageConverter;
import com.jzm.mall.product.converter.SpuInfoParamConverter;
import com.jzm.mall.product.dto.SpuImageDTO;
import com.jzm.mall.product.dto.SpuInfoPageDTO;
import com.jzm.mall.product.dto.SpuPosterDTO;
import com.jzm.mall.product.dto.SpuSaleAttributeInfoDTO;
import com.jzm.mall.product.entity.SpuImage;
import com.jzm.mall.product.entity.SpuInfo;
import com.jzm.mall.product.entity.SpuPoster;
import com.jzm.mall.product.entity.SpuSaleAttributeInfo;
import com.jzm.mall.product.mapper.*;
import com.jzm.mall.product.model.SkuSaleAttributeValuePermutation;
import com.jzm.mall.product.param.SpuInfoParam;
import com.jzm.mall.product.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * SPU服务实现类
 * 提供SPU相关的业务逻辑实现，包括SPU基本信息、图片、销售属性、海报等操作
 */
@Service
public class SpuServiceImpl implements SpuService {

    /**
     * SPU基本信息数据访问对象
     */
    @Autowired
    SpuInfoMapper spuInfoMapper;

    /**
     * SPU图片数据访问对象
     */
    @Autowired
    SpuImageMapper spuImageMapper;

    /**
     * SPU销售属性信息数据访问对象
     */
    @Autowired
    SpuSaleAttrInfoMapper spuSaleAttrInfoMapper;

    /**
     * SPU销售属性值数据访问对象
     */
    @Autowired
    SpuSaleAttrValueMapper spuSaleAttrValueMapper;

    /**
     * SKU销售属性值数据访问对象
     */
    @Autowired
    SkuSaleAttrValueMapper skuSaleAttrValueMapper;

    /**
     * SPU海报数据访问对象
     */
    @Autowired
    SpuPosterMapper spuPosterMapper;

    /**
     * SPU信息转换器
     */
    @Autowired
    SpuInfoConverter spuInfoConverter;

    /**
     * SPU分页信息转换器
     */
    @Autowired
    SpuInfoPageConverter spuInfoPageConverter;

    /**
     * SPU参数信息转换器
     */
    @Autowired
    SpuInfoParamConverter spuInfoParamConverter;

    /**
     * 获取指定类目下的SPU信息分页结果
     *
     * @param pageParam 分页参数
     * @param spuInfo SPU信息查询条件
     * @return SPU信息分页DTO
     */
    @Override
    public SpuInfoPageDTO getSpuInfoPage(Page<SpuInfo> pageParam, SpuInfoParam spuInfo) {
        // 构建查询条件：指定类目ID并按ID降序排序
        LambdaQueryWrapper<SpuInfo> spuInfoQueryWrapper = new LambdaQueryWrapper<>();
        spuInfoQueryWrapper.eq(SpuInfo::getThirdLevelCategoryId, spuInfo.getCategory3Id());
        spuInfoQueryWrapper.orderByDesc(SpuInfo::getId);

        // 执行分页查询
        Page<SpuInfo> spuInfoPage = spuInfoMapper.selectPage(pageParam, spuInfoQueryWrapper);

        // 转换为DTO并返回
        return spuInfoPageConverter.spuInfoPage2PageDTO(spuInfoPage);
    }

    /**
     * 保存SPU（Standard Product Unit）信息及其关联数据
     * 包括基本信息、图片、销售属性、销售属性值和海报
     *
     * @param spuInfoParam SPU信息参数对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSpuInfo(SpuInfoParam spuInfoParam) {
        // 1. 将DTO转换为实体并保存SPU基本信息
        SpuInfo spuInfo = spuInfoParamConverter.spuInfoParam2Info(spuInfoParam);
        spuInfoMapper.insert(spuInfo);

        // 获取生成的SPU ID，用于关联子表数据
        Long spuId = spuInfo.getId();

        /*
        List<SpuImage> spuImageList = spuInfo.getSpuImageList();
        //  判断不为空
        if (!CollectionUtils.isEmpty(spuImageList)) {
            //  循环遍历
            for (SpuImage spuImage : spuImageList) {
                //  需要将spuId 赋值
                spuImage.setSpuId(spuInfo.getId());
                //  保存spuImge
                spuImageMapper.insert(spuImage);
            }
        }
        */

        // 2. 处理并保存SPU图片列表
        Optional.ofNullable(spuInfo.getSpuImageList())
                .filter(list -> !list.isEmpty())
                .ifPresent(spuImageList ->
                        spuImageList.forEach(spuImage -> {
                            spuImage.setSpuId(spuId);
                            spuImageMapper.insert(spuImage);
                        })
                );

        /*
        List<SpuSaleAttributeInfo> spuSaleAttributeInfoList = spuInfo.getSpuSaleAttributeInfoList();
        if (!CollectionUtils.isEmpty(spuSaleAttributeInfoList)) {
            for (SpuSaleAttributeInfo spuSaleAttrInfo : spuSaleAttributeInfoList) {
                // 设置关联的SPU ID
                spuSaleAttrInfo.setSpuId(spuInfo.getId());
                spuSaleAttrInfoMapper.insert(spuSaleAttrInfo);
                // 保存销售属性值
                List<SpuSaleAttributeValue> spuSaleAttributeValueList = spuSaleAttrInfo.getSpuSaleAttrValueList();
                if (!CollectionUtils.isEmpty(spuSaleAttributeValueList)) {
                    for (SpuSaleAttributeValue spuSaleAttrValue : spuSaleAttributeValueList) {
                        // 设置关联的SPU ID和销售属性ID
                        spuSaleAttrValue.setSpuId(spuInfo.getId());
                        spuSaleAttrValue.setSpuSaleAttrId(spuSaleAttrInfo.getId());
                        spuSaleAttrValueMapper.insert(spuSaleAttrValue);
                    }
                }
            }
        }
        */
        // 3. 处理并保存SPU销售属性及其属性值
        Optional.ofNullable(spuInfo.getSpuSaleAttributeInfoList())
                .filter(list -> !list.isEmpty())
                .ifPresent(spuSaleAttributeInfoList ->
                        spuSaleAttributeInfoList.forEach(spuSaleAttrInfo -> {
                            // 3.1 设置SPU ID并保存销售属性信息
                            spuSaleAttrInfo.setSpuId(spuId);
                            spuSaleAttrInfoMapper.insert(spuSaleAttrInfo);

                            // 获取生成的销售属性ID，用于关联属性值
                            Long saleAttrId = spuSaleAttrInfo.getId();

                            // 3.2 处理并保存销售属性值
                            Optional.ofNullable(spuSaleAttrInfo.getSpuSaleAttrValueList())
                                    .filter(list -> !list.isEmpty())
                                    .ifPresent(spuSaleAttributeValueList ->
                                            spuSaleAttributeValueList.forEach(spuSaleAttrValue -> {
                                                spuSaleAttrValue.setSpuId(spuId);
                                                spuSaleAttrValue.setSpuSaleAttrId(saleAttrId);
                                                spuSaleAttrValueMapper.insert(spuSaleAttrValue);
                                            })
                                    );
                        })
                );

        // 4. 处理并保存SPU海报列表
        Optional.ofNullable(spuInfo.getSpuPosterList())
                .filter(list -> !list.isEmpty())
                .ifPresent(spuPosterList -> {
                    // 获取当前时间，避免在循环中多次创建Date对象
                    Date now = new Date();

                    spuPosterList.forEach(spuPoster -> {
                        spuPoster.setSpuId(spuId);
                        spuPoster.setCreateTime(now);
                        spuPoster.setUpdateTime(now);
                        spuPosterMapper.insert(spuPoster);
                    });
                });
    }

    /**
     * 根据SPU ID查询图片列表
     *
     * @param spuId SPU ID
     * @return SPU图片DTO列表
     */
    @Override
    public List<SpuImageDTO> getSpuImageList(Long spuId) {
        // 构建查询条件：指定SPU ID
        LambdaQueryWrapper<SpuImage> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SpuImage::getSpuId, spuId);

        // 执行查询
        List<SpuImage> spuImages = spuImageMapper.selectList(queryWrapper);

        // 转换为DTO并返回
        return spuInfoConverter.spuImagePOs2DTOs(spuImages);
    }

    /**
     * 根据SPU ID查询销售属性列表
     *
     * @param spuId SPU ID
     * @return SPU销售属性信息DTO列表
     */
    @Override
    public List<SpuSaleAttributeInfoDTO> getSpuSaleAttrList(Long spuId) {
        // 调用Mapper自定义方法查询销售属性及其属性值
        List<SpuSaleAttributeInfo> spuSaleAttributeInfos = spuSaleAttrInfoMapper.selectSpuSaleAttrList(spuId);

        // 转换为DTO并返回
        return spuInfoConverter.spuSaleAttributeInfoPOs2DTOs(spuSaleAttributeInfos);
    }

    /**
     * 根据SPU ID查询海报列表
     * 可使用Redis缓存优化性能（当前注释掉）
     *
     * @param spuId SPU ID
     * @return SPU海报DTO列表
     */
    @Override
    //@RedisCache(prefix = "SpuPosterList:")
    public List<SpuPosterDTO> findSpuPosterBySpuId(Long spuId) {
        // 构建查询条件：指定SPU ID
        QueryWrapper<SpuPoster> spuInfoQueryWrapper = new QueryWrapper<>();
        spuInfoQueryWrapper.eq("spu_id", spuId);

        // 执行查询
        List<SpuPoster> spuPosterList = spuPosterMapper.selectList(spuInfoQueryWrapper);

        // 转换为DTO并返回
        return spuInfoConverter.spuPosterPOs2DTOs(spuPosterList);
    }

    /**
     * 获取SKU销售属性值组合与SKU ID的映射
     * 用于前端快速切换SKU
     * 可使用Redis缓存优化性能（当前注释掉）
     *
     * @param spuId SPU ID
     * @return 销售属性值组合字符串到SKU ID的映射
     */
    @Override
    public Map<String, Long> getSkuValueIdsMap(Long spuId) {
        // 获取属性值组合的排列
        List<SkuSaleAttributeValuePermutation> permutationList = skuSaleAttrValueMapper.selectSaleAttrValuesBySpu(spuId);

        // 构建映射：key=属性值ID组合（如"125|123"），value=对应的SKU ID
        HashMap<String, Long> valueIdsMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(permutationList)) {
            permutationList.forEach(singlePermutation -> {
                valueIdsMap.put(singlePermutation.getSkuSaleAttrValuePermutation(),
                        singlePermutation.getSkuId());
            });
        }

        return valueIdsMap;
    }
}