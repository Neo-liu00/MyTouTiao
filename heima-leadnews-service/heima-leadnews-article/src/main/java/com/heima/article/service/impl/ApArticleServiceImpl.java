package com.heima.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.article.mapper.ApArticleMapper;
import com.heima.article.service.IApArticleService;
import com.heima.common.constants.ArticleConstants;
import com.heima.model.common.article.dtos.ArticleHomeDto;
import com.heima.model.common.article.pojos.ApArticle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class ApArticleServiceImpl extends ServiceImpl<ApArticleMapper, ApArticle> implements IApArticleService {

    @Autowired
    private ApArticleMapper apArticleMapper;

    /**
     * 查询文章列表
     * @param articleHomeDto 前端传参
     * @param type 表示加载首页、加载更多和加载最新的类型
     */
    @Override
    public List<ApArticle> getArticleList(ArticleHomeDto articleHomeDto, Short type) {
        //参数校验
        //分页数
        Integer size = articleHomeDto.getSize();
        if(size == null || size == 0) {
            size = 10;
        }
        //一次返回不超过50条
        size = Math.min(size,50);
        //type校验
        if(!type.equals(ArticleConstants.LOAD_MORE_ARTICLE) &&
                !type.equals(ArticleConstants.LOAD_NEW_ARTICLE)) {
            //默认为加载更多
            type = ArticleConstants.LOAD_MORE_ARTICLE;
        }
        //时间校验
        if(articleHomeDto.getMinTime() == null) {
            articleHomeDto.setMinTime(new Date());
        }
        if(articleHomeDto.getMaxTime() == null) {
            articleHomeDto.setMaxTime(new Date());
        }
        //执行查询方法
        return apArticleMapper.getArticleList(articleHomeDto, type);
    }
}
