package com.yatong.exam.utils;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test {
    public static void main(String[] args) {

        // 获取当前时间
        LocalDateTime localDateTime = LocalDateTime.now();

        // 初始化一个时区
        ZoneId timeZoneSH = ZoneId.of("Asia/Shanghai");
        ZoneId timeZoneNY = ZoneId.of("America/New_York");

        // 格式化日期时间
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = localDateTime.format(dateTimeFormatter);

        // 加上时区信息
        ZonedDateTime date = ZonedDateTime.of(LocalDateTime.parse(formattedDateTime,dateTimeFormatter), timeZoneNY);

        System.out.println(date);
    }
}
