package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Pic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: cmfz
 * @description: 轮播图片的接口类
 * @author: Elk love madness
 * @create: 2018-07-05 19:44
 */
public interface PicDAO {
    /**
     *添加轮播图
     * @param pic
     * @return
     */
    public int insertPic(Pic pic);

    /**
     *分页查询轮播图
     * @return
     */
    public List<Pic> selectPicForPage(@Param("start")Integer start,@Param("pageSize")Integer pageSize);


}
