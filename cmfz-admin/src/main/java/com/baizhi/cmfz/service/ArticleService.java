package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;

import java.util.List;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-08 18:12
 */
public interface ArticleService {

    public int addArticle(Article article);


    public List<Article> queryArticle();
}
