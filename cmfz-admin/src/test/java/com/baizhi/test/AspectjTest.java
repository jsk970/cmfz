package com.baizhi.test;

import com.baizhi.cmfz.entity.Pic;
import com.baizhi.cmfz.service.PicService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-09 20:20
 */
public class AspectjTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        PicService picService = (PicService) applicationContext.getBean("picServiceImpl");
        Pic pic = new Pic();
        pic.setId(7);
        pic.setState("00");
        picService.modifyPic(pic);
        //System.out.println(i);
    }



}
