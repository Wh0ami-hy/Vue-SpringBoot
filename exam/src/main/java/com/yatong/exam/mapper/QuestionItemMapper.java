package com.yatong.exam.mapper;

import com.yatong.exam.model.entity.ExQuestionItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionItemMapper {
    int insertItem(ExQuestionItem exQuestionItem);
}
