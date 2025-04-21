package com.jzm.mall.product.service;

import com.jzm.mall.product.dto.PlatformAttributeInfoDTO;
import com.jzm.mall.product.param.PlatformAttributeParam;

import java.util.List;

/**
 * 平台属性服务接口
 */
public interface PlatformAttributeService {

    /**
     * 根据分类Id 获取平台属性数据
     * 接口说明：
     *      1，平台属性可以挂在一级分类、二级分类和三级分类
     *      2，查询一级分类下面的平台属性，传：firstlevelCatogoryId，0，0；取出该分类的平台属性
     *      3，查询二级分类下面的平台属性，传：firstlevelCatogoryId，category2Id，0；
     *         取出对应一级分类下面的平台属性与二级分类对应的平台属性
     *      4，查询三级分类下面的平台属性，传：firstlevelCatogoryId，category2Id，category3Id；
     *         取出对应一级分类、二级分类与三级分类对应的平台属性
     * @param firstLevelCategoryId 一级分类ID
     * @param secondLevelCategoryId 二级分类ID
     * @param thirdLevelCategoryId 三级分类ID
     * @return 平台属性列表
     */
    List<PlatformAttributeInfoDTO> getPlatformAttrInfoList(Long firstLevelCategoryId, Long secondLevelCategoryId, Long thirdLevelCategoryId);

    /**
     * 保存平台属性信息
     * @param platformAttributeParam 平台属性参数
     */
    void savePlatformAttrInfo(PlatformAttributeParam platformAttributeParam);

    /**
     * 根据属性ID获取平台属性信息
     * @param attrId 属性ID
     * @return 平台属性信息
     */
    PlatformAttributeInfoDTO getPlatformAttrInfo(Long attrId);
}