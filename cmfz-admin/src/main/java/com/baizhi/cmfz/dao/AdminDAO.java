package com.baizhi.cmfz.dao;


import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;

import java.util.List;

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

    public List<Role> selectRoleByName(String name);

    public List<Permission> selectPermissionByName(String name);


}
