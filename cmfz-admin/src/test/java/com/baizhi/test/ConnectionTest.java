package com.baizhi.test;


import com.baizhi.cmfz.dao.AdminDAO;
import com.baizhi.cmfz.entity.Admin;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConnectionTest {
    @Test
    public void getConnection(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminDAO adminDAO = (AdminDAO) applicationContext.getBean("adminDAO");
        Admin admin = adminDAO.selectByName("123");
        System.out.println(admin);
    }
}
