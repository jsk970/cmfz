package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: cmfz
 * @description: 上师管理
 * @author: Elk love madness
 * @create: 2018-07-06 15:18
 */
public interface GuruDAO {
    /**
     *批量添加上师
     */
    public int batchInsert(List<Guru> list);

    /**
     *
     * @param start
     * @param pageSize
     * @return
     */
    public List<Guru> selectAllGuruForPage(@Param("start")Integer start, @Param("pageSize")Integer pageSize);

    /**
     *
     * @return
     */
    public int count();
}
