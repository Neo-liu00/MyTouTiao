package com.heima.article.controller.v1;

import com.heima.article.service.IApArticleService;
import com.heima.common.constants.ArticleConstants;
import com.heima.model.common.article.dtos.ArticleHomeDto;
import com.heima.model.common.dtos.ResponseResult;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleHomeController {

    @Autowired
    private IApArticleService apArticleService;
    @ApiModelProperty("加载首页")
    @PostMapping("/load")
    public ResponseResult load(@RequestBody ArticleHomeDto articleHomeDto) {
        return ResponseResult.okResult(apArticleService.getArticleList(articleHomeDto, ArticleConstants.LOAD_MORE_ARTICLE));
    }

    @ApiModelProperty("加载最新")
    @PostMapping("/load_new")
    public ResponseResult loadNew(@RequestBody ArticleHomeDto articleHomeDto) {
        return ResponseResult.okResult(apArticleService.getArticleList(articleHomeDto,ArticleConstants.LOAD_NEW_ARTICLE));
    }

    @ApiModelProperty("加载更多")
    @PostMapping("/load_more")
    public ResponseResult loadMore(@RequestBody ArticleHomeDto articleHomeDto) {
        return ResponseResult.okResult(apArticleService.getArticleList(articleHomeDto,ArticleConstants.LOAD_MORE_ARTICLE));
    }
}
