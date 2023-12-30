package com.yatong.exam.model.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author HouYi
 * @Date 2023/12/9 15:29
 * @Description 接收前端的HTML题目文本
 * @Since version-1.0
 */

@Data
public class ParseQuestionVo {
    @NotEmpty(message = "题目文本不能空")
    private String questionsText;
}
