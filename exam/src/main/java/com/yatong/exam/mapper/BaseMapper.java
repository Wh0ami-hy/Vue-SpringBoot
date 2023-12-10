package com.yatong.exam.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseMapper<T> {

    int insert(T entity);


    int deleteById(Integer id);


    int deleteById(T entity);
}
