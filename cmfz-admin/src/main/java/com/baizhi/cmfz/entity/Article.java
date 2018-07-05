package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
    private Integer id;
    private String name;
    private String author;
    private Date publishedDate;
    private String info;
    private String picPath;

    public Article() {
    }

    public Article(Integer id, String name, String author, Date publishedDate, String info, String picPath) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishedDate = publishedDate;
        this.info = info;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishedDate=" + publishedDate +
                ", info='" + info + '\'' +
                ", picPath='" + picPath + '\'' +
                '}';
    }
}
