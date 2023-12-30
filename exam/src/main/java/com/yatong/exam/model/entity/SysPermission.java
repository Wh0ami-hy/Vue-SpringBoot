package com.yatong.exam.model.entity;


import com.yatong.exam.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SysPermission extends BaseEntity {

  private Integer permissionId;
  private String permissionName;
  private String url;
}
