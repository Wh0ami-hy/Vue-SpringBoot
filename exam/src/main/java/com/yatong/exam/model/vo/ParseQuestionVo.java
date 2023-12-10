package com.yatong.exam.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author HouYi
 * @Date 2023/12/9 15:29
 * @Description 接收前端的HTML题目文本
 * @Since version-1.0
 */

@Data
public class ParseQuestionVo {
    @NotBlank(message = "题目文本不能空")
    @Schema(description = "题目文本")
    private String questionsText;
}
