package com.baizhi.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

public class Guru implements Serializable {
    //@Excel(name = "编号",orderNum = "1")
    private Integer id;
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "简介")
    private String summar;
    @Excel(name = "图片地址",width=40.0)
    private String picPath;

    public Guru() {
    }

    public Guru(Integer id, String name, String summar, String picPath) {
        this.id = id;
        this.name = name;
        this.summar = summar;
        this.picPath = picPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummar() {
        return summar;
    }

    public void setSummar(String summar) {
        this.summar = summar;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", summar='" + summar + '\'' +
                ", picPath='" + picPath + '\'' +
                '}';
    }
}
