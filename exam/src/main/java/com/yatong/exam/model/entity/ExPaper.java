package com.yatong.exam.model.entity;


import com.yatong.exam.model.base.BaseEntity;
import lombok.Data;

@Data
public class ExPaper extends BaseEntity {

  private Integer paperId;
  private String title;
  private String introduce;
  private Integer deptId;
  private Integer paperType;
}
