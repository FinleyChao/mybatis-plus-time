package com.foolish.swaggerdemo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author cxf
 * @since 2020-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="FilmVO对象", description="")
@Builder
@ToString
public class FilmVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Tolerate
    public FilmVO(){}

    @TableId(value = "电影id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "电影名称")
    private String filmName;

    @ApiModelProperty(value = "电影评分")
    private Short score;

    @ApiModelProperty(value = "电影发布时间")
    private LocalDateTime publishTime;

    @ApiModelProperty(value = "电影创建人")
    private Long creatorId;


}
