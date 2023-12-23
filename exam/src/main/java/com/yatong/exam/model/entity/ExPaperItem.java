package com.yatong.exam.model.entity;


import com.yatong.exam.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "ExPaperItem", description = "试卷具体信息")
public class ExPaperItem extends BaseEntity {

  private Integer paperItemId;
  private Integer paperId;
  private Integer questionId;

}
