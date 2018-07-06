package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Pic;

import java.util.List;

/**
 * @program: cmfz
 * @description: 添加轮播图图片
 * @author: Elk love madness
 * @create: 2018-07-05 20:05
 */
public interface PicService {

    public int addPic(Pic pic);

    public List<Pic> queryPicForPage(Integer start,Integer pageSize);
}
