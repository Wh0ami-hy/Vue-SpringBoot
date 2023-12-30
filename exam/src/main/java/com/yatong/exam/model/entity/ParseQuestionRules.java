package com.yatong.exam.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author HouYi
 * @Date 2023/12/9 15:36
 * @Description 题目解析规则
 * @Since version-1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParseQuestionRules {
    private String divisionRule;

    private String questionRule;

    private String answerRule;

    private String answerSplit;

    private String optionRule;

    private String scoreRule;
}
