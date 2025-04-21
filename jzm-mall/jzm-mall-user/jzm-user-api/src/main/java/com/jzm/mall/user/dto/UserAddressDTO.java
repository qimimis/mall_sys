package com.jzm.mall.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserAddressDTO implements Serializable {

    private Long id;

    @Schema(title = "用户地址")
    private String userAddress;

    @Schema(title = "用户id")
    private Long userId;

    @Schema(title = "收件人")
    private String consignee;

    @Schema(title = "联系方式")
    private String phoneNum;

    @Schema(title = "是否是默认")
    private String isDefault;
}