package com.heima.model.common.article.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("ap_article_content")
public class ApArticleContent implements Serializable {

    @TableId(value = "id",type = IdType.ID_WORKER)
    @ApiModelProperty("表ID")
    private Long id;

    @TableField("article_id")
    @ApiModelProperty("文章ID")
    private Long articleId;

    @ApiModelProperty("文章内容")
    private String content;
}
