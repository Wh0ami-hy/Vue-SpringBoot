package com.yatong.exam.controller;

import com.yatong.exam.model.vo.BatchQuestionVo;
import com.yatong.exam.model.vo.LoginBodyVo;
import com.yatong.exam.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
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

    @Operation(summary = "用户登录验证")
    @PostMapping("/login")
    public Result UserLogin(@RequestBody @Validated LoginBodyVo loginBodyVo){

        return null;
    }

}
