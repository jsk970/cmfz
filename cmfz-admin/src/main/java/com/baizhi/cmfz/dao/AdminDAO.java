package com.baizhi.cmfz.dao;


import com.baizhi.cmfz.entity.Admin;

public interface AdminDAO {

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    public int insertAdmin(Admin admin);
    /**
     * 通过名字查找admin
     * @param name
     * @return
     */
    public Admin selectByName(String name);



}
