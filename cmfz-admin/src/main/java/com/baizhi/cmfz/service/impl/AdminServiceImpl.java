package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.AdminDAO;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.util.SaltUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Override
    @Transactional
    public int addAdmin(Admin admin) {

        admin.setState("0");
        String salt = SaltUtil.getRandomChars();
        admin.setSalt(salt);
        String MD5Password = DigestUtils.md5Hex(admin.getPassword()+salt);
        admin.setPassword(MD5Password);

        System.out.println("addService:"+admin);
        int i = adminDAO.insertAdmin(admin);
        return i;
    }

    @Override
    @Transactional
    public Admin queryAdminByNameAndPassword(String name,String password) {
        Admin admin = adminDAO.selectByName(name);
        System.out.println("loginService:"+admin);
        if (admin!=null){
            String salt = admin.getSalt();
            String MD5Password = DigestUtils.md5Hex(password+salt);
            if (admin.getPassword().equals(MD5Password)){
                return admin;
            }else{
                throw new RuntimeException("error password!");
            }
        }else{
            throw new RuntimeException("用户不存在!");
        }
    }
}
