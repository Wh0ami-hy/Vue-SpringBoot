package com.yatong.exam.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "分割规则")
    private String divisionRule;

    @Schema(description = "题目规则")
    private String questionRule;

    @Schema(description = "答案规则")
    private String answerRule;

    @Schema(description = "答案分割")
    private String answerSplit;

    @Schema(description = "选择规则")
    private String optionRule;

    @Schema(description = "分数规则")
    private String scoreRule;
}
