package com.baizhi.test;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.baizhi.cmfz.dao.MenuDAO;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import com.baizhi.cmfz.util.FileUtil;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-06 14:41
 */
public class GuruImportExcel {
    @Test
    public void importExcel(){

        ImportParams params = new ImportParams();
        //设置表格标题行数(默认0)
        params.setTitleRows(0);
        //设置表头行数（默认1）
        params.setHeadRows(1);

        //long start = new Date().getTime();
        List<Guru> list = ExcelImportUtil.importExcel(new File("F:\\guru.xlsx"),Guru.class, params);
        for (Guru guru : list) {
            System.out.println(guru);
        }
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        GuruService guruServiceImpl = (GuruService) applicationContext.getBean("guruServiceImpl");
        int i = guruServiceImpl.batchAddGuru(list);
        System.out.println(i);



    }
}
