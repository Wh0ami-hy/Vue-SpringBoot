package com.yatong.exam.service;

import com.yatong.exam.model.entity.ParseQuestionRules;
import com.yatong.exam.model.vo.BatchQuestion;
import com.yatong.exam.model.vo.QuestionInfoVo;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author HouYi
 * @Date 2023/12/9 16:11
 * @Description 题目服务
 * @Since version-1.0
 */
public interface QuestionService {
    List<QuestionInfoVo> parseQuestionText(String text, ParseQuestionRules rule);

    String batchAddQuestion(BatchQuestion batchQuestion) throws SQLException;
//    QuestionInfoVo questionInfo(Integer questionId);
//
//    List<QuestionInfoVo> examQuestionInfo(Integer examId);
//    List<Question> getQuestionsByTags(int userId, int courseId, Collection<Integer> tagList, Collection<QuestionTypeEnum> typeList);
}