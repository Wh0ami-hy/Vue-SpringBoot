package com.yatong.exam.model.base;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BasePageQuery {

    private int pageNum = 1;
    private int pageSize = 10;
}