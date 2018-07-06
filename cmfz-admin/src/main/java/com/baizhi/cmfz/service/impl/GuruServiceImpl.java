package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.GuruDAO;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
