package com.baizhi.cmfz.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-06 08:24
 */
public class FileUtil {


    public static String uploadFile(MultipartFile file,String directory,HttpSession session){
        try {

            String realPath = session.getServletContext().getRealPath("/"+directory);
            String fileName = UUID.randomUUID().toString().replace("-","");
            String oldName = file.getOriginalFilename();
            String suffix = oldName.substring(oldName.lastIndexOf("."));
            //System.out.println(fileName);
            //System.out.println(realPath);
            File pic = new File(realPath+"/"+fileName+suffix);
            file.transferTo(pic);
            return fileName+suffix;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
