package com.baizhi.cmfz.entity;

import java.io.Serializable;

public class Guru implements Serializable {
    private Integer id;
    private String name;
    private String summar;
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
