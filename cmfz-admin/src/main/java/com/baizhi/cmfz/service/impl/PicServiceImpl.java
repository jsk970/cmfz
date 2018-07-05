package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PicDAO;
import com.baizhi.cmfz.entity.Pic;
import com.baizhi.cmfz.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-05 20:07
 */
@Service
public class PicServiceImpl implements PicService {
    @Autowired
    private PicDAO picDAO;

    @Override
    public int addPic(Pic pic) {
        int i = picDAO.insertPic(pic);
        return i;
    }
}
