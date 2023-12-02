package com.yatong.exam.service;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public interface IQuestionService {

    /**
     * 添加题目
     *
     * @param questionInfo 问题信息
     * @return boolean
     */
    String addQuestion(QuestionInfoVo questionInfo);

    /**
     * 问题信息
     *
     * @param questionId 问题id
     * @return {@link QuestionInfoVo}
     */
    QuestionInfoVo questionInfo(Integer questionId);

    List<QuestionInfoVo> examQuestionInfo(Integer examId);
    List<Question> getQuestionsByTags(int userId, int courseId, Collection<Integer> tagList, Collection<QuestionTypeEnum> typeList);
}