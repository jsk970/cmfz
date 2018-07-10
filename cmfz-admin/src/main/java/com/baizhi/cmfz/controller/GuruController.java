package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.Pic;
import com.baizhi.cmfz.service.GuruService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-06 15:43
 */
@Controller
public class GuruController {
    @Autowired
    private GuruService guruService;


    @RequestMapping("/queryAllGuru")
    @ResponseBody
    public List<Guru> queryAllGuru(){
        List<Guru> gurus = guruService.queryAllGuru();
        return gurus;
    }


    @RequestMapping("/GuruAdd")
    @ResponseBody
    public boolean addGuru(MultipartFile file, Guru guru , HttpSession session){
        try {
            guruService.addGuru(guru,file,session);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping("/GuruMoreAdd")
    @ResponseBody
    public boolean guruMoreAdd(MultipartFile file){
        ImportParams params = new ImportParams();
        //设置表格标题行数(默认0)
        params.setTitleRows(0);
        //设置表头行数（默认1）
        params.setHeadRows(1);
        try {
            List<Guru> list = ExcelImportUtil.importExcel(file.getInputStream(),Guru.class, params);
            for (Guru guru : list) {
                System.out.println(guru);
            }
            guruService.addBatchGuru(list);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }




    @RequestMapping("/exportExcel")
    @ResponseBody
    public boolean exprotExcel(HttpServletResponse response){
        try {
            List<Guru> gurus = guruService.queryAllGuru();
            ExportParams params = new ExportParams();
            params.setTitle("上师信息");
            Workbook workbook = ExcelExportUtil.exportBigExcel(params, Guru.class, gurus);
            ServletOutputStream out = response.getOutputStream();

            String fileName = new String("上师信息.xlsx".getBytes(), "ISO-8859-1");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("content-disposition","attachment;fileName="+fileName);
            workbook.write(out);
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("/showAllGuruForPage")
    @ResponseBody
    public Map<String,Object> showAllGuruForPage(Integer page, Integer rows){
        Map<String, Object> map = guruService.quertGuruForPage((page - 1) * rows, rows);
        return map;
    }

    @RequestMapping("/showByKeywords")
    @ResponseBody
    public Map<String,Object> showByKeywords(Integer page, Integer rows,String keywords){
        Map<String, Object> map = guruService.queryGuruBykeywords((page - 1) * rows, rows,keywords);
        return map;
    }
    @RequestMapping("/queryGuruById")
    @ResponseBody
    public Guru queryGuruById(Integer id){
        Guru guru = guruService.queryGuruById(id);
        return guru;
    }
    @RequestMapping("/modifyGuru")
    @ResponseBody
    public boolean modifyGuru(Guru guru){
        int i = guruService.modifyGuruById(guru);
        if(i!=0){
            return true;
        }else{
            return false;
        }

    }

}
