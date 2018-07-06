package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Guru;

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

}
