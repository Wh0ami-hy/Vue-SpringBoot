package com.yatong.exam.constant.enums;

import lombok.Getter;

/**
 * @Author HouYi
 * @Date 2023/12/9 16:41
 * @Description 题目类型
 * @Since version-1.0
 */
@Getter
public enum QuestionTypeEnum {
    SIGNAL_CHOICE(0, "单选题"),
    MULTIPLE_CHOICE(1, "多选题"),
    JUDGMENTAL(2, "判断题"),
    COMPLETION(3, "填空题"),
    SUBJECTIVE(4, "主观题");

    private final int value;
    private final String label;

    QuestionTypeEnum(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
