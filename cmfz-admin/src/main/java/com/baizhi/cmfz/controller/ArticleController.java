package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Context;
import com.baizhi.cmfz.service.ArticleService;
import com.baizhi.cmfz.util.FileUtil;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.*;

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
        //System.out.println(article);
        try {
            article.setPublishedDate(new Date());
            articleService.addArticle(article);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("/queryArticleForPage")
    @ResponseBody
    public Map<String,Object> queryAllArticleForPage(Integer page, Integer rows){
        Map<String, Object> map = articleService.queryArticleForPage((page - 1) * rows, rows);
        return map;
    }



    @RequestMapping("/contextUpload")
    @ResponseBody
    public Context upload(@RequestParam("files")MultipartFile[] files,HttpSession session){
        for(MultipartFile file : files){
            System.out.println(file.getOriginalFilename());
        }
        Context context = new Context();
        List<String> list = new ArrayList<String>();
        try {
            for (MultipartFile file : files) {
                String extension = FilenameUtils.getExtension(file.getOriginalFilename());
                String fileName = UUID.randomUUID().toString()+"."+extension;
                FileUtil.uploadFile(file, session,fileName);
                list.add("upload/"+fileName);
            }
            context.setErrno(0);
            context.setData(list);
            System.out.println(context);
            return context;
        } catch (Exception e) {
            e.printStackTrace();
            context.setErrno(1);
            return context;
        }
    }

}
