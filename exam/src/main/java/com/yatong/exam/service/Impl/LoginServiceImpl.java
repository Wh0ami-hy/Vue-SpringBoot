package com.yatong.exam.service.Impl;

import cn.dev33.satoken.stp.StpUtil;
import com.yatong.exam.mapper.LoginMapper;
import com.yatong.exam.model.entity.SysUser;
import com.yatong.exam.model.vo.LoginBodyVo;
import com.yatong.exam.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;


    @Override
    public String login(LoginBodyVo loginBodyVo) {
        Map<String,Object> idAndPassword = loginMapper.getPasswordByName(loginBodyVo.getUserName());
        if (idAndPassword.get("password").equals(loginBodyVo.getPassword())){
            StpUtil.login(idAndPassword.get("user_id"));
            return "登录成功";
        }
        return "登录失败";
    }
}
