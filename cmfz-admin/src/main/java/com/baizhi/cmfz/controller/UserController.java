package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.People;
import com.baizhi.cmfz.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-09 14:37
 */
@Controller
public class UserController {
    @Autowired
    private PeopleService peopleService;


    @RequestMapping("/queryAll")
    @ResponseBody
    public List<People> queryAll(){
        List<People> people = peopleService.queryAll();
        
        return  people;
    }
    @RequestMapping("/queryMan")
    @ResponseBody
    public List<People> queryMan(){
        List<People> people = peopleService.queryMan();
        for (People person : people) {
            System.out.println(person);
        }
        return  people;
    }
    @RequestMapping("/queryWomale")
    @ResponseBody
    public List<People> queryWomale(){
        List<People> people = peopleService.queryWomale();
        for (People person : people) {
            System.out.println(person);
        }
        return  people;
    }

}
