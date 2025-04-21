package com.jzm.mall.user.consts;

import com.jzm.mall.common.constant.CodeEnum;
import lombok.Getter;

@Getter
public enum UserCodeEnum implements CodeEnum {

    USER_LOGIN_CHECK_FAIL(1001, "用户名或密码错误");

    private final Integer code;
    private final String message;

    UserCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}