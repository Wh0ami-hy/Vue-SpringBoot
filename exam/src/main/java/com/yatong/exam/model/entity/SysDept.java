package com.yatong.exam.model.entity;


import com.yatong.exam.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class SysDept extends BaseEntity {

  private Integer deptId;
  private Integer parentId;
  private String ancestors;
  private String deptName;
  private Integer orderNum;
  private String leader;
  private String phone;
  private String email;
}
