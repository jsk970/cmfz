package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Log;

import java.util.Map;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-10 09:29
 */
public interface LogService {

    public void appendLog(Log log);

    public Map<String,Object> queryAllLog(Integer start ,Integer pageSize);
}
