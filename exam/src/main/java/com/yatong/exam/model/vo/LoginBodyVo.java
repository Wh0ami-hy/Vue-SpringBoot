package com.yatong.exam.model.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author HouYi
 * @Date 2023/12/20 14:57
 * @Description 用户登录对象
 * @Since version-1.0
 */

@Data
public class LoginBodyVo {
    @NotNull(message = "用户名不能为空")
    private String userName;
    @NotNull(message = "密码不能为空")
    private String password;
}
