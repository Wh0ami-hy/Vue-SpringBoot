package com.yatong.exam.model.entity;

import com.yatong.exam.model.base.BaseEntity;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * @Author HouYi
 * @Date 2023/12/10 19:48
 * @Description 题目信息实体
 * @Since version-1.0
 */

@Data
public class ExQuestion extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Integer questionId;

    @NotBlank(message = "题目名称不能空")
    private String content;

    @NotNull(message = "题目类型不能空")
    private Integer type;

    @Min(message = "题目难度应在0~5之间",value = 0)
    @Max(message = "题目难度应在0~5之间",value = 5)
    private Integer difficulty;

    @Min(message = "题目分值应在1~100分之间",value = 1)
    @Max(message = "题目分值应在1~100分之间",value = 100)
    private Float score;

    @NotEmpty
    private Integer questionTagId;
}
