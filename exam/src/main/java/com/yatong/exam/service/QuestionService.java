package com.yatong.exam.service;

import com.yatong.exam.model.entity.ParseQuestionRules;
import com.yatong.exam.model.vo.BatchQuestionVo;
import com.yatong.exam.model.vo.QuestionInfoVo;

import java.util.List;

/**
 * @Author HouYi
 * @Date 2023/12/9 16:11
 * @Description 题目服务
 * @Since version-1.0
 */
public interface QuestionService {
    List<QuestionInfoVo> parseQuestionText(String text, ParseQuestionRules rule);

    String batchAddQuestion(BatchQuestionVo batchQuestion);
//    QuestionInfoVo questionInfo(Integer questionId);
//
//    List<QuestionInfoVo> examQuestionInfo(Integer examId);
//    List<Question> getQuestionsByTags(int userId, int courseId, Collection<Integer> tagList, Collection<QuestionTypeEnum> typeList);
}