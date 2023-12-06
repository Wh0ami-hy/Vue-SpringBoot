package com.baymax.exam.center.utils;

import com.baymax.exam.center.enums.QuestionTypeEnum;
import com.baymax.exam.center.model.ParseQuestionRules;
import com.baymax.exam.center.model.QuestionItem;
import com.baymax.exam.center.vo.QuestionInfoVo;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 方式一：正则表达
 *      缺点：不能正确提取内容，部分题目提取特征不明显
 * 方式二：逐行读取+正则表达
 *
 * @author ：Baymax
 * @date ：Created in 2022/11/10 16:52
 * @description：解析题目文本
 * @modified By：
 * @version:
 */
@Slf4j
public class ParseQuestionText {
    static final String[] letterList = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static List<QuestionInfoVo> parse(String text, ParseQuestionRules rule){
        // 分割规则（把各个题目分割开）
        String divisionRule=rule.getDivisionRule();
        // 题干规则
        String questionRule=rule.getQuestionRule();
        // 答案规则
        String answerRule=rule.getAnswerRule();
        // 选项规则
        String optionRule=rule.getOptionRule();
        // 获取题目分数的规则
        String scoreRule = "（\\d+分）";




        // 把文本分割成单独的题目
        String[] questionInfoStr = text.split(divisionRule);
        // 传给前端的题目结构
        QuestionInfoVo questionInfo = null;
        List<QuestionInfoVo> list = new ArrayList<>();
        QuestionTypeEnum type = null;
        // 存放题目分数，因为在循环体中是公用的所以提出来
        StringBuilder scoreBuilder = new StringBuilder();


        // 循环遍历各个题目，提取出相关数据
        for (String str : questionInfoStr) {
            if(str.isEmpty()){
               continue;
            }

            questionInfo=new QuestionInfoVo();

            // 提取答案
            Pattern answerPattern= Pattern.compile(answerRule);
            Matcher answerMatcher = answerPattern.matcher(str);
            List<String>answerList=new ArrayList<>();
            if(answerMatcher.find()){
                answerList=Arrays.stream(answerMatcher.group(1).split(rule.getAnswerSplit())).collect(Collectors.toList());
            }
            log.info("答案=>"+answerList);

            // 去掉答案
            str=str.replaceAll(answerRule,"");

            // 提取选项
            List<String> optionList=Arrays.stream(str.split(optionRule)).map(String::trim).collect(Collectors.toList());
            optionList.remove(0);
            log.info("选项=>"+optionList);

            // 提取题干
            Pattern questionPattern = Pattern.compile(questionRule, Pattern.MULTILINE);
            Matcher questionMatcher = questionPattern.matcher(str);
            if (questionMatcher.find()){
                questionInfo.setContent(questionMatcher.group(0));
            }
            log.info("题干=>"+questionMatcher.group(0));

            // 提取题目分数
            scoreBuilder.delete(0,scoreBuilder.length());
            Pattern scorePattern = Pattern.compile(scoreRule, Pattern.MULTILINE);
            Matcher scoreMatcher = scorePattern.matcher(questionInfo.getContent());
            if (scoreMatcher.find()) {
                String matchedContent = scoreMatcher.group(0);
                for (char c : matchedContent.toCharArray()) {
                    if (Character.isDigit(c)) {
                        scoreBuilder.append(c);
                    }
                }
            }
            Float score = Float.parseFloat(scoreBuilder.toString());
            log.info("题目分数=>"+score);

            if(questionInfo.getContent().isBlank()){
                continue;
            }

            // 确定题型
            if(optionList.isEmpty()){ // 选项是空的
                if(answerList.size()==1){
                    type=QuestionTypeEnum.SUBJECTIVE; // 答案只有一个是主观题
                }else{
                    type=QuestionTypeEnum.COMPLETION; // 答案大于一个是填空题
                }
            }else{      // 选项并不为空
                if(answerList.size()==1){  // 答案只有一个
                    if(optionList.size()==2){ // 选项列表有两个是判断题
                        type=QuestionTypeEnum.JUDGMENTAL;
                    }else{
                        type=QuestionTypeEnum.SIGNAL_CHOICE;
                    }
                }else{  // 答案不止一个是多选题
                    type=QuestionTypeEnum.MULTIPLE_CHOICE;
                }
            }
            questionInfo.setType(type);

            // 设置题目选项
            questionInfo.setOptions(getItem(type,answerList,optionList));

            // 将解析完成的题目添加进题目列表
            list.add(questionInfo);
        }
        return list;
    }
    private static List<QuestionItem> getItem(QuestionTypeEnum type,List<String> answerList,List<String> optionList){
        List<QuestionItem> list=null;
        // 主观、填空
        if(type==QuestionTypeEnum.SUBJECTIVE||type==QuestionTypeEnum.COMPLETION){
            list=answerList.stream().filter(i->!i.isBlank()).map(i->{
                QuestionItem item=new QuestionItem();
                item.setAnswer(i);
                return item;
            }).collect(Collectors.toList());
        //单选、多选
        }else if(type==QuestionTypeEnum.SIGNAL_CHOICE||type== QuestionTypeEnum.MULTIPLE_CHOICE){
            List<String> temAnswerList=answerList.stream().map(e -> {
                return e.replaceAll("\\r|\\n|\\s", "").toUpperCase();
            }).collect(Collectors.toList());
            //获取字母的下标
            list=IntStream.rangeClosed(0,optionList.size()-1).filter(i->!optionList.get(i).isBlank()).mapToObj(i->{
                QuestionItem item=new QuestionItem();
                item.setContent(optionList.get(i));
                //确定选项答案
                boolean contains = temAnswerList.contains(letterList[i]);
                if(contains){
                    item.setAnswer("1");
                }
                return item;
            }).collect(Collectors.toList());
        }else if(type==QuestionTypeEnum.JUDGMENTAL){
            List<String> judgeAnswerList=answerList.stream().map(e -> {
                return e.replaceAll("\\r|\\n|\\s", "").toUpperCase();
            }).collect(Collectors.toList());
            //获取字母的下标
            list=IntStream.rangeClosed(0,optionList.size()-1).filter(i->!optionList.get(i).isBlank()).mapToObj(i->{
                QuestionItem item=new QuestionItem();
                item.setContent(optionList.get(i));
                //确定选项答案
                boolean contains = judgeAnswerList.contains(letterList[i]);
                if(contains){
                    item.setAnswer("1");
                }
                return item;
            }).collect(Collectors.toList());
        }
        return list;
    }
}

