package com.baizhi.aspectj;

import com.baizhi.cmfz.entity.Guru;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-09 19:03
 */
public class GuruServiceImpl implements GuruService {
    @Override
    public Guru addGuru(Guru guru) {
        System.out.println("------GuruServiceImpl-------");
        //System.out.println(guru);
        return guru;
    }
}
