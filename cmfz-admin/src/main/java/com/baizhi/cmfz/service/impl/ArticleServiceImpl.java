package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDAO;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-08 18:13
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDAO articleDAO;

    @Override
    public int addArticle(Article article) {
        int i = articleDAO.insertArticle(article);
        return i;
    }

    @Override
    public List<Article> queryArticle() {
        return null;
    }
}
