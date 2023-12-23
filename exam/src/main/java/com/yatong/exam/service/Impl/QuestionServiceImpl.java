package com.yatong.exam.service.Impl;

import com.yatong.exam.mapper.QuestionItemMapper;
import com.yatong.exam.mapper.QuestionMapper;
import com.yatong.exam.model.entity.ParseQuestionRules;
import com.yatong.exam.model.entity.ExQuestionItem;
import com.yatong.exam.model.vo.BatchQuestionVo;
import com.yatong.exam.model.vo.QuestionInfoVo;
import com.yatong.exam.service.QuestionService;
import com.yatong.exam.constant.enums.QuestionTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    QuestionItemMapper questionItemMapper;

    private static final String[] letterList = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    private static List<ExQuestionItem> getItem(QuestionTypeEnum type, List<String> answerList, List<String> optionList){
        List<ExQuestionItem> list=null;
        // 主观、填空
        if(type==QuestionTypeEnum.SUBJECTIVE||type==QuestionTypeEnum.COMPLETION){
            list=answerList.stream().filter(i->!i.isEmpty()).map(i->{
                ExQuestionItem item=new ExQuestionItem();
                item.setAnswer(i);
                return item;
            }).collect(Collectors.toList());
            //单选、多选
        }else if(type==QuestionTypeEnum.SIGNAL_CHOICE||type== QuestionTypeEnum.MULTIPLE_CHOICE){
            List<String> temAnswerList=answerList.stream().map(e -> {
                return e.replaceAll("\\r|\\n|\\s", "").toUpperCase();
            }).collect(Collectors.toList());
            //获取字母的下标
            list=IntStream.rangeClosed(0,optionList.size()-1).filter(i->!optionList.get(i).isEmpty()).mapToObj(i->{
                ExQuestionItem item=new ExQuestionItem();
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
            list=IntStream.rangeClosed(0,optionList.size()-1).filter(i->!optionList.get(i).isEmpty()).mapToObj(i->{
                ExQuestionItem item=new ExQuestionItem();
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

    @Override
    public List<QuestionInfoVo> parseQuestionText(String text, ParseQuestionRules rule) {

        // 分割规则（把各个题目分割开）
        String divisionRule=rule.getDivisionRule();
        // 题干规则
        String questionRule=rule.getQuestionRule();
        // 答案规则
        String answerRule=rule.getAnswerRule();
        // 选项规则
        String optionRule=rule.getOptionRule();
        // 获取题目分数的规则
        String scoreRule =rule.getScoreRule();

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
                answerList= Arrays.stream(answerMatcher.group(1).split(rule.getAnswerSplit())).collect(Collectors.toList());
            }
            log.info("答案=>"+answerList);

            // 去掉答案
            str=str.replaceAll(answerRule,"");

            // 提取选项
            List<String> optionList=Arrays.stream(str.split(optionRule)).map(String::trim).collect(Collectors.toList());
            optionList.remove(0);
            log.info("选项=>"+optionList);

            // 提取题目分数
            scoreBuilder.delete(0,scoreBuilder.length());
            Pattern scorePattern = Pattern.compile(scoreRule);
            Matcher scoreMatcher = scorePattern.matcher(str);
            if (scoreMatcher.find()) {
                String matchedContent = scoreMatcher.group(1);
                for (char c : matchedContent.toCharArray()) {
                    if (Character.isDigit(c)) {
                        scoreBuilder.append(c);
                    }
                }
            }
            Float score = Float.parseFloat(scoreBuilder.toString());
            questionInfo.setScore(score);
            log.info("题目分数=>"+score);


            // 提取题干
            Pattern questionPattern = Pattern.compile(questionRule);
            Matcher questionMatcher = questionPattern.matcher(str);
            if (questionMatcher.find()){
                questionInfo.setContent(questionMatcher.group(1));
            }
            log.info("题干=>"+questionInfo.getContent());

            if(questionInfo.getContent().isEmpty()){
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
            // 这里的type返回了 0、1、2、3、4 ，前端需要修改
            questionInfo.setType(type.getValue());

            // 设置题目选项
            questionInfo.setOptions(getItem(type,answerList,optionList));

            // 将解析完成的题目添加进题目列表
            list.add(questionInfo);
        }
        return list;
    }

    @Override
    public String batchAddQuestion(BatchQuestionVo batchQuestionVo) {
        List<QuestionInfoVo> questionInfoVoList = new ArrayList<>();
        Integer questionTagId = batchQuestionVo.getQuestionTagId();
        questionInfoVoList = batchQuestionVo.getQuestionInfos();

        StopWatch stopWatch = new StopWatch();
        // 开始时间
        stopWatch.start();

        for (QuestionInfoVo vo : questionInfoVoList) {
            vo.setQuestionTagId(questionTagId);
            questionMapper.insertQuestion(vo);
            for (ExQuestionItem voItem : vo.getOptions()) {
                voItem.setQuestionId(vo.getQuestionId());
                questionItemMapper.insertItem(voItem);
            }
        }

        stopWatch.stop();
        // 统计执行时间（毫秒）
        System.out.printf("执行时长：%d 毫秒.%n", stopWatch.getTotalTimeMillis());

        return null;
    }
}
