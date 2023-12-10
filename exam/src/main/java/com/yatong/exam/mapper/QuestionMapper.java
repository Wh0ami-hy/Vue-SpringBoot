package com.yatong.exam.mapper;

import com.yatong.exam.model.entity.Question;
import com.yatong.exam.model.vo.QuestionInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface QuestionMapper extends BaseMapper<Question>{
    int insertBatch(List<QuestionInfoVo> questionInfo);

}
