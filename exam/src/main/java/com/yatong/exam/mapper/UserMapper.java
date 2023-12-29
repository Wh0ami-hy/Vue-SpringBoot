package com.yatong.exam.mapper;

import com.yatong.exam.model.vo.LoginBodyVo;
import org.apache.ibatis.annotations.Mapper;
import java.util.Map;

/**
 * @Author HouYi
 * @Date 2023/12/29 9:49
 * @Description 用户mapper
 * @Since version-1.0
 */
@Mapper
public interface UserMapper {

    Map<String,Object> getPasswordByName(String userName);

    int addUser(Map map);

    int countByUserName(String userName);
}
