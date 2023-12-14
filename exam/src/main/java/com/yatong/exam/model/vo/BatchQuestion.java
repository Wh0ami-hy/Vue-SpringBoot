package com.yatong.exam.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import java.util.List;

/**
 * @Author HouYi
 * @Date 2023/12/10 14:11
 * @Description 批量创建题目
 * @Since version-1.0
 */

@Data
public class BatchQuestion {

    @NotBlank(message = "题目类型标签不能为空")
    @Schema(description = "题目类型标签")
    private Integer questionTagId;

    @NotEmpty(message = "题目列表不能为空")
    @Schema(description = "题目列表")
    private List<QuestionInfoVo> questionInfos;

}
