package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.LogDAO;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-10 09:30
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDAO logDAO;

    @Override
    @Transactional
    public void appendLog(Log log) {
        try {
            logDAO.insertLog(log);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, Object> queryAllLog(Integer start,Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        List<Log> logs = logDAO.selectAllLogForPage(start, pageSize);
        int count = logDAO.count();
        map.put("rows", logs);
        map.put("total", count);
        return map;
    }
}
