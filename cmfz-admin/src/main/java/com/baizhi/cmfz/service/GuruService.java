package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Guru;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description:
 * @author: Elk love madness
 * @create: 2018-07-06 15:22
 */
public interface GuruService {
    public int addGuru(Guru guru, MultipartFile file, HttpSession session);

    public int addBatchGuru(List<Guru> list);

    public Map<String,Object> quertGuruForPage(Integer start, Integer pageSize);

    public Map<String,Object> queryGuruBykeywords(Integer start, Integer pageSize,String keywords);

    public int modifyGuruById(Guru guru);

    public Guru queryGuruById(Integer id);

    public List<Guru> queryAllGuru();





}
