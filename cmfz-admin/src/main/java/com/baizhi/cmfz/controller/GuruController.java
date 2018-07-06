package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-06 15:43
 */
@Controller
public class GuruController {
    @Autowired
    private GuruService guruService;

    @RequestMapping("/showAllGuruForPage")
    @ResponseBody
    public Map<String,Object> showAllGuruForPage(Integer page, Integer rows){
        Map<String, Object> map = guruService.quertGuruForPage((page - 1) * rows, rows);
        return map;
    }

    @RequestMapping("/showByKeywords")
    @ResponseBody
    public Map<String,Object> showByKeywords(Integer page, Integer rows,String keywords){
        System.out.println("123213123123123");
        Map<String, Object> map = guruService.queryGuruBykeywords((page - 1) * rows, rows,keywords);
        return map;
    }

}
