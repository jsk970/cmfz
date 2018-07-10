package com.baizhi.aspectj;

import com.baizhi.cmfz.entity.Guru;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-09 19:00
 */
public class AspectjTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        GuruService guruService = (GuruService) applicationContext.getBean("guruService");
        Guru guru = new Guru();
        guru.setPicPath("123");
        guru.setId(123);
        guru.setName("123");
        guru.setSummar("123");
        Guru guru1 = guruService.addGuru(guru);
        System.out.println(guru1);
    }


    @Test
    public void test2(){
        try {
            System.out.println("123");
            throw new RuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("456");
    }

}
