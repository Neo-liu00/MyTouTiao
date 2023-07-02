package com.heima.model.common.article.pojos;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 文章信息表，存储已发布的文章
 */

@Data
@TableName("ap_article")
public class ApArticle implements Serializable {

    @ApiModelProperty("文章ID")
    @TableId(value = "id",type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty("文章标题")
    private String title;


    @TableField("author_id")
    @ApiModelProperty("作者ID")
    private Long authorId;

    @TableField("author_name")
    @ApiModelProperty("作者名称")
    private String authorName;

    @TableField("channel_id")
    @ApiModelProperty("频道ID")
    private Integer channelId;

    @TableField("channel_name")
    @ApiModelProperty("频道名称")
    private String channelName;

    @ApiModelProperty("文章布局 0-无图文章 1-单图文章 2-多图文章")
    private Short layout;

    @ApiModelProperty("文章标记 0-普通文章 1-热点文章 2-置顶文章 3-精品文章 4-大V文章")
    private Byte flag;

    @ApiModelProperty("文章封面插图")
    private String images;

    @ApiModelProperty("标签")
    private String labels;

    @ApiModelProperty("点赞数")
    private Integer likes;

    @ApiModelProperty("收藏数")
    private Integer collection;

    @ApiModelProperty("评论数")
    private Integer comment;

    @ApiModelProperty("阅读数")
    private Integer views;

    @TableField("province_id")
    @ApiModelProperty("省")
    private Integer provinceId;

    @TableField("city_id")
    @ApiModelProperty("市")
    private Integer cityId;

    @TableField("county_id")
    @ApiModelProperty("县区")
    private Integer countyId;

    @TableField("created_time")
    @ApiModelProperty("创建时间")
    private Date createdTime;

    @TableField("publish_time")
    @ApiModelProperty("发布时间")
    private Date publishTime;

    @TableField("sync_status")
    @ApiModelProperty("同步状态")
    private Boolean syncStatus;

    @ApiModelProperty("来源")
    private Boolean origin;


    @TableField("static_url")
    @ApiModelProperty("静态页面地址")
    private String staticUrl;
}
