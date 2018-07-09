package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.People;

import java.util.List;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-09 15:00
 */
public interface PeopleDAO {

    public List<People> selectAll();

    public List<People> selectMan();

    public List<People> selectWomale();
}
