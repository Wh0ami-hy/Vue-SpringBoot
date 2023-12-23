package com.yatong.exam.mapper;


import com.yatong.exam.model.vo.QuestionInfoVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {
    int insertQuestion(QuestionInfoVo questionInfoVo);
}
