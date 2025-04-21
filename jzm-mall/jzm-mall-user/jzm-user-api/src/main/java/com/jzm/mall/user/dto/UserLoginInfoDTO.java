package com.jzm.mall.user.dto;

import lombok.Data;

@Data
public class UserLoginInfoDTO {

    private String userId;    // 用户唯一标识（通常是数据库主键）
    private String ip;        // 登录时记录的用户 IP 地址
}