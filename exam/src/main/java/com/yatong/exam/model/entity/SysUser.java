package com.yatong.exam.model.entity;


import com.yatong.exam.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class SysUser extends BaseEntity {

  private Integer userId;
  private Integer deptId;
  private String userName;
  private String userType;
  private String email;
  private String phonenumber;
  private String sex;
  private String password;
}
