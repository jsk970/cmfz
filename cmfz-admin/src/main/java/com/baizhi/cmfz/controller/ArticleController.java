package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Context;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-08 18:14
 */
@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/addArticle")
    @ResponseBody
    public boolean addArticle(Article article){

        return false;
    }

    @RequestMapping("/contextUpload")
    @ResponseBody
    public Context upload(@RequestParam("files")MultipartFile files){

        Context context = new Context();

        return context;
    }

}
