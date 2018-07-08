package com.baizhi.cmfz.controller;


import com.baizhi.cmfz.entity.Pic;
import com.baizhi.cmfz.service.PicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class PicController {

    @Autowired
    private PicService picService;

    @RequestMapping("/picUpload")
    @ResponseBody
    public boolean uploadPic(MultipartFile file,Pic pic ,HttpSession session){
        try {
            picService.addPic(pic,file,session);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping("/showPicForPage")
    @ResponseBody
    public Map<String,Object> showPicForPage(Integer page, Integer rows){
        Map<String, Object> map = picService.queryPicForPage((page - 1) * rows, rows);
        return map;
    }

    @RequestMapping("/skiptoModify")
    @ResponseBody
    public Pic skiptoModify(Integer id){
        Pic pic = picService.queryPicbyId(id);
        return pic;
    }

    @RequestMapping("/modifyPic")
    @ResponseBody
    public boolean modifyPic(Pic pic){
        System.out.println(pic);
        int i = picService.modifyPic(pic);
        if (i != 0) {
            return true;
        }else{
            return false;
        }
    }

}
