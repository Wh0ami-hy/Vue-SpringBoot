package com.yatong.exam.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface LoginMapper {
    Map<String,Object> getPasswordByName(String userName);
}
