package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-10 09:49
 */
@Controller
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("/queryAllLog")
    @ResponseBody
    public Map<String,Object> queryAllLog(Integer page, Integer rows){
        Map<String, Object> map = logService.queryAllLog((page - 1) * rows, rows);
        return map;
    }
}
