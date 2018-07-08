package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.Pic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: cmfz
 * @description: 上师管理
 * @author: Elk love madness
 * @create: 2018-07-06 15:18
 */
public interface GuruDAO {




    public int insertGuru(Guru guru);
    /**
     *批量添加上师
     */
    public int batchInsert(List<Guru> list);

    /**
     *分页查询上师信息
     * @param start
     * @param pageSize
     * @return
     */
    public List<Guru> selectAllGuruForPage(@Param("start")Integer start, @Param("pageSize")Integer pageSize);

    /**
     *上师信息记录总数
     * @return
     */
    public int count();

    /**
     * 分页模糊查询上师信息
     * @param start
     * @param pageSize
     * @param keywords
     * @return
     */
    public List<Guru> selectGuruBykeywords(@Param("start")Integer start, @Param("pageSize")Integer pageSize,@Param("keywords")String keywords);

    /**
     * 关键字查询记录总数
     * @param keywords
     * @return
     */
    public int keywordsCount(String keywords);

    /**
     * 更新上师信息
     * @param id
     * @return
     */
    public int updateGuruById(Guru Guru);

    /**
     * 通过id查找上师
     * @param id
     * @return
     */
    public Guru selectGuruById(Integer id);


    /**
     * 查询所有上师信息导出excel
     * @return
     */
    public List<Guru> selectAllGuru();





}
