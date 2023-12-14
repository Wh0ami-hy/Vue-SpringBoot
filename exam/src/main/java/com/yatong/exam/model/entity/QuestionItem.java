package com.yatong.exam.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author HouYi
 * @Date 2023/12/10 19:48
 * @Description 题目详细内容实体
 * @Since version-1.0
 */
@Data
public class QuestionItem {
    private static final long serialVersionUID = 1L;

    private Integer questionItemId;

    @Schema(description = "选项内容\n" +
            "选择性题目：为选项\n" +
            "填空题/客观题：null\n")
    private String content;

    @Schema(description = "题目id")
    private Integer questionId;

    @Schema(description = "选项答案：\n" +
            "选择性题目：非null就是正确答案\n" +
            "填空题/客观题：为正确答案\n")
    private String answer;
}
