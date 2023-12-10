package com.yatong.exam.model.vo;

import com.yatong.exam.model.entity.Question;
import com.yatong.exam.model.entity.QuestionItem;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;


@Data
@Schema(name = "QuestionInfoVo", description = "题目具体信息")
public class QuestionInfoVo extends Question {
    private List<QuestionItem> options;
}