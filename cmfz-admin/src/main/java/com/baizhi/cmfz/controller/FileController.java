package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.dao.PicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileController {

    @Autowired
    private PicDAO picDAO;
    @RequestMapping("/upload")
    @ResponseBody
    public boolean uploadPic(MultipartFile file,HttpSession session){
        String realPath = session.getServletContext().getRealPath("/uploadImges");

        String fileName = UUID.randomUUID().toString().replace("-","");
        String oldName = file.getOriginalFilename();
        String suffix = oldName.substring(oldName.lastIndexOf("."));

//        try {
//           file.transferTo(new File(realPath+"/"+fileName+"."+suffix));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return true;
    }

}
