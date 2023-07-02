package com.heima.model.common.article.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("ap_article_config")
public class ApArticleConfig implements Serializable {

    @TableId(value = "id",type = IdType.ID_WORKER)
    @ApiModelProperty("表ID")
    private Long id;

    @TableField("article_id")
    @ApiModelProperty("文章ID")
    private Long articleId;

    @TableField("is_comment")
    @ApiModelProperty("是否可以评论 0-不可评论 1-可评论")
    private Boolean isComment;

    @TableField("is_forward")
    @ApiModelProperty("0-不可转发 1-可以转发")
    private Boolean isForward;

    @TableField("is_down")
    @ApiModelProperty("是否下架 0-没有下架 1-下架")
    private Boolean isDown;

    @TableField("is_delete")
    @ApiModelProperty("是否已删除 0-没有删除 1-删除")
    private Boolean isDelete;
}
