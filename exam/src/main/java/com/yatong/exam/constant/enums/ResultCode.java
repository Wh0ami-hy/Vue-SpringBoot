package com.yatong.exam.constant.enums;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(2000, "操作成功"),
    FAILED(2001, "响应失败"),
    VALIDATE_FAILED(2002, "参数校验失败"),
    ERROR(5000, "未知错误");
    private int code;
    private String msg;
    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}