package com.yatong.exam.service;

import com.yatong.exam.model.vo.LoginBodyVo;

/**
 * @Author HouYi
 * @Date 2023/12/29 9:59
 * @Description 用户service接口
 * @Since version-1.0
 */
public interface UserService {

    String login(LoginBodyVo loginBodyVo);

    String addUser(LoginBodyVo loginBodyVo);

}
