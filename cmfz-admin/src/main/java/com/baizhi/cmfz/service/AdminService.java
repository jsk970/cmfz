package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Admin;

public interface AdminService {

    public int appendAdmin(Admin admin);
    public Admin queryAdminByName(String name);
}
