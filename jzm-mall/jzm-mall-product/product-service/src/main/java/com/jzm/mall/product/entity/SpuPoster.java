package com.jzm.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jzm.mall.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "SpuPoster")
@TableName("spu_poster")
public class SpuPoster extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(title = "商品id")
    @TableField("spu_id")
    private Long spuId;

    @Schema(title = "文件名称")
    @TableField("img_name")
    private String imgName;

    @Schema(title = "文件路径")
    @TableField("img_url")
    private String imgUrl;

    @Schema(title = "创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

    @Schema(title = "更新时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    private Date updateTime;

    @Schema(title = "逻辑删除(1:已删除，0:未删除)")
    @JsonIgnore
    @TableLogic
    @TableField("is_deleted")
    private Integer isDeleted;
}