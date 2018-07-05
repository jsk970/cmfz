package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Admin;

public interface AdminService {

    public int addAdmin(Admin admin);
    public Admin queryAdminByNameAndPassword(String name,String password);
}
