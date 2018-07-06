package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.dao.PicDAO;
import com.baizhi.cmfz.entity.Pic;
import com.baizhi.cmfz.service.PicService;
import com.baizhi.cmfz.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class PicController {

    @Autowired
    private PicService picService;
    @RequestMapping("/upload")
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
}
