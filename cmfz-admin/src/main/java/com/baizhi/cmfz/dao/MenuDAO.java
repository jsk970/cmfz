package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

public interface MenuDAO {
    /**
     * 查询所有菜单
     * @return list
     */
    public List<Menu> selectAllMenu();
}
