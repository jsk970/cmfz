package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.People;

import java.util.List;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-09 15:08
 */
public interface PeopleService {

    public List<People> queryAll();

    public List<People> queryMan();

    public List<People> queryWomale();


}
