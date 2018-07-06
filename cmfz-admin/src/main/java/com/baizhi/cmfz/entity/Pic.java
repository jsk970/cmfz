package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

public class Pic implements Serializable {
    private Integer id;
    private String path;
    private String state;
    private String description;
    private Date publishedDate;

    public Pic() {
    }

    public Pic(Integer id, String path, String state, String description, Date publishedDate) {
        this.id = id;
        this.path = path;
        this.state = state;
        this.description = description;
        this.publishedDate = publishedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "Pic{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", state='" + state + '\'' +
                ", description='" + description + '\'' +
                ", publishedDate=" + publishedDate +
                '}';
    }
}
