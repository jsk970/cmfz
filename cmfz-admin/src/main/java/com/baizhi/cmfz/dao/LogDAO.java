package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-10 09:15
 */
public interface LogDAO {

    public void insertLog(Log log);

    public List<Log> selectAllLogForPage(@Param("start")Integer start, @Param("pageSize")Integer pageSize);

    public int count();

}
