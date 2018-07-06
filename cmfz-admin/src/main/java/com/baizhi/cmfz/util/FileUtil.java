package com.baizhi.cmfz.util;

import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;


/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-06 08:24
 */
public class FileUtil {


    public static boolean uploadFile(MultipartFile file,HttpSession session,String fileName){
        try {

            String realPath = session.getServletContext().getRealPath("");
            int indexOf = realPath.lastIndexOf("\\");
            String prefixPath = realPath.substring(0, indexOf);
            int indexOf1 = prefixPath.lastIndexOf("\\");
            String path = prefixPath.substring(0, indexOf1);

            File pic = new File(path+"/upload/"+fileName);
            file.transferTo(pic);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
