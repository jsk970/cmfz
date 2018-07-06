package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Guru;

import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-06 15:22
 */
public interface GuruService {
    public int batchAddGuru(List<Guru> list);

    public Map<String,Object> quertGuruForPage(Integer start, Integer pageSize);

}
