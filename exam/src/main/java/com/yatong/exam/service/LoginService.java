package com.yatong.exam.service;

import com.yatong.exam.model.vo.LoginBodyVo;

import java.util.Map;

public interface LoginService {

    /**
     * @Author HouYi
     * @Date 2023/12/20 16:52
     * @Description 登录验证
     * @Param [username, password, code, uuid]
     * @Return java.lang.String
     * @Since version-1.0
     */
    public String login(LoginBodyVo loginBodyVo);
}
