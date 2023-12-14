package com.yatong.exam.mapper;


import com.yatong.exam.model.vo.QuestionInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {
    int insertQuestion(QuestionInfoVo questionInfoVo);
}
