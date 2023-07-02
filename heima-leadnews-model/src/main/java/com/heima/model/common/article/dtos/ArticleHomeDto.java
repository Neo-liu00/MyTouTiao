package com.heima.model.common.article.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ArticleHomeDto {

    /**
     * 如果是当前频道的首页，
     * 前端传递默认参数：
     * maxTime：0（毫秒）
     * minTime：20000000（毫秒）
     */

    @ApiModelProperty("最大时间")
    Date maxTime;

    @ApiModelProperty("最小时间")
    Date minTime;

    @ApiModelProperty("分页显示条数")
    Integer size;

    @ApiModelProperty("文章频道")
    String tag;

}
