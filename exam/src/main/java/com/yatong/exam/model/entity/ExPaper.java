package com.yatong.exam.model.entity;


import com.yatong.exam.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "ExPaper", description = "试卷基本信息")
public class ExPaper extends BaseEntity {

  private Integer paperId;
  private String title;
  private String introduce;
  private Integer deptId;
  private Integer paperType;
}
