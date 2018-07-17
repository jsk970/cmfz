package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;

import java.util.List;

public interface AdminService {

    public int appendAdmin(Admin admin);
    public Admin queryAdminByName(String name);

    public List<Role> queryRoleByName(String name);

    public List<Permission> queryPermissionByName(String name);

}
