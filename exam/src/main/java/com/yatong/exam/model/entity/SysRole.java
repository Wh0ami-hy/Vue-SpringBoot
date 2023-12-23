package com.yatong.exam.model.entity;


import com.yatong.exam.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class SysRole extends BaseEntity {

  private Integer roleId;
  private String roleName;
  private String roleKey;
  private String dataScope;
  private Integer menuCheckStrictly;
  private Integer deptCheckStrictly;
}
