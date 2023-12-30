package com.yatong.exam.model.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

import java.util.List;

/**
 * @Author HouYi
 * @Date 2023/12/10 14:11
 * @Description 批量导入题目
 * @Since version-1.0
 */

@Data
public class BatchQuestionVo {

    @NotEmpty(message = "题目类型标签不能为空")
    private Integer questionTagId;

    @NotEmpty(message = "题目列表不能为空")
    private List<QuestionInfoVo> questionInfos;

}
