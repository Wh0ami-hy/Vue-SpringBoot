package com.yatong.exam.model.vo;

import com.yatong.exam.model.entity.SysUser;
import lombok.Data;

import java.util.Set;

/**
 * @Author HouYi
 * @Date 2023/12/20 15:13
 * @Description 登录后用户的身份权限
 * @Since version-1.0
 */

@Data
public class LoginUserVo {
    private static final long serialVersionUID = 1L;

    private SysUser user;

    private String token;

    private Set<String> permissions;


}
