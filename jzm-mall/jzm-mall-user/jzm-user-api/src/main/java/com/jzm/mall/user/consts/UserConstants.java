package com.jzm.mall.user.consts;

public class UserConstants {

    // Redis 键前缀：存储用户登录信息
    public static final String USER_LOGIN_KEY_PREFIX = "user:login:";

    // 用户登录状态过期时间（单位：秒），这里设置为 7 天
    public static final int USERKEY_TIMEOUT = 60 * 60 * 24 * 7;

    // 前端请求头中存放 token 的键名
    public static final String USER_LOGIN_TOKEN_HEADER = "token";
}