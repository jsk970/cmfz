package com.baizhi.test;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.util.SaltUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminServiceTest {
    @Test
    public void adminTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminService adminServiceImpl = (AdminService) applicationContext.getBean("adminServiceImpl");
        Admin admin = new Admin();
        String password="110";
        admin.setState("0");
        admin.setName("jsk");
        admin.setPassword(password);

        System.out.println(admin);
        adminServiceImpl.appendAdmin(admin);


    }
}
