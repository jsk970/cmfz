package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
    private Integer id;
    private String name;
    private String author;
    private Date publishedDate;
    private String context;
    private String state;

    public Article() {
    }

    public Article(Integer id, String name, String author, Date publishedDate, String context, String state) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishedDate = publishedDate;
        this.context = context;
        this.state = state;
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishedDate=" + publishedDate +
                ", context='" + context + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
