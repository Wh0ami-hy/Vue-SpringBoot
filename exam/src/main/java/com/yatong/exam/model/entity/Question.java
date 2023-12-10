package com.yatong.exam.model.entity;

import com.yatong.exam.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Schema(name = "Question", description = "题目信息")
@Data
public class Question extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String questionId;

    @NotBlank(message = "题目名称不能空")
    @Schema(description = "题目名称")
    private String content;

    @NotNull(message = "题目类型不能空")
    @Schema(description = "题目类型：0：单选、1：多选、2：判断、3：填空、4：主观")
    private String type;

    @Min(message = "题目难度应在0~5之间",value = 0)
    @Max(message = "题目难度应在0~5之间",value = 5)
    @Schema(description = "题目难度")
    private String difficulty;

    @Min(message = "题目分值应在1~100分之间",value = 1)
    @Max(message = "题目分值应在1~100分之间",value = 100)
    @Schema(description = "题目分值")
    private String score;

    @Schema(description = "题库标签：计算机类、安全类、财会类")
    private Integer questionTagId;

    @Schema(description = "部门")
    private String deptId;
}
