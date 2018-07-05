package com.baizhi.test;

import com.baizhi.cmfz.dao.MenuDAO;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MenuServiceTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuService menuServiceImpl = (MenuService) applicationContext.getBean("menuServiceImpl");
        List<Menu> menus = menuServiceImpl.queryAllMenu();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }
    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuDAO menuDAO = (MenuDAO) applicationContext.getBean("menuDAO");
        List<Menu> menus = menuDAO.selectAllMenu();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }
}
