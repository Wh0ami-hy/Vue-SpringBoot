package com.yatong.exam.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.yatong.exam.model.vo.BatchQuestionVo;
import com.yatong.exam.model.vo.LoginBodyVo;
import com.yatong.exam.service.Impl.LoginServiceImpl;
import com.yatong.exam.service.LoginService;
import com.yatong.exam.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author HouYi
 * @Date 2023/12/20 16:24
 * @Description 处理用户登录
 * @Since version-1.0
 */

@Slf4j
@Tag(name = "系统管理")
@RestController
@RequestMapping("/system")
public class SysController {

    @Autowired
    LoginServiceImpl loginService;


    @Operation(summary = "用户登录请求")
    @PostMapping("/login")
    public Result userLogin(@RequestBody @Validated LoginBodyVo loginBodyVo){
        String data = loginService.login(loginBodyVo);
        return new Result(data);
    }

    @Operation(summary = "用户状态")
    @PostMapping("/isLogin")
    public Result isLogin() {
        return new Result("是否登录：" + StpUtil.isLogin());
    }

    @Operation(summary = "用户登录注销")
    @PostMapping("/logout")
    public Result userLogout(){
        StpUtil.logout();
        return new Result("注销成功");
    }

    @Operation(summary = "用户所拥有的角色和权限")
    @PostMapping("/power")
    public Result userPower(){
        return new Result("用户角色：" + StpUtil.getRoleList().toString() + "\n" + "用户权限：" + StpUtil.getPermissionList().toString());
    }
}
