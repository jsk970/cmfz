package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDAO;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void addArticle(Article article) {
        try {
            articleDAO.insertArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    @Transactional
    public Map<String,Object> queryArticleForPage(Integer start, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        List<Article> articles = articleDAO.selectAllArticleForPage(start, pageSize);
        int count = articleDAO.count();
        map.put("rows", articles);
        map.put("total", count);
        return map;
    }

}
