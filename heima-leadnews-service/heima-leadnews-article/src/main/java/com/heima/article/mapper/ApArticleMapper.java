package com.heima.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.model.common.article.dtos.ArticleHomeDto;
import com.heima.model.common.article.pojos.ApArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApArticleMapper extends BaseMapper<ApArticle> {

    /**
     * @param dto 前端传参
     * @param type  表示加载、加载最新、加载更多
     */
    List<ApArticle> getArticleList(@Param("dto")ArticleHomeDto dto, @Param("type") Short type);
}
