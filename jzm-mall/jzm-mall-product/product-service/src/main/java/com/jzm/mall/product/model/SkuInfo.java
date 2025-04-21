package com.jzm.mall.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jzm.mall.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * SKU信息实体类
 * 用于存储商品SKU的基本信息
 */
@Data
@Schema(description = "SkuInfo")
@TableName("sku_info")
public class SkuInfo extends BaseEntity {

    /**
     * 无参构造函数
     */
    public SkuInfo(){}

    /**
     * 通过SKU ID构造对象
     * @param skuId SKU ID
     */
    public SkuInfo(Long skuId){
        setId(skuId);
    }

    /**
     * 判断两个SKU是否相等，通过ID比较
     * 用于集合去重操作
     * @param skuInfo 比较的SKU对象
     * @return 是否相等
     */
    public boolean equals(SkuInfo skuInfo){
        return getId().equals(skuInfo.getId());
    }

    private static final long serialVersionUID = 1L;

    /**
     * 所属SPU ID
     */
    @Schema(title = "商品id")
    @TableField("spu_id")
    private Long spuId;

    /**
     * SKU价格
     */
    @Schema(title = "价格")
    @TableField("price")
    private BigDecimal price;

    /**
     * SKU名称
     */
    @Schema(title = "sku名称")
    @TableField("sku_name")
    private String skuName;

    /**
     * SKU描述信息
     */
    @Schema(title = "商品规格描述")
    @TableField("sku_desc")
    private String skuDesc;

    /**
     * 商品重量
     */
    @Schema(title = "重量")
    @TableField("weight")
    private String weight;

    /**
     * 品牌ID(冗余字段)
     */
    @Schema(title = "品牌(冗余)")
    @TableField("tm_id")
    private Long tmId;

    /**
     * 三级分类ID(冗余字段)
     */
    @Schema(title = "三级分类id（冗余)")
    @TableField("category3_id")
    private Long thirdLevelCategoryId;

    /**
     * 默认显示图片(冗余字段)
     */
    @Schema(title = "默认显示图片(冗余)")
    @TableField("sku_default_img")
    private String skuDefaultImg;

    /**
     * 是否上架销售（1：是 0：否）
     */
    @Schema(title = "是否销售（1：是 0：否）")
    @TableField("is_sale")
    private Integer isSale;

    /**
     * SKU图片列表，不在数据库表中
     */
    @TableField(exist = false)
    List<SkuImage> SkuImageList;

    /**
     * SKU平台属性值列表，不在数据库表中
     */
    @TableField(exist = false)
    List<SkuPlatformAttributeValue> skuPlatformAttributeValueList;

    /**
     * SKU销售属性值列表，不在数据库表中
     */
    @TableField(exist = false)
    List<SkuSaleAttributeValue> skuSaleAttributeValueList;
}