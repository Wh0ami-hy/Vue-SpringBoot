package com.yatong.exam.utils;

import com.yatong.exam.constant.enums.ResultCode;
import lombok.Getter;
@Getter
public class Result<T> {
    /**      * 状态码      */
    private int code;
    /**      * 响应信息，用来说明响应情况      */
    private String msg;
    /**      * 响应的具体数据      */
    private T data;

    public Result(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}