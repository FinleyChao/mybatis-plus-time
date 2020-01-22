package com.foolish.swaggerdemo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 计划任务表：根据检查频次自动生成
 * </p>
 *
 * @author cxf
 * @since 2020-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EhsPlan对象", description="计划任务表：根据检查频次自动生成")
public class EhsPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "计划开始日期")
    private LocalDate planStartDate;

    @ApiModelProperty(value = "计划结束日期")
    private LocalDate planEndDate;

    @ApiModelProperty(value = "类型，周、月、年")
    private Integer type;

    @ApiModelProperty(value = "检查次数")
    private Integer checkNumber;

    @ApiModelProperty(value = "总次数")
    private Integer totalNumber;

    @ApiModelProperty(value = "审核人")
    private Long userId;

    private Integer status;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private Long companyModelsId;


}
