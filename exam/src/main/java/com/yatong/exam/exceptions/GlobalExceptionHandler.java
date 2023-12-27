package com.yatong.exam.exceptions;

import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.util.SaResult;
import com.yatong.exam.utils.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    public Result handleAppException(SaTokenException e, HttpServletRequest request) {
//        e.printStackTrace();
//        return new Result(e.getMessage());
//    }
}
