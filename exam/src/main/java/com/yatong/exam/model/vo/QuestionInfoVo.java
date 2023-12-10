package com.yatong.exam.model.vo;

import com.yatong.exam.model.entity.Question;
import com.yatong.exam.model.entity.QuestionItem;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @Author HouYi
 * @Date 2023/12/10 19:47
 * @Description 题目信息 + 题目内容
 * @Since version-1.0
 */
@Data
@Schema(name = "QuestionInfoVo", description = "题目具体信息")
public class QuestionInfoVo extends Question {
    private List<QuestionItem> options;
}