package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.AdminDAO;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.util.SaltUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.provider.MD5;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Override
    @Transactional
    public int appendAdmin(Admin admin) {

        admin.setState("0");
        String salt = SaltUtil.getRandomChars();
        admin.setSalt(salt);
        //String MD5Password = DigestUtils.md5Hex(admin.getPassword()+salt);
        Md5Hash md5Hash = new Md5Hash(admin.getPassword(), salt, 512);
        admin.setPassword(md5Hash.toString());
        //System.out.println("addService:"+admin);
        int i = adminDAO.insertAdmin(admin);
        return i;
    }

    @Override
    @Transactional
    public Admin queryAdminByName(String name) {
        Admin admin = adminDAO.selectByName(name);
        if (admin!=null){
            return admin;
        }else{
            return null;
        }
    }
}
