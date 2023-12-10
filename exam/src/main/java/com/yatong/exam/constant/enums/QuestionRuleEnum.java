package com.yatong.exam.constant.enums;

import com.yatong.exam.model.entity.ParseQuestionRules;
import lombok.Getter;

/**
 * @Author HouYi
 * @Date 2023/12/9 15:33
 * @Description 题目解析规则
 * @Since version-1.0
 */
public enum QuestionRuleEnum {
    /*
    序号、（数字+分）题目内容
    字母、选项内容（可选）：
    答案： 答案内容（多个答案用中文分号（；）分割）
     */
    CHAOXING("学习通",new ParseQuestionRules("\\n\\d{1,3}\\s*[\\.、：:]","（\\d+分）.*","答案：\\s*([\\s\\S]*)","；","\\n\\s*[A-Z]\\s*[、.]\\s*"));
    @Getter
    private String name;
    @Getter
    private ParseQuestionRules rule;
    QuestionRuleEnum(String name, ParseQuestionRules rule){
        this.name=name;
        this.rule=rule;
    }
}
