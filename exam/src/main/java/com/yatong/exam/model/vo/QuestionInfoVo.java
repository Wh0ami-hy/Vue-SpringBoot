package com.yatong.exam.model.vo;

import lombok.Data;

import java.util.List;


@Data
public class QuestionInfoVo extends Question {
    private List<QuestionItem> options;
}