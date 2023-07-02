package com.heima.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.article.dtos.ArticleHomeDto;
import com.heima.model.common.article.pojos.ApArticle;
import com.heima.model.common.dtos.ResponseResult;

import java.util.List;

public interface IApArticleService extends IService<ApArticle> {
    List<ApArticle> getArticleList(ArticleHomeDto articleHomeDto, Short type);
}
