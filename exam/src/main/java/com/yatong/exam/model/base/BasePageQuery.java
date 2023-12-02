package com.yatong.exam.model.base;


import lombok.Data;

@Data
public class BasePageQuery {

    @Schema( name= "页码", example = "1")
    private int pageNum = 1;

    @Schema(name = "每页记录数", example = "10")
    private int pageSize = 10;
}