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
 * @create: 2018-07-08 10:13
 */
public class PicServiceTest {

    @Test
    public void UpdatePic(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        PicService picServiceImpl = (PicService) applicationContext.getBean("picServiceImpl");
        Pic pic = new Pic();
        pic.setId(7);
        pic.setState("1");
        pic.setDescription("11111111");
        int i = picServiceImpl.modifyPic(pic);
        System.out.println(i);

    }
}
