package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PicDAO;
import com.baizhi.cmfz.entity.Pic;
import com.baizhi.cmfz.service.PicService;
import com.baizhi.cmfz.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-05 20:07
 */
@Service
@Transactional
public class PicServiceImpl implements PicService {
    @Autowired
    private PicDAO picDAO;



    @Override
    @Transactional
    public int addPic(Pic pic, MultipartFile file, HttpSession session) {
        String fileName = UUID.randomUUID().toString().replace("-","");
        String oldName = file.getOriginalFilename();
        fileName += oldName.substring(oldName.lastIndexOf("."));
        pic.setPath(fileName);
        pic.setPublishedDate(new Date());
        FileUtil.uploadFile(file, session,fileName);
        int i = picDAO.insertPic(pic);
        return i;
    }

    @Override
    @Transactional
    public Map<String,Object> queryPicForPage(Integer start, Integer pageSize) {

        HashMap<String, Object> map = new HashMap<>();

        List<Pic> pics = picDAO.selectPicForPage(start, pageSize);
        int count = picDAO.count();
        map.put("rows", pics);
        map.put("total", count);
        return map;
    }
}
