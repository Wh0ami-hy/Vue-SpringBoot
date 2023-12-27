package com.yatong.exam.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StpMapper {
    List<Map<String,Object>> getRole(Integer userId);
    List<Map<String,Object>> getPermission(Integer userId);
}
