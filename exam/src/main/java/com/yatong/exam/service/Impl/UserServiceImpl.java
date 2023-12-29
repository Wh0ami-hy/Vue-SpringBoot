package com.yatong.exam.service.Impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import com.yatong.exam.mapper.UserMapper;
import com.yatong.exam.model.vo.LoginBodyVo;
import com.yatong.exam.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public String login(LoginBodyVo loginBodyVo) {
        Map<String,Object> idPasswordSalt = userMapper.getPasswordByName(loginBodyVo.getUserName());
        if (idPasswordSalt == null) {
            return "账号或密码错误";
        }
        String salt = idPasswordSalt.get("salt").toString();
        String password = idPasswordSalt.get("password").toString();
        if (BCrypt.checkpw(salt + loginBodyVo.getPassword(), password)){
            StpUtil.login(idPasswordSalt.get("user_id"));
            return "登录成功";
        }
        return "登录失败";
    }

    @Override
    public String addUser(LoginBodyVo loginBodyVo) {
        int result = 0;
        String userName = loginBodyVo.getUserName();
        String password = loginBodyVo.getPassword();
        String salt = BCrypt.gensalt(10);
        String enPassword = BCrypt.hashpw(salt + password, salt);
        Map registerUser = new HashMap<String,Object>();
        registerUser.put("userName", userName);
        registerUser.put("password", enPassword);
        registerUser.put("salt", salt);

        int countUser = userMapper.countByUserName(userName);
        if (countUser > 0){
            return "用户名已存在";
        }

        result =  userMapper.addUser(registerUser);
        if (result == 1){
            log.info("salt：" + salt);
            log.info("enPassword：" + enPassword);
            return userName + "：注册成功";
        }
        return "注册失败";
    }
}
