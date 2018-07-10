package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-08 18:12
 */
public interface ArticleService {

    public void addArticle(Article article);


    public Map<String,Object> queryArticleForPage(@Param("start")Integer start, @Param("pageSize")Integer pageSize);


}
