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

@Controller
public class PicController {

    @Autowired
    private PicService picService;
    @RequestMapping("/upload")
    @ResponseBody
    public boolean uploadPic(MultipartFile file,String description ,HttpSession session){

        try {
            String fileName = FileUtil.uploadFile(file, "/uploadImges", session);

            Pic pic = new Pic();
            pic.setPath("uploadImages/"+fileName);
            pic.setPublishedDate(new Date());
            pic.setDescription(description);
            pic.setState("1");
            picService.addPic(pic);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @RequestMapping("/showPicForPage")
    @ResponseBody
    public List<Pic> showPicForPage(Integer page,Integer rows){
        List<Pic> pics = picService.queryPicForPage((page - 1) * rows, rows);
        return pics;
    }
}