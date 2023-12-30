package com.yatong.exam.model.vo;

import com.yatong.exam.model.entity.ExQuestion;
import com.yatong.exam.model.entity.ExQuestionItem;
import lombok.Data;

import java.util.List;

/**
 * @Author HouYi
 * @Date 2023/12/10 19:47
 * @Description 题目信息 + 题目内容
 * @Since version-1.0
 */
@Data
public class QuestionInfoVo extends ExQuestion {
    private List<ExQuestionItem> options;
}