package com.yatong.exam.model.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Author HouYi
 * @Date 2023/12/20 14:57
 * @Description 用户登录对象
 * @Since version-1.0
 */

@Data
public class LoginBodyVo {
    @NotEmpty(message = "用户名不能为空")
    private String userName;

    @Size(message = "密码长度应为8到10位", min = 8, max = 10)
    private String password;
}
