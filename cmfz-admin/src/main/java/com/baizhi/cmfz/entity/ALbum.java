package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

public class ALbum implements Serializable {
    private Integer id;
    private String name;
    private Integer score;
    private String author;
    private String albumCv;
    private String introduction;
    private Date published_date;
    private String picPath;
    private Integer count;

    public ALbum() {
    }

    public ALbum(Integer id, String name, Integer score, String author, String albumCv, String introduction, Date published_date, String picPath, Integer count) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.author = author;
        this.albumCv = albumCv;
        this.introduction = introduction;
        this.published_date = published_date;
        this.picPath = picPath;
        this.count = count;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAlbumCv() {
        return albumCv;
    }

    public void setAlbumCv(String albumCv) {
        this.albumCv = albumCv;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getPublished_date() {
        return published_date;
    }

    public void setPublished_date(Date published_date) {
        this.published_date = published_date;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ALbum{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", albumCv='" + albumCv + '\'' +
                ", introduction='" + introduction + '\'' +
                ", published_date=" + published_date +
                ", picPath='" + picPath + '\'' +
                ", count=" + count +
                '}';
    }
}
