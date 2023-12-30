package com.yatong.exam.model.entity;

import lombok.Data;

/**
 * @Author HouYi
 * @Date 2023/12/10 19:48
 * @Description 题目详细内容实体
 * @Since version-1.0
 */
@Data
public class ExQuestionItem {
    private static final long serialVersionUID = 1L;

    private Integer questionItemId;

    private String content;

    private Integer questionId;

    private String answer;
}
