package com.yatong.exam.model.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Schema(name = "BaseEntity", description = "公共实体")
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "创建人")
    private String createBy;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "修改时间")
    private LocalDateTime updateTime;

    @Schema(description = "修改人")
    private String updateBy;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "删除标志")
    private String delFlag;
}
