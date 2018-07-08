package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-08 18:03
 */
public interface ArticleDAO {

    public int insertArticle(Article article);

    public List<Article> selectAllArticleForPage(@Param("start")Integer start, @Param("pageSize")Integer pageSize);

    public int count();
}
