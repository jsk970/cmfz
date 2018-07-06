package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Pic;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description: 添加轮播图图片
 * @author: Elk love madness
 * @create: 2018-07-05 20:05
 */
public interface PicService {

    public int addPic(Pic pic, MultipartFile file,HttpSession session);

    public Map<String,Object> queryPicForPage(Integer start, Integer pageSize);

    public int removePicById(Integer id);

    public int modifyPic(Pic pic);
}
