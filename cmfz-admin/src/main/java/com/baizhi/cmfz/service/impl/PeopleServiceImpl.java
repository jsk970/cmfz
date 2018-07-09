package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PeopleDAO;
import com.baizhi.cmfz.entity.People;
import com.baizhi.cmfz.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-09 15:10
 */
@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleDAO peopleDAO;

    @Override
    public List<People> queryAll() {
        List<People> people = peopleDAO.selectAll();
        return people;

    }

    @Override
    public List<People> queryMan() {
        List<People> people = peopleDAO.selectMan();
        return people;
    }

    @Override
    public List<People> queryWomale() {
        List<People> people = peopleDAO.selectWomale();
        return people;
    }
}
