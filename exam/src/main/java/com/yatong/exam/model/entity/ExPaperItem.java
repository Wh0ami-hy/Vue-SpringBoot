package com.yatong.exam.model.entity;


import com.yatong.exam.model.base.BaseEntity;
import lombok.Data;

@Data
public class ExPaperItem extends BaseEntity {

  private Integer paperItemId;
  private Integer paperId;
  private Integer questionId;

}
