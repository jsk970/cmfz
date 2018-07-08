package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.GuruDAO;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.Pic;
import com.baizhi.cmfz.service.GuruService;
import com.baizhi.cmfz.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-06 15:23
 */
@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDAO guruDAO;

    @Override
    @Transactional
    public int addGuru(Guru guru, MultipartFile file, HttpSession session) {
        try {
            String fileName = UUID.randomUUID().toString().replace("-","");
            String oldName = file.getOriginalFilename();
            fileName += oldName.substring(oldName.lastIndexOf("."));
            guru.setPicPath(fileName);
            FileUtil.uploadFile(file, session,fileName);
            int i = guruDAO.insertGuru(guru);

            return i;
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public int batchAddGuru(List<Guru> list) {
        int i = guruDAO.batchInsert(list);
        return i;
    }

    @Override
    @Transactional
    public Map<String, Object> quertGuruForPage(Integer start, Integer pageSize) {

        HashMap<String, Object> map = new HashMap<>();

        List<Guru> Gurus = guruDAO.selectAllGuruForPage(start,pageSize);
        int count = guruDAO.count();
        map.put("rows", Gurus);
        map.put("total", count);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> queryGuruBykeywords(Integer start, Integer pageSize, String keywords) {

        HashMap<String, Object> map = new HashMap<>();

        List<Guru> Gurus = guruDAO.selectGuruBykeywords(start,pageSize,"%"+keywords+"%");


        int count = guruDAO.keywordsCount("%"+keywords+"%");
        System.out.println(count);
        map.put("rows", Gurus);
        map.put("total", count);
        return map;
    }

    @Override
    @Transactional
    public int modifyGuruById(Guru guru) {
        int i = guruDAO.updateGuruById(guru);
        return i;
    }

    @Override
    @Transactional
    public Guru queryGuruById(Integer id) {
        Guru guru = guruDAO.selectGuruById(id);

        return guru;
    }

    @Override
    public List<Guru> queryAllGuru() {
        List<Guru> gurus = guruDAO.selectAllGuru();
        return gurus;
    }
}
